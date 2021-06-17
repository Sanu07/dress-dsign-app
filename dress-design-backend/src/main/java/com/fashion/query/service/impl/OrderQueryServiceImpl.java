package com.fashion.query.service.impl;

import java.util.HashSet;

import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fashion.dto.Customer;
import com.fashion.dto.Feedback;
import com.fashion.dto.Order;
import com.fashion.query.dao.CustomerQueryDao;
import com.fashion.query.dao.OrderQueryDao;
import com.fashion.query.service.CustomerQueryService;
import com.fashion.query.service.FeedbackQueryService;
import com.fashion.query.service.OrderQueryService;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class OrderQueryServiceImpl extends BaseServiceImpl implements OrderQueryService {

	private final OrderQueryDao orderDao;
	private final CustomerQueryDao customerDao;
	private FeedbackQueryService feedbackService;
	private CustomerQueryService customerService;
	
	public OrderQueryServiceImpl(OrderQueryDao orderDao, CustomerQueryDao customerDao,
			@Lazy FeedbackQueryService feedbackService, @Lazy CustomerQueryService customerService) {
		super();
		this.orderDao = orderDao;
		this.customerDao = customerDao;
		this.feedbackService = feedbackService;
		this.customerService = customerService;
	}

	@Override
	public Flux<Order> getAllOrders() {
		return orderDao.findAll();
	}

	@Override
	public Mono<Order> getOrderById(String orderId) {
		return orderDao.findById(orderId);
	}

	@Override
	public ResponseEntity<Order> saveOrder(Order order) {
		orderDao.save(order).subscribe(ord -> {
			log.info("Order saved in db {} ", ord);
			updateCustomerWithOrder(ord);
		});
		return ResponseEntity.ok(order);
	}

	@Override
	public ResponseEntity<Order> updateOrder(Order order) {
		orderDao.save(order).subscribe(ord -> {
			log.info("Order saved in db {} ", ord);
			updateCustomerWithOrder(ord);
		});
		return ResponseEntity.ok(order);
	}

	@Override
	public Mono<Order> deleteOrderById(Order order) {
		Boolean acknowledged = updateSingleObject(Order.class, order.getId(), "status", false, Boolean.class);
		if (acknowledged) {
			log.info("Order {} deleted successfully ", order);
			feedbackService.deleteFeedbacksByOrderId(order.getOrderId());
			customerService.deleteOrderFromCustomer(order);
		}
		return Mono.empty();
	}

	@Override
	public void updateCustomerWithOrder(Order order) {
		if (StringUtils.isNotEmpty(order.getCustomerId())) {
			Mono<Customer> custMono = customerDao.findByCustomerId(order.getCustomerId());
			custMono.subscribe(c -> {
				if (c != null) {
					log.info("Found Customer {} ", c);
					if (c.getOrders() == null) {
						c.setOrders(new HashSet<>());
					}
					c.getOrders().add(order);
					customerDao.save(c).subscribe(cust -> {
						log.info("Customer saved in DB {} ", cust);
					});
				}
			});
		}
	}

	@Override
	public void deleteOrdersByCutomerId(String customerId) {
		Boolean acknowledged = updateMultipleObjects(Order.class, "customerId", customerId, String.class, "status", false, Boolean.class);
		if (acknowledged) {
			feedbackService.deleteFeedbacksByCustomerId(customerId);
		}
	}
	
}

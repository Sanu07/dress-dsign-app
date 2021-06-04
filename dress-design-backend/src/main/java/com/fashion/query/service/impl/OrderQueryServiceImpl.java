package com.fashion.query.service.impl;

import java.util.HashSet;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fashion.dto.Customer;
import com.fashion.dto.Order;
import com.fashion.query.dao.CustomerQueryDao;
import com.fashion.query.dao.OrderQueryDao;
import com.fashion.query.service.OrderQueryService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
@Slf4j
public class OrderQueryServiceImpl implements OrderQueryService {

	private OrderQueryDao orderDao;
	private CustomerQueryDao customerDao;

	@Override
	public Flux<Order> getAllOrders() {
		return orderDao.findAll();
	}

	@Override
	public Mono<Order> getOrderById(UUID orderId) {
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
	public Mono<Order> deleteOrderById(UUID orderId) {
		return orderDao.deleteOrderById(orderId, false);
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

}

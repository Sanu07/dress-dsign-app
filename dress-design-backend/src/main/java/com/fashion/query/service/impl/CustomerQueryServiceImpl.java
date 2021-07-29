package com.fashion.query.service.impl;

import java.util.HashSet;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.fashion.dto.Customer;
import com.fashion.dto.Order;
import com.fashion.query.dao.CustomerQueryDao;
import com.fashion.query.service.CustomerQueryService;
import com.fashion.query.service.OrderQueryService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Slf4j
@AllArgsConstructor
public class CustomerQueryServiceImpl extends BaseServiceImpl implements CustomerQueryService {

	private CustomerQueryDao customerDao;
	private OrderQueryService orderService;

	@Override
	public Flux<Customer> getAllCustomers() {
		return customerDao.findAll();
	}

	@Override
	public Mono<Customer> getCustomerById(String customerId) {
		return customerDao.findById(customerId);
	}

	@Override
	public Mono<Customer> saveCustomer(Customer customer) {
		return customerDao.save(customer);
	}

	@Override
	public Mono<Customer> updateCustomer(Customer customer) {
		return customerDao.save(customer);
	}

	@Override
	public Mono<Void> deleteCustomerById(Customer customer) {
		Boolean acknowledged = updateSingleObject(Customer.class, customer.getId(), "status", false, Boolean.class);
		if (acknowledged) {
			log.info("Customer {} deleted successfully ", customer);
			orderService.deleteOrdersByCutomerId(customer.getCustomerId());
		}
		return Mono.empty();
	}

	@Override
	public Mono<Customer> updateCustomerWithOrder(Order order) {
		Mono<Customer> customer = customerDao.findByCustomerId(order.getCustomerId());
		customer.subscribe(cust -> {
			if (cust != null) {
				if (cust.getOrders() == null) {
					cust.setOrders(new HashSet<>());
				}
				cust.getOrders().add(order);
				final Query query = new Query();
				query.addCriteria(Criteria.where("_id").is(cust.getId()));
				final Update update = new Update().addToSet("orders", order);
				Boolean acknowledged = mongoTemplate.updateFirst(query, update, Customer.class).wasAcknowledged();
				if (acknowledged) {
					log.info("Customer {} updated with order {} ", cust, order);
				}
			}
		});
		return customer;
	}

	@Override
	public void deleteOrderFromCustomer(Order order) {
		Mono<Customer> customer = customerDao.findByCustomerId(order.getCustomerId());
		customer.subscribe(cust -> {
			if (cust != null && cust.getOrders() != null) {
				Boolean acknowledged = updateParticularField(cust.getClass(), cust.getId(), "orders", "orderId",
						order.getOrderId(), order.getOrderId().getClass(), "status", false, Boolean.class);
				if (acknowledged) {
					log.info("Deleted Order {} from customer {} ", order, cust);
				}
			}
		});
	}

	@Override
	public Mono<Customer> getCustomerByCustomerId(String customerId) {
		return customerDao.findByCustomerId(customerId);
	}
	
}

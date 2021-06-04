package com.fashion.query.service.impl;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.fashion.dto.Customer;
import com.fashion.dto.Order;
import com.fashion.query.dao.CustomerQueryDao;
import com.fashion.query.service.CustomerQueryService;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class CustomerQueryServiceImpl implements CustomerQueryService {

	private CustomerQueryDao customerDao;

	@Override
	public Flux<Customer> getAllCustomers() {
		return customerDao.findAll();
	}

	@Override
	public Mono<Customer> getCustomerById(UUID customerId) {
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
	public Mono<Customer> deleteCustomerById(UUID customerId) {
		return customerDao.deleteCustomerById(customerId, false);
	}

	@Override
	public Mono<Customer> updateCustomerWithOrder(Order order) {
		Customer customer = customerDao.findByCustomerId(order.getCustomerId()).block();
		customer.getOrders().add(order);
		return updateCustomer(customer);
	}

}

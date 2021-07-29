package com.fashion.query.service;

import com.fashion.dto.Customer;
import com.fashion.dto.Order;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CustomerQueryService {

	public Mono<Customer> saveCustomer(Customer customer);

	public Flux<Customer> getAllCustomers();

	public Mono<Customer> getCustomerById(String customerId);
	
	public Mono<Customer> getCustomerByCustomerId(String customerId);
	
	public Mono<Customer> updateCustomer(Customer customer);
	
	public Mono<Customer> updateCustomerWithOrder(Order order);
	
	public Mono<Void> deleteCustomerById(Customer customer);

	public void deleteOrderFromCustomer(Order order);

}

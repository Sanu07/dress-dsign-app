package com.fashion.query.service;

import java.util.UUID;

import com.fashion.dto.Customer;
import com.fashion.dto.Order;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CustomerQueryService {

	public Mono<Customer> saveCustomer(Customer customer);

	public Flux<Customer> getAllCustomers();

	public Mono<Customer> getCustomerById(UUID customerId);
	
	public Mono<Customer> updateCustomer(Customer customer);
	
	public Mono<Customer> updateCustomerWithOrder(Order order);
	
	public Mono<Customer> deleteCustomerById(UUID customerId);

}

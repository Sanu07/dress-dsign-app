package com.fashion.query.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.fashion.dto.Customer;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CustomerQueryService {
	
	public Flux<Customer> getAllCustomers();
	
	public Mono<Customer> getCustomerById(UUID customerId);
}

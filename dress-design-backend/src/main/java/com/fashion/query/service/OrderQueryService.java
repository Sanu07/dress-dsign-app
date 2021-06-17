package com.fashion.query.service;

import org.springframework.http.ResponseEntity;

import com.fashion.dto.Order;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface OrderQueryService {
	
	ResponseEntity<Order> saveOrder(Order order);

	Flux<Order> getAllOrders();

	Mono<Order> getOrderById(String orderId);
	
	ResponseEntity<Order> updateOrder(Order order);
	
	void updateCustomerWithOrder(Order order);

	Mono<Order> deleteOrderById(Order order);

	void deleteOrdersByCutomerId(String customerId);
	
}

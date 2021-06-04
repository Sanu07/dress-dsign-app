package com.fashion.query.service;

import java.util.UUID;

import org.springframework.http.ResponseEntity;

import com.fashion.dto.Order;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface OrderQueryService {
	
	public ResponseEntity<Order> saveOrder(Order order);

	public Flux<Order> getAllOrders();

	public Mono<Order> getOrderById(UUID orderId);
	
	public ResponseEntity<Order> updateOrder(Order order);
	
	public void updateCustomerWithOrder(Order order);

	public Mono<Order> deleteOrderById(UUID orderId);
}

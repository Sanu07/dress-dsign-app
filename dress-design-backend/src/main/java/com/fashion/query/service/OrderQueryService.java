package com.fashion.query.service;

import java.util.UUID;

import com.fashion.dto.Order;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface OrderQueryService {
	
	public Flux<Order> getAllOrders();
	
	public Mono<Order> getOrderById(UUID orderId);
}

package com.fashion.query.service;

import java.util.UUID;

import com.fashion.dto.Orders;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface OrderQueryService {
	
	public Flux<Orders> getAllOrders();
	
	public Mono<Orders> getOrderById(UUID orderId);
}

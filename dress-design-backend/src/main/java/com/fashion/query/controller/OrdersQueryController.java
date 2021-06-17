package com.fashion.query.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fashion.dto.Order;
import com.fashion.query.service.OrderQueryService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("orders")
@CrossOrigin("*")
public class OrdersQueryController {

	@Autowired
	private OrderQueryService orderService;
	
	@GetMapping
	public Flux<Order> getAllCustomers() {
		return orderService.getAllOrders();
	}
	
	@GetMapping("/{uuid}")
	public Mono<Order> getCustomerById(@PathVariable String uuid) {
		return orderService.getOrderById(uuid);
	}
}

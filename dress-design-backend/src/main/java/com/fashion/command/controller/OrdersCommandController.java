package com.fashion.command.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fashion.command.service.OrdersCommandService;
import com.fashion.entity.Orders;

@RestController
@RequestMapping("/orders") 
@CrossOrigin(origins = "*")
public class OrdersCommandController {

	@Autowired
	OrdersCommandService orderService;
	
	@PostMapping
	public Orders saveOrder(@RequestBody Orders order) {
		return orderService.saveOrder(order);
	}
	
	@PutMapping
	public Orders updateOrder(@RequestBody Orders order) {
		return orderService.updateOrder(order);
	}
	
	@DeleteMapping("/{orderId}")
	public void deleteOrder(@PathVariable UUID orderId) {
		orderService.deleteOrder(orderId);
	}
}

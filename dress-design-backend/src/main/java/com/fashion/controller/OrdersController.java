package com.fashion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fashion.model.Orders;
import com.fashion.service.OrdersService;

@RestController
@CrossOrigin("*")
public class OrdersController {

	@Autowired
	OrdersService ordersService;
	
	@PostMapping("/orders")
	public Orders saveOrder(@RequestBody Orders Order) {
		return ordersService.saveOrder(Order);
	}
	
	@GetMapping("/orders")
	public List<Orders> getAllOrders() {
		return (List<Orders>) ordersService.getAllOrders();
	}
	
	@GetMapping("/orders/{orderId}")
	public Orders getOrder(@PathVariable("orderId") long orderId) {
		return ordersService.getOrder(orderId);
	}
	
	@PutMapping("/orders")
	public Orders updateOrder(@RequestBody Orders Order) {
		return ordersService.updateOrder(Order);
	}
	
	@DeleteMapping("/orders/{orderId}")
	public void deleteOrder(@PathVariable("orderId") long orderId) {
		ordersService.deleteOrder(orderId);;
	}
}

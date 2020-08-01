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
import com.fashion.model.Payment;
import com.fashion.model.ReceivedDates;
import com.fashion.service.OrdersService;
import com.fashion.service.PaymentsService;

@RestController
@CrossOrigin("*")
public class OrdersController {

	@Autowired
	OrdersService ordersService;
	
	@Autowired
	PaymentsService paymentsService;
	
	@PostMapping("/orders")
	public Orders saveOrder(@RequestBody Orders order) {
		System.out.println(order.getDress());
		System.out.println(order.getPayment());
		System.out.println(order.getPayment().getReceivedDates());
		order.getDress().setOrders(order);
		order.getPayment().setOrder(order);
		return ordersService.saveOrder(order);
	}
	
	public Payment savePayment(@RequestBody Payment payment) {
		return paymentsService.savePayment(payment);
	}
	
	@GetMapping("/orders")
	public List<Orders> getAllOrders() {
		return (List<Orders>) ordersService.getAllOrders();
	}
	
	@GetMapping("/orders/{orderId}")
	public Orders getOrder(@PathVariable("orderId") String orderId) {
		return ordersService.getOrder(orderId);
	}
	
	@PutMapping("/orders")
	public Orders updateOrder(@RequestBody Orders Order) {
		return ordersService.updateOrder(Order);
	}
	
	@DeleteMapping("/orders/{orderId}")
	public void deleteOrder(@PathVariable("orderId") String orderId) {
		ordersService.deleteOrder(orderId);;
	}
}

package com.fashion.command.controller;

import java.util.Random;
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

import com.fashion.command.dao.CustomerCommandDao;
import com.fashion.command.service.OrderCommandService;
import com.fashion.entity.Order;
import com.fashion.enums.OrderStatusEnum;
import com.fashion.util.ReferenceIDGenerator;

@RestController
@RequestMapping("/orders")
@CrossOrigin(origins = "*")
public class OrderCommandController {

	@Autowired
	OrderCommandService orderService;

	@Autowired
	CustomerCommandDao customerDao;

	@PostMapping
	public Order saveOrder(@RequestBody Order order) {
		order.setStatus(true);
		order.setOrderStatus(OrderStatusEnum.CREATED);
		order.setOrderId(ReferenceIDGenerator.getGeneratedIdOrderId(order.getCustomer().getCustomerName()));
		return orderService.saveOrder(order);
	}

	@PutMapping
	public Order updateOrder(@RequestBody Order order) {
		return orderService.updateOrder(order);
	}

	@DeleteMapping("/{orderId}")
	public void deleteOrder(@PathVariable UUID orderId) {
		orderService.deleteOrder(orderId);
	}
}

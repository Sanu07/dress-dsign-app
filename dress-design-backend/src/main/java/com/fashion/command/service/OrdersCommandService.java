package com.fashion.command.service;

import java.util.UUID;

import com.fashion.entity.Order;

public interface OrdersCommandService {

	public Order saveOrder(Order order);

	public Order updateOrder(Order order);

	public void deleteOrder(UUID orderId);

}

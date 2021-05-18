package com.fashion.command.service;

import java.util.UUID;

import com.fashion.entity.Orders;

public interface OrdersCommandService {

	public Orders saveOrder(Orders order);

	public Orders updateOrder(Orders order);

	public void deleteOrder(UUID orderId);

}

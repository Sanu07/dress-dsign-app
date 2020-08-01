package com.fashion.service;

import com.fashion.model.Orders;

public interface OrdersService {

	public Orders saveOrder(Orders order);

	public Orders updateOrder(Orders order);

	public Iterable<Orders> getAllOrders();

	public Orders getOrder(String orderId);

	public void deleteOrder(String orderId);
}

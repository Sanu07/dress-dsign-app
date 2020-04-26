package com.fashion.service;

import com.fashion.model.Orders;

public interface OrdersService {

	public Orders saveOrder(Orders order);

	public Orders updateOrder(Orders order);

	public Iterable<Orders> getAllOrders();

	public Orders getOrder(long orderId);

	public void deleteOrder(long orderId);
}

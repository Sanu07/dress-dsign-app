package com.fashion.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fashion.dao.OrdersDao;
import com.fashion.model.Orders;
import com.fashion.service.OrdersService;

@Service
public class OrdersServiceImpl implements OrdersService {

	@Autowired
	OrdersDao ordersDao;
	
	@Override
	public Orders saveOrder(Orders order) {
		return ordersDao.save(order);
	}

	@Override
	public Orders updateOrder(Orders order) {
		return ordersDao.save(order);
	}

	@Override
	public Iterable<Orders> getAllOrders() {
		return ordersDao.findAll();
	}

	@Override
	public Orders getOrder(String orderId) {
		return ordersDao.findById(orderId).orElse(null);
	}

	@Override
	public void deleteOrder(String orderId) {
		ordersDao.deleteById(orderId);
	}

}

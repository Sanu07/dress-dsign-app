package com.fashion.command.service.impl;

import java.util.UUID;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

import com.fashion.command.dao.OrderCommandDao;
import com.fashion.command.service.OrderCommandService;
import com.fashion.entity.Order;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class OrderCommandServiceImpl implements OrderCommandService {

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	@Autowired
	private final ObjectMapper mapper = new ObjectMapper();

	@Autowired
	private OrderCommandDao orderDao;

	public OrderCommandServiceImpl(OrderCommandDao orderDao) {
		this.orderDao = orderDao;
	}

	@Override
	public Order saveOrder(Order order) {
		Order savedOrder = orderDao.save(order);
		// sendOrderRegistrationEvent(savedOrder);
		return savedOrder;
	}

	@Override
	public Order updateOrder(Order order) {
		return orderDao.save(order);
	}

	@Override
	public void deleteOrder(UUID orderId) {
		orderDao.deleteById(orderId);
	}

}

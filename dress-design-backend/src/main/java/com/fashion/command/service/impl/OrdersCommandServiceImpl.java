package com.fashion.command.service.impl;

import java.util.UUID;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

import com.fashion.command.dao.OrdersCommandDao;
import com.fashion.command.service.OrdersCommandService;
import com.fashion.entity.Orders;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class OrdersCommandServiceImpl implements OrdersCommandService {

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	private static final ObjectMapper mapper = new ObjectMapper();

	private OrdersCommandDao orderDao;

	public OrdersCommandServiceImpl(OrdersCommandDao orderDao) {
		this.orderDao = orderDao;
	}

	@Override
	public Orders saveOrder(Orders order) {
		Orders savedOrder = orderDao.save(order);
		sendOrderRegistrationEvent(savedOrder);
		return savedOrder;
	}

	@Override
	public Orders updateOrder(Orders order) {
		return orderDao.save(order);
	}

	@Override
	public void deleteOrder(UUID orderId) {
		orderDao.deleteById(orderId);
	}

	private void sendOrderRegistrationEvent(Orders order) {
		ListenableFuture<SendResult<String, String>> future = null;
		try {
			future = kafkaTemplate.send("orders", "order_event", mapper.writeValueAsString(order));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		try {
			System.out.println(future.get().getProducerRecord().value());
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
	}

}

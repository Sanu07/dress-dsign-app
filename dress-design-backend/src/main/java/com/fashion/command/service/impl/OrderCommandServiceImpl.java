package com.fashion.command.service.impl;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.fashion.command.dao.OrderCommandDao;
import com.fashion.command.service.OrderCommandService;
import com.fashion.command.service.kafka.producer.CommandKafkaProducer;
import com.fashion.constants.AppConstants;
import com.fashion.entity.Order;
import com.fashion.util.EntityToDTOConverter;
import com.fasterxml.jackson.core.JsonProcessingException;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class OrderCommandServiceImpl implements OrderCommandService {

	private OrderCommandDao orderDao;
	private final CommandKafkaProducer kafkaProducer;

	@Override
	public Order saveOrder(Order order) {
		Order savedOrder = orderDao.save(order);
		try {
			kafkaProducer.sendEvent(EntityToDTOConverter.createDTOOrder(savedOrder),
					AppConstants.DRESS_ORDER_CREATE_EVENT_KEY, AppConstants.DRESS_ORDER_EVENTS_TOPIC,
					AppConstants.CREATE_EVENT_PARTITION);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		return savedOrder;
	}

	@Override
	public Order updateOrder(Order order) {
		Order updatedOrder = orderDao.save(order);
		try {
			kafkaProducer.sendEvent(updatedOrder, AppConstants.DRESS_ORDER_UPDATE_EVENT_KEY,
					AppConstants.DRESS_ORDER_EVENTS_TOPIC, AppConstants.UPDATE_EVENT_PARTITION);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return updatedOrder;
	}

	@Override
	public void deleteOrder(UUID orderId) {
		Order order = orderDao.findById(orderId).get();
		Order updatedOrder = null;
		if (order != null) {
			order.setStatus(false);
			updatedOrder = orderDao.saveAndFlush(order);
			try {
				kafkaProducer.sendEvent(updatedOrder, AppConstants.DRESS_ORDER_DELETE_EVENT_KEY,
						AppConstants.DRESS_ORDER_EVENTS_TOPIC, AppConstants.DELETE_EVENT_PARTITION);
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
		}
	}

}

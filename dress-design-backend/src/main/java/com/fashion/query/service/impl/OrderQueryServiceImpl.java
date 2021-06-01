package com.fashion.query.service.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.fashion.dto.Order;
import com.fashion.query.dao.OrderQueryDao;
import com.fashion.query.service.OrderQueryService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class OrderQueryServiceImpl implements OrderQueryService {

	@Autowired
	private OrderQueryDao orderDao;

	private ObjectMapper mapper = null;

	@Override
	public Flux<Order> getAllOrders() {
		return orderDao.findAll();
	}

	@Override
	public Mono<Order> getOrderById(UUID orderId) {
		return orderDao.findById(orderId);
	}

	@KafkaListener(topics = "orders")
	public void consume(String order) {
		try {
			mapper = JsonMapper.builder() // or different mapper for other format
					   .addModule(new ParameterNamesModule())
					   .addModule(new Jdk8Module())
					   .addModule(new JavaTimeModule())
					   .build();
			Order cust = mapper.readValue(order, Order.class);
			System.out.println(cust);
			orderDao.save(cust).subscribe(System.out::println);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

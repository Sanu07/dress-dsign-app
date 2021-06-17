package com.fashion.command.service.kafka.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.listener.AcknowledgingMessageListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Service;

import com.fashion.constants.AppConstants;
import com.fashion.dto.Order;
import com.fashion.query.service.OrderQueryService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Service
@Slf4j
@AllArgsConstructor
public class OrderCommandKafkaListener implements AcknowledgingMessageListener<String, String> {

	OrderQueryService orderService;
	ObjectMapper mapper;

	@KafkaListener(topics = { AppConstants.DRESS_ORDER_EVENTS_TOPIC })
	@Override
	public void onMessage(ConsumerRecord<String, String> consumerRecord, Acknowledgment acknowledgment) {
		log.info("ConsumerRecord : {} ", consumerRecord);
		Order order = null;
		if (consumerRecord.partition() == 1) {
			try {
				order = mapper.readValue(consumerRecord.value(), Order.class);
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
			orderService.saveOrder(order);
		} else if (consumerRecord.partition() == 2) {
			try {
				order = mapper.readValue(consumerRecord.value(), Order.class);
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
			if (order.getId() != null) {
				orderService.saveOrder(order);
			}
		} else {
			try {
				order = mapper.readValue(consumerRecord.value(), Order.class);
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
			Mono<Order> dbOrder = orderService.getOrderById(order.getId());
			dbOrder.doOnNext(ord -> {
				orderService.deleteOrderById(ord)
						.subscribe(o -> log.info("Order updated in MongoDB {} ", o));
				
			});
		}
		acknowledgment.acknowledge();
	}

}

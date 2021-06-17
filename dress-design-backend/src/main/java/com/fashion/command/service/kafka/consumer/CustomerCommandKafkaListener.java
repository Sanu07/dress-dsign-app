package com.fashion.command.service.kafka.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.listener.AcknowledgingMessageListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Service;

import com.fashion.constants.AppConstants;
import com.fashion.dto.Customer;
import com.fashion.query.service.CustomerQueryService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class CustomerCommandKafkaListener implements AcknowledgingMessageListener<String, String> {

	@Autowired
	CustomerQueryService customerService;

	@Autowired
	ObjectMapper mapper;

	@KafkaListener(topics = { AppConstants.DRESS_CUSTOMER_EVENTS_TOPIC })
	@Override
	public void onMessage(ConsumerRecord<String, String> consumerRecord, Acknowledgment acknowledgment) {
		log.info("ConsumerRecord : {} ", consumerRecord);
		Customer customer = null;
		if (consumerRecord.partition() == 1) {
			try {
				customer = mapper.readValue(consumerRecord.value(), Customer.class);
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
			customerService.saveCustomer(customer).subscribe(cust -> log.info("Customer Saved in MongoDB {} ", cust));
		} else if (consumerRecord.partition() == 2) {
			try {
				customer = mapper.readValue(consumerRecord.value(), Customer.class);
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
			if (customer.getId() != null) {
				customerService.saveCustomer(customer).subscribe(cust -> log.info("Customer updated in MongoDB {} ", cust));
			}
		} else {
			try {
				String customerId = mapper.readValue(consumerRecord.value(), String.class);
				Mono<Customer> dbCustomer = customerService.getCustomerById(customerId);
				dbCustomer.subscribe(cust -> {
					customerService.deleteCustomerById(cust)
							.subscribe(c -> log.info("Customer updated(deleted) in MongoDB {} ", c));
				});
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
		}
		acknowledgment.acknowledge();
	}

}

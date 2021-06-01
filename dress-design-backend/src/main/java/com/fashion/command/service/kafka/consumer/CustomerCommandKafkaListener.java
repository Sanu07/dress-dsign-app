package com.fashion.command.service.kafka.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.listener.AcknowledgingMessageListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Service;

import com.fashion.constants.AppConstants;
import com.fashion.dto.Customer;
import com.fashion.query.dao.CustomerQueryDao;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CustomerCommandKafkaListener implements AcknowledgingMessageListener<String,String> {

	@Autowired
	CustomerQueryDao customerService;
	
	@Autowired
	ObjectMapper mapper;
	
	@KafkaListener(topics = { AppConstants.DRESS_CUSTOMER_EVENTS })
	@Override
	public void onMessage(ConsumerRecord<String, String> consumerRecord, Acknowledgment acknowledgment) {
		log.info("ConsumerRecord : {} ", consumerRecord );
        acknowledgment.acknowledge();
        if (consumerRecord.partition() == 1) {
        	Customer customer = null;
			try {
				customer = mapper.readValue(consumerRecord.value(), Customer.class);
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
        	customerService.save(customer).subscribe(cust -> log.info("Customer Saved in MongoDB {} ", cust));
        }
	}

}

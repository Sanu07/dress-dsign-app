package com.fashion.command.service.impl;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.fashion.command.dao.CustomerCommandDao;
import com.fashion.command.service.CustomerCommandService;
import com.fashion.command.service.kafka.producer.CommandKafkaProducer;
import com.fashion.constants.AppConstants;
import com.fashion.entity.Customer;
import com.fasterxml.jackson.core.JsonProcessingException;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CustomerCommandServiceImpl implements CustomerCommandService {

	private final CustomerCommandDao customerDao;
	private final CommandKafkaProducer kafkaProducer;
	
	@Override
	public Customer saveCustomer(Customer customer) {
		Customer savedCustomer = customerDao.save(customer);
		try {
			kafkaProducer.sendEvent(savedCustomer, AppConstants.DRESS_CUSTOMER_CREATE_EVENT_KEY,
					AppConstants.DRESS_CUSTOMER_EVENTS_TOPIC, AppConstants.CREATE_EVENT_PARTITION);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return savedCustomer;
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		Customer updatedCustomer = customerDao.save(customer);
		try {
			kafkaProducer.sendEvent(updatedCustomer, AppConstants.DRESS_CUSTOMER_UPDATE_EVENT_KEY,
					AppConstants.DRESS_CUSTOMER_EVENTS_TOPIC, AppConstants.UPDATE_EVENT_PARTITION);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return updatedCustomer;
	}

	@Override
	public void deleteCustomer(UUID customerId) {
		customerDao.deleteById(customerId);
		try {
			kafkaProducer.sendEvent(customerId, AppConstants.DRESS_CUSTOMER_DELETE_EVENT_KEY,
					AppConstants.DRESS_CUSTOMER_EVENTS_TOPIC, AppConstants.DELETE_EVENT_PARTITION);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}

}
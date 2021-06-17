package com.fashion.command.service.impl;

import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

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

	private CustomerCommandDao customerDao;
	private CommandKafkaProducer kafkaProducer;

	@Override
	public Customer saveCustomer(Customer customer) {
		Customer savedCustomer = customerDao.save(customer);
		ListenableFuture<SendResult<String, String>> sentEvent = null;
		try {
			sentEvent = kafkaProducer.sendEvent(savedCustomer, AppConstants.DRESS_CUSTOMER_CREATE_EVENT_KEY,
					AppConstants.DRESS_CUSTOMER_EVENTS_TOPIC, AppConstants.CREATE_EVENT_PARTITION);
			if (sentEvent.get(5, TimeUnit.SECONDS) != null) {
				return savedCustomer;
			}
		} catch (InterruptedException | ExecutionException | TimeoutException | JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Customer updateCustomer(Customer customer) {

		Customer dbCustomer = customerDao.findById(customer.getId()).get();
		Customer updatedCustomer = null;
		if (dbCustomer != null) {
			updatedCustomer = customerDao.saveAndFlush(customer);
		}

		try {
			kafkaProducer.sendEvent(updatedCustomer, AppConstants.DRESS_CUSTOMER_UPDATE_EVENT_KEY,
					AppConstants.DRESS_CUSTOMER_EVENTS_TOPIC, AppConstants.UPDATE_EVENT_PARTITION);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		return updatedCustomer;
	}

	@Override
	public Customer deleteCustomer(UUID customerId) {
		Customer customer = customerDao.findById(customerId).get();
		Customer cust = null;
		if (customer != null) {
			customer.setStatus(false);
			cust = customerDao.saveAndFlush(customer);
		}

		try {
			kafkaProducer.sendEvent(customerId, AppConstants.DRESS_CUSTOMER_DELETE_EVENT_KEY,
					AppConstants.DRESS_CUSTOMER_EVENTS_TOPIC, AppConstants.DELETE_EVENT_PARTITION);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		return cust;
	}

}

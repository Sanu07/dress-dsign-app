package com.fashion.command.service.impl;

import java.util.UUID;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

import com.fashion.command.dao.CustomersCommandDao;
import com.fashion.command.service.CustomersCommandService;
import com.fashion.entity.Customer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class CustomersCommandServiceImpl implements CustomersCommandService {

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	private static final ObjectMapper mapper = new ObjectMapper();

	private CustomersCommandDao customerDao;

	public CustomersCommandServiceImpl(CustomersCommandDao customerDao) {
		this.customerDao = customerDao;
	}

	@Override
	public Customer saveCustomer(Customer customer) {
		Customer savedCustomer = customerDao.save(customer);
		sendCustomerRegistrationEvent(savedCustomer);
		return savedCustomer;
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		return customerDao.save(customer);
	}

	@Override
	public void deleteCustomer(UUID customerId) {
		customerDao.deleteById(customerId);
	}

	private void sendCustomerRegistrationEvent(Customer customer) {
		ListenableFuture<SendResult<String, String>> future = null;
		try {
			future = kafkaTemplate.send("topic2", "customer_event", mapper.writeValueAsString(customer));
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

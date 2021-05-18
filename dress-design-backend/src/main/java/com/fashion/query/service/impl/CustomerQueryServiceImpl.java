package com.fashion.query.service.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.fashion.dto.Customer;
import com.fashion.query.dao.CustomerQueryDao;
import com.fashion.query.service.CustomerQueryService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CustomerQueryServiceImpl implements CustomerQueryService {

	@Autowired
	private CustomerQueryDao customerDao;

	private ObjectMapper mapper = null;

	@Override
	public Flux<Customer> getAllCustomers() {
		return customerDao.findAll();
	}

	@Override
	public Mono<Customer> getCustomerById(UUID customerId) {
		return customerDao.findById(customerId);
	}

	@KafkaListener(topics = "topic2")
	public void consume(String customer) {
		try {
			mapper = JsonMapper.builder() // or different mapper for other format
					   .addModule(new ParameterNamesModule())
					   .addModule(new Jdk8Module())
					   .addModule(new JavaTimeModule())
					   .build();
			Customer cust = mapper.readValue(customer, Customer.class);
			System.out.println(cust);
			customerDao.save(cust).subscribe(System.out::println);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

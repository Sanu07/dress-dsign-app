package com.fashion.query.service.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.fashion.dto.User;
import com.fashion.query.dao.UserQueryDao;
import com.fashion.query.service.UserQueryService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserQueryServiceImpl implements UserQueryService {

	@Autowired
	private UserQueryDao userDao;
	
	private ObjectMapper mapper = null;
	
	@Override
	public Flux<User> getAllUsers() {
		return userDao.findAll();
	}

	@Override
	public Mono<User> getUserById(UUID userId) {
		return userDao.findById(userId);
	}
	
	@KafkaListener(topics = "user-details")
	public void consume(String kafkaUser) {
		try {
			mapper = JsonMapper.builder() // or different mapper for other format
					   .addModule(new ParameterNamesModule())
					   .addModule(new Jdk8Module())
					   .addModule(new JavaTimeModule())
					   .build();
			User user = mapper.readValue(kafkaUser, User.class);
			System.out.println(user);
			userDao.save(user).subscribe(System.out::println);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

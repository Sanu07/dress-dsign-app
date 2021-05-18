package com.fashion.query.dao.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.fashion.dto.Customer;
import com.fashion.query.dao.CommonQueryDao;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class CommonQueryDaoImpl<T> implements CommonQueryDao<T> {

	@Autowired
	ReactiveMongoTemplate mongoTemplate;
	
	@Override
	public Mono<T> findById(UUID uuid, Class<T> className) {
		Mono<T> objectWithUUID = mongoTemplate.findById(uuid, className);
		return objectWithUUID;
	}

}

package com.fashion.query.dao;

import java.util.UUID;

import org.springframework.stereotype.Repository;

import reactor.core.publisher.Mono;

@Repository
public interface CommonQueryDao<T> {
	
	public Mono<T> findById(UUID uuid, Class<T> dtoClass);
}

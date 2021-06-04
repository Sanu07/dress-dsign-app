package com.fashion.query.service;

import java.util.UUID;

import com.fashion.dto.User;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserQueryService {
	
	public Mono<User> saveUser(User user);

	public Flux<User> getAllUsers();

	public Mono<User> getUserById(UUID userId);
	
	public Mono<User> updateUser(User user);

	public Mono<User> deleteUserById(UUID userId);
}

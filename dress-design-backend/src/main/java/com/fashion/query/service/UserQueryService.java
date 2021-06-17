package com.fashion.query.service;

import com.fashion.dto.User;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserQueryService {
	
	Mono<User> saveUser(User user);

	Flux<User> getAllUsers();

	Mono<User> getUserById(String userId);
	
	Mono<User> updateUser(User user);

	Mono<User> deleteUserById(String userId);

}

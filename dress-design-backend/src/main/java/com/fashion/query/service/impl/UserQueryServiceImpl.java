package com.fashion.query.service.impl;

import org.springframework.stereotype.Service;

import com.fashion.dto.User;
import com.fashion.query.dao.UserQueryDao;
import com.fashion.query.service.UserQueryService;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class UserQueryServiceImpl implements UserQueryService {

	private UserQueryDao userDao;
	
	@Override
	public Flux<User> getAllUsers() {
		return userDao.findAll();
	}

	@Override
	public Mono<User> getUserById(String userId) {
		return userDao.findById(userId);
	}
	
	@Override
	public Mono<User> saveUser(User user) {
		return userDao.save(user);
	}

	@Override
	public Mono<User> updateUser(User user) {
		return userDao.save(user);
	}

	@Override
	public Mono<User> deleteUserById(String userId) {
		userDao.deleteById(userId);
		return null;
	}

}

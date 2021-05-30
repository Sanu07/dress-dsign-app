package com.fashion.command.service.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fashion.command.dao.UserCommandDao;
import com.fashion.command.service.UserCommandService;
import com.fashion.entity.User;

@Service
public class UserCommandServiceImpl implements UserCommandService {

	@Autowired
	private UserCommandDao userDao;
	
	@Override
	public User saveUser(User user) {
		return userDao.save(user);
	}

	@Override
	public User updateUser(User user) {
		return userDao.save(user);
	}

	@Override
	public void deleteUser(UUID userId) {
		userDao.deleteById(userId);
	}

}

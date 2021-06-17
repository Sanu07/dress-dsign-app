package com.fashion.command.service.impl;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.fashion.command.dao.UserCommandDao;
import com.fashion.command.service.UserCommandService;
import com.fashion.command.service.kafka.producer.CommandKafkaProducer;
import com.fashion.constants.AppConstants;
import com.fashion.entity.User;
import com.fasterxml.jackson.core.JsonProcessingException;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@Slf4j
public class UserCommandServiceImpl implements UserCommandService {

	private UserCommandDao userDao;
	private final CommandKafkaProducer kafkaProducer;

	@Override
	public User saveUser(User user) {
		User savedUser = userDao.save(user);
		try {
			kafkaProducer.sendEvent(savedUser, AppConstants.DRESS_USER_CREATE_EVENT_KEY,
					AppConstants.DRESS_USER_EVENTS_TOPIC, AppConstants.CREATE_EVENT_PARTITION);
		} catch (JsonProcessingException e) {
			log.error("UserCommandServiceImpl::saveUser -> JSON processing exception {} " + e.getMessage());
			return null;
		}
		return savedUser;
	}

	@Override
	public User updateUser(User user) {
		User updatedUser = userDao.save(user);
		try {
			kafkaProducer.sendEvent(updatedUser, AppConstants.DRESS_USER_UPDATE_EVENT_KEY,
					AppConstants.DRESS_USER_EVENTS_TOPIC, AppConstants.UPDATE_EVENT_PARTITION);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return updatedUser;
	}

	@Override
	public void deleteUser(UUID userId) {
		userDao.deleteById(userId);
		try {
			kafkaProducer.sendEvent(userId, AppConstants.DRESS_USER_DELETE_EVENT_KEY,
					AppConstants.DRESS_USER_EVENTS_TOPIC, AppConstants.DELETE_EVENT_PARTITION);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}

}

package com.fashion.command.service.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.fashion.command.dao.UserCommandDao;
import com.fashion.command.service.kafka.producer.CommandKafkaProducer;
import com.fashion.constants.AppConstants;
import com.fashion.entity.User;
import com.fasterxml.jackson.core.JsonProcessingException;

@ExtendWith(MockitoExtension.class)
class UserCommandServiceImplTest {

	@InjectMocks
	private UserCommandServiceImpl userService;

	@Mock
	private UserCommandDao repository;

	@Mock
	private CommandKafkaProducer kafkaProducer;
	
	private User user;
	private User savedUser;
	
	@BeforeEach
	void setUp() {
		this.user = User.builder().email("john@test.com").fullName("John Miller").loginId("JM1234567890")
				.phone("1234567890").password("mypassword").build();
		this.savedUser = User.builder().email("john@test.com").fullName("John Miller").loginId("JM1234567890")
				.phone("1234567890").password("mypassword").id(UUID.randomUUID()).createdAt(LocalDateTime.now())
				.updatedAt(LocalDateTime.now()).status(true).build();
	}

	@Test
	void testSaveUser() {
		when(repository.save(user)).thenReturn(savedUser);
		try {
			when(kafkaProducer.sendEvent(savedUser, AppConstants.DRESS_USER_CREATE_EVENT_KEY,
					AppConstants.DRESS_USER_EVENTS_TOPIC, AppConstants.CREATE_EVENT_PARTITION)).thenReturn(null);
		} catch (JsonProcessingException e) {}

		assertThat(userService.saveUser(user)).isEqualTo(savedUser);
	}

	@Test
	void testSaveUser_whenJsonProcessingException() {
		when(repository.save(user)).thenReturn(savedUser);
		try {
			when(kafkaProducer.sendEvent(savedUser, AppConstants.DRESS_USER_CREATE_EVENT_KEY,
					AppConstants.DRESS_USER_EVENTS_TOPIC, AppConstants.CREATE_EVENT_PARTITION))
							.thenThrow(JsonProcessingException.class);
		} catch (JsonProcessingException e) {}

		assertThat(userService.saveUser(user)).isNull();
	}

	@Test
	void testUpdateUser() {
		when(repository.save(user)).thenReturn(savedUser);
		try {
			when(kafkaProducer.sendEvent(savedUser, AppConstants.DRESS_USER_UPDATE_EVENT_KEY,
					AppConstants.DRESS_USER_EVENTS_TOPIC, AppConstants.UPDATE_EVENT_PARTITION)).thenReturn(null);
		} catch (JsonProcessingException e) {}

		assertThat(userService.updateUser(user)).isEqualTo(savedUser);
	}

	@Test
	void testDeleteUser() {
		try {
			when(kafkaProducer.sendEvent(user.getId(), AppConstants.DRESS_USER_DELETE_EVENT_KEY,
					AppConstants.DRESS_USER_EVENTS_TOPIC, AppConstants.DELETE_EVENT_PARTITION)).thenReturn(null);
		} catch (JsonProcessingException e) {}
		userService.deleteUser(user.getId());
		verify(repository, times(1)).deleteById(user.getId());
	}

}

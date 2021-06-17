package com.fashion.command.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import java.time.LocalDateTime;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fashion.command.service.impl.UserCommandServiceImpl;
import com.fashion.entity.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(controllers = UserCommandController.class, excludeAutoConfiguration = SecurityAutoConfiguration.class)
class UserCommandControllerTest {

	@Autowired
	private MockMvc mockMvc;
	@Autowired
	private ObjectMapper objectMapper;
	@MockBean
	private UserCommandServiceImpl userService;
	
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
	void testSaveUser() throws Exception {
		when(userService.saveUser(user)).thenReturn(savedUser);
		this.mockMvc.perform(post("/users")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(user))
				.characterEncoding("utf-8"))
		.andExpect(jsonPath("$.email", is(this.user.getEmail())))
		.andExpect(jsonPath("$.status", is(true)))
		.andExpect(jsonPath("$.createdAt", notNullValue()))
		.andReturn();
	}

	@Test
	void testUpdateUser() throws JsonProcessingException, Exception {
		when(userService.updateUser(user)).thenReturn(savedUser);
		this.mockMvc.perform(put("/users")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(user))
				.characterEncoding("utf-8"))
		.andExpect(jsonPath("$.email", is(this.user.getEmail())))
		.andExpect(jsonPath("$.status", is(true)))
		.andReturn();
	}

	@Test
	void testDeleteUser() throws JsonProcessingException, Exception {
		UUID uuid = UUID.randomUUID();
		this.mockMvc.perform(delete("/users/{userId}", uuid)
				.contentType(MediaType.APPLICATION_JSON)
				.characterEncoding("utf-8"));
		verify(userService, times(1)).deleteUser(uuid);
	}

}

package com.fashion.command.controller;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fashion.command.service.UserCommandService;
import com.fashion.entity.User;
import com.fashion.util.ReferenceIDGenerator;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "localhost:4200")
public class UserCommandController {

	Logger logger = LoggerFactory.getLogger(UserCommandController.class);

	@Autowired
	UserCommandService usersService;

	@PostMapping
	public User saveUser(@RequestBody User user) {
		User savedUser = null;
		if (user != null) {
			user.setLoginId(ReferenceIDGenerator.getGeneratedId(user.getFullName(), user.getPhone()));
		}
		try {
			savedUser = usersService.saveUser(user);
			logger.info("Saved Entity {}", savedUser);
		} catch (Exception e) {
			logger.error("Entity could not be saved " + e);
		}
		return savedUser;
	}

	@PutMapping
	public User updateUser(@RequestBody User user) {
		return usersService.updateUser(user);
	}

	@DeleteMapping("/{userId}")
	public void deleteUser(@PathVariable UUID userId) {
		usersService.deleteUser(userId);
	}
}

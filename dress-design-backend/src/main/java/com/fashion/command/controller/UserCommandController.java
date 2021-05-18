package com.fashion.command.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fashion.command.service.UsersCommandService;
import com.fashion.entity.User;

@RestController
@RequestMapping("/users") 
@CrossOrigin(origins = "*")
public class UserCommandController {

	@Autowired
	UsersCommandService usersService;
	
	@PostMapping
	public User saveUser(@RequestBody User user) {
		return usersService.saveUser(user);
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

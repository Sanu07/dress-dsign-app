package com.fashion.query.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fashion.dto.User;
import com.fashion.query.service.UserQueryService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "*")
public class UserQueryController {

	@Autowired
	UserQueryService userService;

	@GetMapping
	public Flux<User> getAllCustomers() {
		return userService.getAllUsers();
	}

	@GetMapping("/{uuid}")
	public Mono<User> getCustomerById(@PathVariable UUID uuid) {
		return userService.getUserById(uuid);
	}

}

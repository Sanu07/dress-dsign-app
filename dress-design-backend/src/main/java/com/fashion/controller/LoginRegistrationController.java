package com.fashion.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fashion.entity.User;

@RestController
public class LoginRegistrationController {

	@GetMapping("/hello")
	public ResponseEntity<User> login() {
		User user = new User();
		return ResponseEntity.ok(user);
	}
}

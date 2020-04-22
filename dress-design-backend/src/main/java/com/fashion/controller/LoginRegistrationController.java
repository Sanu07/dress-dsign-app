package com.fashion.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fashion.model.User;

@RestController
public class LoginRegistrationController {

	@GetMapping("/hello")
	public ResponseEntity<User> login() {
		User user = new User(1L, "DD041120", "pass", "Sanu", "abc@test.com", 12521312, "m");
		return ResponseEntity.ok(user);
	}
}

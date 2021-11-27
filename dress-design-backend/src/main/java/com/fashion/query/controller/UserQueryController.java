package com.fashion.query.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fashion.constants.AppConstants;
import com.fashion.dto.User;
import com.fashion.query.service.UserQueryService;
import com.fashion.util.FilesUtil;

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
		return userService.getAllUsers().map(user -> {
			if (user.getImageFilePath() != null) {
				try {
					user.setFile(FilesUtil.getImage(user.getImageFilePath()));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			return user;
		});
	}

	@GetMapping("/{uuid}")
	public Mono<User> getCustomerById(@PathVariable String uuid) {
		return userService.getUserById(uuid);
	}

}

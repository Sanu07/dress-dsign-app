package com.dress.notification.controller;

import java.time.LocalTime;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.dress.notification.model.User;
import com.dress.notification.service.EmailService;

import reactor.core.publisher.Mono;

@RestController
public class EmailController {

	@Autowired
	EmailService emailService;

	@GetMapping("send-email")
	@ResponseStatus(HttpStatus.CREATED)
	public Mono<User> sendMail() throws MessagingException {
		// emailService.sendMail(user);
		// return "Email Sent Successfully.!";
		System.out.println("done!!!" + LocalTime.now());
		return emailService.getUserAsync();
	}
}

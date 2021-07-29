package com.fashion.query.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fashion.dto.Feedback;
import com.fashion.query.service.FeedbackQueryService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/feedbacks")
@CrossOrigin(origins = "*")
public class FeedbackQueryController {

	@Autowired
	FeedbackQueryService feedbackService;

	@GetMapping
	public Flux<Feedback> getAllCustomers() {
		return feedbackService.getAllFeedbacks();
	}

	@GetMapping("/{uuid}")
	public Mono<Feedback> getCustomerById(@PathVariable String uuid) {
		return feedbackService.getFeedbackById(uuid);
	}

}

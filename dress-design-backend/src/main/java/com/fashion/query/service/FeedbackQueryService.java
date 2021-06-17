package com.fashion.query.service;

import org.springframework.http.ResponseEntity;

import com.fashion.dto.Feedback;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface FeedbackQueryService {
	
	ResponseEntity<Feedback> saveFeedback(Feedback feedback);

	Flux<Feedback> getAllFeedbacks();

	Mono<Feedback> getFeedbackById(String feedbackId);
	
	ResponseEntity<Feedback> updateFeedback(Feedback feedback);
	
	void updateOrderWithFeedback(Feedback feedback);
	
	Mono<Feedback> deleteFeedbackById(String feedbackId);

	void deleteFeedbacksByCustomerId(String customerId);
	
	void deleteFeedbacksByOrderId(String orderId);
}

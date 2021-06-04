package com.fashion.query.service;

import java.util.UUID;

import org.springframework.http.ResponseEntity;

import com.fashion.dto.Feedback;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface FeedbackQueryService {
	
	public ResponseEntity<Feedback> saveFeedback(Feedback feedback);

	public Flux<Feedback> getAllFeedbacks();

	public Mono<Feedback> getFeedbackById(UUID feedbackId);
	
	public ResponseEntity<Feedback> updateFeedback(Feedback feedback);
	
	public void updateOrderWithFeedback(Feedback feedback);
	
	public Mono<Feedback> deleteFeedbackById(UUID feedbackId);
}

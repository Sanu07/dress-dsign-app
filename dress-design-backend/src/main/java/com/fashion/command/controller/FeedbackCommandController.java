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

import com.fashion.command.service.FeedbackCommandService;
import com.fashion.entity.Feedback;

@RestController
@RequestMapping("/feedbacks") 
@CrossOrigin(origins = "*")
public class FeedbackCommandController {
	
	@Autowired
	FeedbackCommandService feedbacksService;
	
	@PostMapping
	public Feedback saveFeedback(@RequestBody Feedback feedback) {
		return feedbacksService.saveFeedback(feedback);
	}
	
	@PutMapping
	public Feedback updateFeedback(@RequestBody Feedback feedback) {
		return feedbacksService.updateFeedback(feedback);
	}
	
	@DeleteMapping("/{feedbackId}")
	public void deleteFeedback(@PathVariable UUID feedbackId) {
		feedbacksService.deleteFeedback(feedbackId);
	}
}

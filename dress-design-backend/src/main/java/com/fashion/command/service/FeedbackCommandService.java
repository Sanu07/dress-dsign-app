package com.fashion.command.service;

import java.util.Optional;
import java.util.UUID;

import com.fashion.entity.Feedback;

public interface FeedbackCommandService {

	public Feedback saveFeedback(Feedback feedback);

	public Feedback updateFeedback(Feedback feedback);

	public void deleteFeedback(UUID feedbackId);
	
	public Optional<Feedback> findFeedbackById(UUID feedbackId);

}

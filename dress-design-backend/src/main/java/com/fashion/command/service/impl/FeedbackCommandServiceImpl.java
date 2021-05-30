package com.fashion.command.service.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fashion.command.dao.FeedbackCommandDao;
import com.fashion.command.service.FeedbackCommandService;
import com.fashion.entity.Feedback;

@Service
public class FeedbackCommandServiceImpl implements FeedbackCommandService {

	@Autowired
	private FeedbackCommandDao feedbackDao;

	public FeedbackCommandServiceImpl(FeedbackCommandDao feedbackDao) {
		this.feedbackDao = feedbackDao;
	}

	@Override
	public Feedback saveFeedback(Feedback feedback) {
		Feedback savedFeedback = feedbackDao.save(feedback);
		// sendFeedbackRegistrationEvent(savedFeedback);
		return savedFeedback;
	}

	@Override
	public Feedback updateFeedback(Feedback feedback) {
		return feedbackDao.save(feedback);
	}

	@Override
	public void deleteFeedback(UUID feedbackId) {
		feedbackDao.deleteById(feedbackId);
	}

}

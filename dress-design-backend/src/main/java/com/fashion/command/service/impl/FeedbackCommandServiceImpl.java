package com.fashion.command.service.impl;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.fashion.command.dao.FeedbackCommandDao;
import com.fashion.command.service.FeedbackCommandService;
import com.fashion.command.service.kafka.producer.CommandKafkaProducer;
import com.fashion.constants.AppConstants;
import com.fashion.entity.Feedback;
import com.fashion.util.EntityToDTOConverter;
import com.fasterxml.jackson.core.JsonProcessingException;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class FeedbackCommandServiceImpl implements FeedbackCommandService {

	private FeedbackCommandDao feedbackDao;
	private final CommandKafkaProducer kafkaProducer;

	@Override
	public Feedback saveFeedback(Feedback feedback) {
		Feedback savedFeedback = feedbackDao.save(feedback);
		try {
			kafkaProducer.sendEvent(EntityToDTOConverter.createDTOFeedback(savedFeedback), AppConstants.DRESS_GENERAL_FEEDBACK_EVENT_KEY,
					AppConstants.DRESS_GENERAL_EVENTS_TOPIC, AppConstants.FEEDBACK_EVENT_PARTITION);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
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

package com.fashion.command.service.kafka.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.listener.AcknowledgingMessageListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Service;

import com.fashion.constants.AppConstants;
import com.fashion.dto.Feedback;
import com.fashion.query.service.FeedbackQueryService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@AllArgsConstructor
public class FeedbackCommandKafkaListener implements AcknowledgingMessageListener<String, String> {

	FeedbackQueryService feedbackService;
	ObjectMapper mapper;

	@KafkaListener(topics = { AppConstants.DRESS_GENERAL_EVENTS_TOPIC })
	@Override
	public void onMessage(ConsumerRecord<String, String> consumerRecord, Acknowledgment acknowledgment) {
		if (consumerRecord.partition() != 0) return;
		log.info("ConsumerRecord : {} ", consumerRecord);
		acknowledgment.acknowledge();
		Feedback feedback = null;
		try {
			feedback = mapper.readValue(consumerRecord.value(), Feedback.class);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		feedbackService.saveFeedback(feedback);
	}

}

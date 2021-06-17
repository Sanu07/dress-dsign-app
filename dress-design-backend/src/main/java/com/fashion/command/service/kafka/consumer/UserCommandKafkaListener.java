package com.fashion.command.service.kafka.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.listener.AcknowledgingMessageListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Service;

import com.fashion.constants.AppConstants;
import com.fashion.dto.User;
import com.fashion.query.service.UserQueryService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Service
@Slf4j
@AllArgsConstructor
public class UserCommandKafkaListener implements AcknowledgingMessageListener<String, String> {

	UserQueryService userService;
	ObjectMapper mapper;

	@KafkaListener(topics = { AppConstants.DRESS_USER_EVENTS_TOPIC })
	@Override
	public void onMessage(ConsumerRecord<String, String> consumerRecord, Acknowledgment acknowledgment) {
		if (consumerRecord.partition() == 3) return;
		log.info("ConsumerRecord : {} ", consumerRecord);
		User user = null;
		if (consumerRecord.partition() == 1) {
			try {
				user = mapper.readValue(consumerRecord.value(), User.class);
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
			userService.saveUser(user).subscribe(ord -> log.info("User Saved in MongoDB {} ", ord));
		} else if (consumerRecord.partition() == 2) {
			try {
				user = mapper.readValue(consumerRecord.value(), User.class);
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
			if (user.getId() != null) {
				userService.saveUser(user).subscribe(usr -> log.info("User updated in MongoDB {} ", usr));
			}
		} else {
			try {
				user = mapper.readValue(consumerRecord.value(), User.class);
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
			Mono<User> dbUser = userService.getUserById(user.getId().toString());
			dbUser.doOnNext(usr -> {
				userService.deleteUserById(usr.getId())
						.subscribe(u -> log.info("User updated in MongoDB {} ", u));
			});
		}
		acknowledgment.acknowledge();
	}

}

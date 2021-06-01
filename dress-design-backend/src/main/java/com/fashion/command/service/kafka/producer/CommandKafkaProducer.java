package com.fashion.command.service.kafka.producer;

import java.util.List;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.header.Header;
import org.apache.kafka.common.header.internals.RecordHeader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CommandKafkaProducer {
	
	private final Logger logger = LoggerFactory.getLogger(CommandKafkaProducer.class);

	private final ObjectMapper objectMapper;
	private final KafkaTemplate<String, String> kafkaTemplate;

	public ListenableFuture<SendResult<String, String>> sendEvent(Object customer, String key,
			String topic, Integer partition) throws JsonProcessingException {

		String value = objectMapper.writeValueAsString(customer);
		ProducerRecord<String, String> producerRecord = buildProducerRecord(key, value, topic, partition);

		ListenableFuture<SendResult<String, String>> listenableFuture = kafkaTemplate.send(producerRecord);

		listenableFuture.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
			@Override
			public void onFailure(Throwable ex) {
				handleFailure(key, value, ex);
			}

			@Override
			public void onSuccess(SendResult<String, String> result) {
				handleSuccess(key, value, result);
			}
		});

		return listenableFuture;
	}
	
	public void handleRecovery(ConsumerRecord<String,String> record){

        String key = record.key();
        String message = record.value();

        ListenableFuture<SendResult<String,String>> listenableFuture = kafkaTemplate.sendDefault(key, message);
        listenableFuture.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
            @Override
            public void onFailure(Throwable ex) {
                handleFailure(key, message, ex);
            }

            @Override
            public void onSuccess(SendResult<String, String> result) {
                handleSuccess(key, message, result);
            }
        });
    }

	private ProducerRecord<String, String> buildProducerRecord(String key, String value, String topic,
			Integer partition) {
		List<Header> recordHeaders = List.of(new RecordHeader("event-source", partition.toString().getBytes()));
		return new ProducerRecord<>(topic, partition, key, value, recordHeaders);
	}

	private void handleFailure(String key, String value, Throwable ex) {
		logger.error("Error Sending the Message and the exception is {}", ex.getMessage());
		try {
			throw ex;
		} catch (Throwable throwable) {
			logger.error("Error in OnFailure: {}", throwable.getMessage());
		}
	}

	private void handleSuccess(String key, String value, SendResult<String, String> result) {
		logger.info("Message Sent SuccessFully for the key : {} and the value is {} , partition is {}", key, value,
				result.getRecordMetadata().partition());
	}
}
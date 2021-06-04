package com.fashion.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

import com.fashion.constants.AppConstants;

@Configuration
public class KafkaTopicCreationConfig {

	@Bean
    public NewTopic customerEvents(){
        return TopicBuilder.name(AppConstants.DRESS_CUSTOMER_EVENTS_TOPIC)
                .partitions(3)
                .replicas(1)
                .build();
    }
	
	@Bean
    public NewTopic orderEvents(){
        return TopicBuilder.name(AppConstants.DRESS_ORDER_EVENTS_TOPIC)
                .partitions(3)
                .replicas(1)
                .build();
    }
	
	@Bean
    public NewTopic userEvents(){
        return TopicBuilder.name(AppConstants.DRESS_USER_EVENTS_TOPIC)
                .partitions(3)
                .replicas(1)
                .build();
    }
	
	@Bean
    public NewTopic generalEvents(){
        return TopicBuilder.name(AppConstants.DRESS_GENERAL_EVENTS_TOPIC)
                .partitions(2)
                .replicas(1)
                .build();
    }
}

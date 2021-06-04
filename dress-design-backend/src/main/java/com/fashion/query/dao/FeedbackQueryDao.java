package com.fashion.query.dao;

import java.util.UUID;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fashion.dto.Feedback;

import reactor.core.publisher.Mono;

@Repository
public interface FeedbackQueryDao extends ReactiveMongoRepository<Feedback, UUID>{

	@Modifying
	@Query("update Feedback f set f.status = :status where f.id = :id")
	Mono<Feedback> deleteFeedbackById(@Param(value = "id") UUID id, @Param(value = "status") boolean status);
}

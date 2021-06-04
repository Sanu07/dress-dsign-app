package com.fashion.query.dao;

import java.util.UUID;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fashion.dto.User;

import reactor.core.publisher.Mono;

@Repository
public interface UserQueryDao extends ReactiveMongoRepository<User, UUID>{

	@Modifying
	@Query("update User u set u.status = :status where u.id = :id")
	Mono<User> deleteUserById(@Param(value = "id") UUID id, @Param(value = "status") boolean status);
}

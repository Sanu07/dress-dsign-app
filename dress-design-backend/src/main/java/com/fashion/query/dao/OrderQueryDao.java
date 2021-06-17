
package com.fashion.query.dao;

import java.util.UUID;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fashion.dto.Order;

import reactor.core.publisher.Mono;

@Repository
public interface OrderQueryDao extends ReactiveMongoRepository<Order, String> {

	Mono<Order> findByOrderId(String orderId);
}

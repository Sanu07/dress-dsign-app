
package com.fashion.query.dao;

import java.util.UUID;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fashion.dto.Customer;

import reactor.core.publisher.Mono;

@Repository
public interface CustomerQueryDao extends ReactiveMongoRepository<Customer, UUID> {
	
	@Modifying
	@Query("update Customer c set c.status = :status where c.id = :id")
	Mono<Customer> deleteCustomerById(@Param(value = "id") UUID id, @Param(value = "status") boolean status);
	
	Mono<Customer> findByCustomerId(String customerId);

}

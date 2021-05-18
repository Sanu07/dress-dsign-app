
package com.fashion.query.dao;

import java.util.UUID;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.fashion.dto.Customer;

@Repository
public interface CustomerQueryDao extends ReactiveMongoRepository<Customer, UUID> {

}


package com.fashion.query.dao;

import java.util.UUID;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.fashion.dto.Orders;

@Repository
public interface MeasurementsQueryDao extends ReactiveMongoRepository<Orders, UUID> {

}

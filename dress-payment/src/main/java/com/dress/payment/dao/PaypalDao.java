package com.dress.payment.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.dress.payment.model.Transaction;

@Repository
public interface PaypalDao extends MongoRepository<Transaction, Long> {

}

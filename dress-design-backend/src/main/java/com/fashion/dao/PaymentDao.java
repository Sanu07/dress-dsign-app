package com.fashion.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fashion.model.Payment;

@Repository
public interface PaymentDao extends CrudRepository<Payment, Long>{

}

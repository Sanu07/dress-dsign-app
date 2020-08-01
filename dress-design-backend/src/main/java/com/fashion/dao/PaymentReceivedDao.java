package com.fashion.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fashion.model.ReceivedDates;

@Repository
public interface PaymentReceivedDao extends JpaRepository<ReceivedDates, Long> {
	
}

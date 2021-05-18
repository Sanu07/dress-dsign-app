package com.fashion.command.dao;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fashion.entity.Customer;

@Repository
public interface CustomersCommandDao extends JpaRepository<Customer, UUID> {
	
}

package com.fashion.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fashion.model.Customer;

@Repository
public interface CustomerDao extends CrudRepository<Customer, Long>{
	
}

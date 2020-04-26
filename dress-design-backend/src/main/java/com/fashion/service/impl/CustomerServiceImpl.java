package com.fashion.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fashion.dao.CustomerDao;
import com.fashion.model.Customer;
import com.fashion.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerDao customerDao;
	
	@Override
	public Customer saveCustomer(Customer customer) {
		return customerDao.save(customer);
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		return customerDao.save(customer);
	}

	@Override
	public Iterable<Customer> getAllCustomers() {
		return customerDao.findAll();
	}

	@Override
	public Customer getCustomer(long customerId) {
		return customerDao.findById(customerId).orElse(null);
	}

	@Override
	public void deleteCustomer(long customerId) {
		customerDao.deleteById(customerId);
	}

}

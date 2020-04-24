package com.fashion.service;

import com.fashion.model.Customer;

public interface CustomerService {
	
	public Customer saveCustomer(Customer customer);

	public Customer updateCustomer(Customer customer);

	public Iterable<Customer> getAllCustomers();

	public Customer getCustomer(long customerId);

	public void deleteCustomer(long customerId);
}

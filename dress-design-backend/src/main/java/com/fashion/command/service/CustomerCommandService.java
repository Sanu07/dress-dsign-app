package com.fashion.command.service;

import java.util.UUID;

import com.fashion.entity.Customer;

public interface CustomerCommandService {

	public Customer saveCustomer(Customer customer);

	public Customer updateCustomer(Customer customer);

	public void deleteCustomer(UUID customerId);

}

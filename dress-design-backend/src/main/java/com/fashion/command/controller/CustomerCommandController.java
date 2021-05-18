package com.fashion.command.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fashion.command.service.CustomersCommandService;
import com.fashion.entity.Customer;

@RestController
@RequestMapping("/customers") 
@CrossOrigin(origins = "*")
public class CustomerCommandController {

	@Autowired
	CustomersCommandService customersService;
	
	@PostMapping
	public Customer saveCustomer(@RequestBody Customer customer) {
		return customersService.saveCustomer(customer);
	}
	
	@PutMapping
	public Customer updateCustomer(@RequestBody Customer customer) {
		return customersService.updateCustomer(customer);
	}
	
	@DeleteMapping("/{customerId}")
	public void deleteCustomer(@PathVariable UUID customerId) {
		customersService.deleteCustomer(customerId);
	}
}

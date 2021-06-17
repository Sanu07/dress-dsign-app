package com.fashion.command.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fashion.command.service.CustomerCommandService;
import com.fashion.entity.Customer;

@RestController
@RequestMapping("/customers") 
@CrossOrigin(origins = "*")
public class CustomerCommandController {

	@Autowired
	CustomerCommandService customersService;
	
	@PostMapping
	public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer) {
		Customer savedCustomer = customersService.saveCustomer(customer);
		return ResponseEntity.created(null).body(savedCustomer);
	}
	
	@PutMapping
	public Customer updateCustomer(@RequestBody Customer customer) {
		return customersService.updateCustomer(customer);
	}
	
	@DeleteMapping("/{customerId}")
	public ResponseEntity<Void> deleteCustomer(@PathVariable UUID customerId) {
		customersService.deleteCustomer(customerId);
		return ResponseEntity.status(HttpStatus.ACCEPTED).build();
	}
}

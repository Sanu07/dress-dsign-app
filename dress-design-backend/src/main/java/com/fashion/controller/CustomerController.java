package com.fashion.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.fashion.model.Customer;
import com.fashion.service.CustomerService;

@RestController
@CrossOrigin("*")
public class CustomerController {
	@Autowired
	CustomerService customersService;
	
	@PostMapping("/customers")
	public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer) {
		Customer customerRes = null;
		try {
			customerRes = customersService.saveCustomer(customer);
	        return ResponseEntity.ok(customerRes);
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	@GetMapping("/customers")
	public List<Customer> getAllCustomers() {
		try {
			return (List<Customer>) customersService.getAllCustomers();
		} catch (Exception e) {
			return new ArrayList<Customer>(0);
		}
	}
	
	@GetMapping("/customers/{customerId}")
	public Customer getCustomer(@PathVariable("customerId") long customerId) {
		return customersService.getCustomer(customerId);
	}
	
	@PutMapping("/customers")
	public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer) {
		Customer customerRes = null;
		try {
			customerRes = customersService.saveCustomer(customer);
	        return ResponseEntity.ok(customerRes);
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/customers/{customerId}")
	public void deleteCustomer(@PathVariable("customerId") long customerId) {
		customersService.deleteCustomer(customerId);
	}
}

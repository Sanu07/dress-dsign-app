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
	
	private List<Customer> customers;
	
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
	public List<Customer> getAllCustomers(@RequestParam (name = "refresh", defaultValue = "false") boolean refresh) {
		try {
			if (refresh || customers == null) {
				customers = (List<Customer>) customersService.getAllCustomers();
			}
			return customers;
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
	
	public List<Customer> getAllCustomers() {
		return customers;
	}
	
	public Customer getCustomerById(long customerId) {
		return customers.stream()
		  .filter(customer -> customerId == customer.getId())
		  .findAny()
		  .orElse(null);
	}
}

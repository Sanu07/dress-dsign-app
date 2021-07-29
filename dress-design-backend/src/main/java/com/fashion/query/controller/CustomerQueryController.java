package com.fashion.query.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fashion.dto.Customer;
import com.fashion.query.dao.CustomerQueryDao;
import com.fashion.query.service.CustomerQueryService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/customers") 
@CrossOrigin(origins = "*")
public class CustomerQueryController {

	@Autowired
	CustomerQueryService customerService;
	
	@Autowired
	CustomerQueryDao custDao;
	
	@GetMapping
	public Flux<Customer> getAllCustomers() {
		return customerService.getAllCustomers();
	}
	
	@GetMapping("/{uuid}")
	public Mono<Customer> getCustomerById(@PathVariable String uuid) {
		return customerService.getCustomerById(uuid);
	}
	
	@GetMapping("/customerId/{customerId}")
	public Mono<Customer> getCustomerByCustomerId(@PathVariable String customerId) {
		return customerService.getCustomerByCustomerId(customerId);
	}
	
}

package com.fashion.query.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fashion.dto.Customer;
import com.fashion.query.service.CustomerQueryService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/customers") 
@CrossOrigin(origins = "*")
public class CustomerQueryController {

	@Autowired
	CustomerQueryService customerService;
	
	@GetMapping
	public Flux<Customer> getAllCustomers() {
		return customerService.getAllCustomers();
	}
	
	@GetMapping("/{uuid}")
	public Mono<Customer> getCustomerById(@PathVariable UUID uuid) {
		return customerService.getCustomerById(uuid);
	}
	
}

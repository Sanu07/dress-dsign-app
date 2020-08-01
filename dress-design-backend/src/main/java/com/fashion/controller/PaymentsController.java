package com.fashion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fashion.model.Payment;
import com.fashion.service.PaymentsService;

@RestController
@CrossOrigin("*")
public class PaymentsController {

	@Autowired
	PaymentsService paymentsService;
	
	@PostMapping("/payments")
	public Payment savePayment(@RequestBody Payment Payment) {
		return paymentsService.savePayment(Payment);
	}
	
	@GetMapping("/payments")
	public List<Payment> getAllPayments() {
		return (List<Payment>) paymentsService.getAllPayments();
	}
	
	@GetMapping("/payments/{paymentId}")
	public Payment getPayment(@PathVariable("paymentId") long paymentId) {
		return paymentsService.getPayment(paymentId);
	}
	
	@PutMapping("/payments")
	public Payment updatePayment(@RequestBody Payment Payment) {
		return paymentsService.updatePayment(Payment);
	}
	
	@DeleteMapping("/payments/{paymentId}")
	public void deletePayment(@PathVariable("paymentId") long paymentId) {
		paymentsService.deletePayment(paymentId);;
	}
}

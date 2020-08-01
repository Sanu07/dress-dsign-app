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

import com.fashion.model.ReceivedDates;
import com.fashion.service.PaymentReceivedService;

@RestController
@CrossOrigin("*")
public class PaymentReceivedController {
	
	@Autowired
	PaymentReceivedService paymentReceivedService;
	
	@PostMapping("/receivedDates")
	public ReceivedDates saveReceivedDates(@RequestBody ReceivedDates receivedDates) {
		return paymentReceivedService.saveReceivedDate(receivedDates);
	}
	
	@GetMapping("/receivedDates")
	public List<ReceivedDates> getAllReceivedDates() {
		return paymentReceivedService.getAllReceivedDates();
	}
	
	@PutMapping("/receivedDates")
	public ReceivedDates updateReceivedDates(@RequestBody ReceivedDates receivedDates) {
		return paymentReceivedService.updateReceivedDate(receivedDates);
	}
	
	@DeleteMapping("/receivedDates/{id}")
	public void deleteReceivedDates(@PathVariable ("id") long id) {
		paymentReceivedService.deleteReceivedDate(id);
	}
	
	@GetMapping("/receivedDates/{id}")
	public ReceivedDates getReceivedDates(@PathVariable ("id") long id) {
		return paymentReceivedService.getReceivedDate(id);
	}
}

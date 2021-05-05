package com.dress.payment.service;

import java.util.TreeMap;

import org.springframework.stereotype.Service;

import com.dress.payment.model.Payment;
import com.paytm.pg.merchant.PaytmChecksum;

@Service
public class PaymentService {
	
	private Payment payment;
	
	public PaymentService(Payment payment) {
		this.payment = payment;
	}
	
	public boolean validateCheckSum(TreeMap<String, String> parameters, String paytmChecksum) throws Exception {
		return PaytmChecksum.verifySignature(parameters, payment.getMerchantKey(), paytmChecksum);
	}

	public String getCheckSum(TreeMap<String, String> parameters) throws Exception {
		return PaytmChecksum.generateSignature(parameters, payment.getMerchantKey());
	}
}

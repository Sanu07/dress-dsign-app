package com.dress.payment.model;

import java.util.TreeMap;

import lombok.Data;

@Data
public class PaymentResponse {

	private String result;
	private TreeMap<String, String> parameters;
}

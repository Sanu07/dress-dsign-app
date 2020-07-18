package com.dress.payment.model;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Document
public class Transaction {

	private double price;
	private String currency;
	private String method;
	private String intent;
	private String description;

}

package com.dress.payment.model;

import java.time.LocalDateTime;

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
public class DressPaymentStatus {
	
	private int code;
	private String message;
	private String description;
	private LocalDateTime date;
}

package com.fashion.dto;

import java.time.LocalDateTime;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

import com.fashion.enums.PaymentTypeEnum;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor
@Document(collection = "payment_details")
public class Payment {

	@Id
	private String id;

	@Enumerated(EnumType.STRING)
	private PaymentTypeEnum paymentType;

	private Double paidAmount;

	private Double balanceDue;

	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	private LocalDateTime createdAt;
	
	private String customerId;
	
	private String orderId;
	
	private int version;
}

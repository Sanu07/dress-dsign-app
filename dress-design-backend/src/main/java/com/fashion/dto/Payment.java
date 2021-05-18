package com.fashion.dto;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor
@Document(collection = "payments")
public class Payment {

	@Id
	private UUID id;

	private String paymentType;

	private String paidAmount;

	private String balanceDue;

	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	private LocalDateTime receivedDate;
}

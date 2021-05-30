package com.fashion.dto;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Document(collection = "customers")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Customer {

	@Id
	private UUID id;

	private String customerId;

	private String customerName;

	private String phone;

	private String email;

	private String address;

	private int version;
	
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	private LocalDateTime createdAt;

	private String createdByUserId;
	
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	private LocalDateTime updatedAt;
	
}

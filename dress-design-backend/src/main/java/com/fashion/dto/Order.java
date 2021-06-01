package com.fashion.dto;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

import com.fashion.enums.OrderStatusEnum;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "order_details")
public class Order {

	@Id
	private UUID id;

	private String orderNo;

	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	private LocalDateTime createdAt;

	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	private LocalDateTime estimatedDeliveryDate;

	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	private LocalDateTime orderDeliveredOn;

	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	private LocalDateTime updatedAt;

	@Enumerated(EnumType.STRING)
	private OrderStatusEnum orderStatus;
	
	private int version;
	
	private String customerId;

    private Map<String, Measurements> measurements;
	
	private String paymentId;

}

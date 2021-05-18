package com.fashion.dto;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "orders")
public class Orders {

	@Id
	private UUID id;

	private String orderNo;

	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	private LocalDateTime orderReceivedOn;

	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	private LocalDateTime estimatedDeliveryDate;

	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	private LocalDateTime orderDeliveredOn;

}

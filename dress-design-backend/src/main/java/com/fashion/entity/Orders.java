package com.fashion.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "ORDER_DETAILS")
public class Orders {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Type(type = "pg-uuid")
	@Column(name = "_ID", updatable = false)
	private UUID id;

	@Column(name = "ORDER_ON")
	private String orderNo;

	@Column(name = "ORDER_RECEIVED_ON")
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	private LocalDateTime orderReceivedOn;

	@Column(name = "ESTIMATED_DELIVERY_DATE")
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	private LocalDateTime estimatedDeliveryDate;

	@Column(name = "ORDER_DELIVERED_ON")
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	private LocalDateTime orderDeliveredOn;

}

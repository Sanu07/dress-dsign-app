package com.fashion.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;

import com.fashion.enums.PaymentTypeEnum;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor
@Entity
@Table(name = "PAYMENT_DETAILS")
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Type(type = "pg-uuid")
	@Column(name = "_ID", updatable = false)
	private UUID id;

	@Enumerated(EnumType.STRING)
	@Column(name = "PAYMENT_TYPE", nullable = false)
	private PaymentTypeEnum paymentType;

	@Column(name = "AMOUNT_PAID", nullable = false)
	private String paidAmount;

	@Column(name = "BALANCE_DUE", nullable = false)
	private String balanceDue;

	@CreationTimestamp
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	@Column(name = "CREATED_AT")
	private LocalDateTime createdAt;
	
	@ManyToOne(cascade={CascadeType.PERSIST})
	@JoinColumn(name="customer_id")
	private Customer customer;
	
	@ManyToOne(cascade={CascadeType.PERSIST})
	@JoinColumn(name="order_id")
	private Order order;
}

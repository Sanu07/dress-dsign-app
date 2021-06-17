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
import javax.persistence.Version;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
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
	@GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Column(name = "_ID", columnDefinition = "BINARY(16)")
	private UUID id;

	@Enumerated(EnumType.STRING)
	@Column(name = "PAYMENT_TYPE", nullable = false)
	private PaymentTypeEnum paymentType;

	@Column(name = "AMOUNT_PAID", nullable = false)
	private Double paidAmount;

	@Column(name = "BALANCE_DUE", nullable = false)
	private Double balanceDue;

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
	
	@Version
	private int version;
	
}

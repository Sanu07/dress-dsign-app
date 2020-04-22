package com.fashion.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PAYMENT_ID")
	private long id;
	
	@Column(name = "PAYMENT_TYPE")
	private String paymentType;
	
	@Column(name = "PAYMENT_AMOUNT")
	private String paidAmount;
	
	@Column(name = "BALANCE_DUE")
	private String balanceDue;
	
	@Column(name = "RECEIVED_DATE")
	private Date receivedDate;
}

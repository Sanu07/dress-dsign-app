package com.fashion.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	@Column(name = "_ID")
	private long id;
	
	@Column(name = "PAYMENT_REF_NO")
	private String paymentId;
	
	@Column(name = "PAYMENT_TYPE")
	private String paymentType;
	
	@Column(name = "PAYMENT_AMOUNT")
	private String paidAmount;
	
	@Column(name = "BALANCE_DUE")
	private String dueAmount;
	
	@Column(name = "TOTAL_AMOUNT")
	private String totalAmount;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "payment_id")
	private Set<ReceivedDates> receivedDates = new HashSet<ReceivedDates>();
	
	@OneToOne(mappedBy = "payment")
	@JsonIgnore
	private Orders order;
	
}

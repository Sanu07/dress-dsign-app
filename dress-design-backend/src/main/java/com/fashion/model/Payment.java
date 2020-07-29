package com.fashion.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
	private String balanceDue;
	
	@Column(name = "TOTAL_AMOUNT")
	private String totalAmount;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "payment")
	private List<ReceivedDates> receivedDates;
	
	@OneToOne
	private Orders order;
	
	@Data
	@AllArgsConstructor(access = AccessLevel.PUBLIC)
	@Entity
	@Table(name = "RECEIVED_DETAILS")
	class ReceivedDates {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "RECEIVED_ID")
		private long id;
		
		@Column(name = "RECEIVED_AMOUNT")
		private String paidAmount;
		
		@Column(name = "RECEIVED_DATE")
		@Temporal(TemporalType.DATE)
		private Date receivedDate = new Date();
		
		@ManyToOne(fetch = FetchType.LAZY)
		@JoinColumn(name = "payment_id")
		private Payment payment;
	}
}

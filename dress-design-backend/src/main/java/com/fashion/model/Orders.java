package com.fashion.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor
@Entity
@Table(name = "ORDER_DETAILS")
public class Orders {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "_ID")
	private long id;
	
	@Column(name = "ORDER_REF_NO")
	private String orderId;
	
	@OneToOne
	private Dress dress;
	
	@Column(name = "ORDER_RECEIVED")
	private Date orderReceived;
	
	@Column(name = "ORDER_ESTIMATED_DELIVERY_DATE")
	private Date estimatedDeliveryDate;
	
	@Column(name = "ORDER_DELIVERED_ON")
	private Date orderDelivered;
	
	@OneToOne
	private Payment payment;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_id")
	private Customer customer;
}

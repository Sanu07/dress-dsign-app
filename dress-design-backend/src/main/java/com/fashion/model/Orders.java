package com.fashion.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Orders {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ORDER_ID")
	private long id;
	private String orderNo;
	private Dress dress;
	private Date orderReceived;
	private Date estimatedDeliveryDate;
	private Date orderDelivered;
	private Payment payment;
	private Customer customer;
}

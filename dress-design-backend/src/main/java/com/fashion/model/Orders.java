package com.fashion.model;

import java.util.Date;

public class Orders {

	private long id;
	private String orderNo;
	private Dress dress;
	private Date orderReceived;
	private Date estimatedDeliveryDate;
	private Date orderDelivered;
	private Payment payment;
	private Customer customer;
}

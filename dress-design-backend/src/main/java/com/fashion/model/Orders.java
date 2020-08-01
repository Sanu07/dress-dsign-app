package com.fashion.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

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
    @GeneratedValue(generator = "order-id-generator")
    @GenericGenerator(name = "order-id-generator", 
      parameters = @Parameter(name = "prefix", value = "ORDER"), 
      strategy = "com.fashion.util.OrderIDGenerator")
	@Column(name = "ORDER_ID")
	private String id;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "dress_id")
	private Dress dress;
	
	@Column(name = "ORDER_RECEIVED")
	@Temporal(TemporalType.DATE)
	private Date orderReceived = new Date();
	
	@Column(name = "ORDER_ESTIMATED_DELIVERY_DATE")
	private Date estimatedDeliveryDate;
	
	@Column(name = "ORDER_DELIVERED_ON", columnDefinition = "varchar(255) default 'PENDING'")
	private Date orderDelivered;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "payment_id")
	private Payment payment;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "customer_id")
	private Customer customer;
}

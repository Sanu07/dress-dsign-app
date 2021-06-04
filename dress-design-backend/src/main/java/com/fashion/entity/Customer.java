package com.fashion.entity;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor
@Builder
@Entity
@Table(name = "CUSTOMER_DETAILS")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Type(type = "pg-uuid")
	@Column(name = "_ID", updatable = false)
	private UUID id;

	@Column(name = "CUSTOMER_ID")
	private String customerId;

	@Column(name = "CUSTOMER_NAME", nullable = false)
	private String customerName;

	@Column(name = "CUSTOMER_PHONE", unique = true, length = 10)
	@NotBlank(message = "Phone cannot be null")
	private String phone;

	@Column(name = "CUSTOMER_EMAIL")
	private String email;

	@Column(name = "CUSTOMER_ADDRESS")
	@NotBlank(message = "Address cannot be null")
	private String address;

	@Version
	private int version;

	@CreationTimestamp
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	@Column(name = "CREATED_AT")
	private LocalDateTime createdAt;

	@CreatedBy
	@Column(name = "CREATED_BY_USER_ID")
	private String createdByUserId;

	@UpdateTimestamp
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	@Column(name = "LAST_UPDATED_AT")
	private LocalDateTime updatedAt;
	
	@Column(name = "IS_ACTIVE")
	private boolean status;
	
	@OneToMany(mappedBy = "customer", cascade = { CascadeType.PERSIST, CascadeType.REMOVE })
	private Set<Order> orders;

	public void addOrder(Order order) {
		orders.add(order);
		order.setCustomer(this);
	}

	public void removeOrder(Order order) {
		orders.remove(order);
		order.setCustomer(null);
	}

	@OneToMany(mappedBy = "customer", cascade = { CascadeType.PERSIST, CascadeType.REMOVE })
	private Set<Feedback> feedbacks;

	public void addFeedback(Feedback feedback) {
		feedbacks.add(feedback);
		feedback.setCustomer(this);
	}

	public void removeFeedback(Feedback feedback) {
		feedbacks.remove(feedback);
		feedback.setCustomer(null);
	}

	@OneToMany(mappedBy = "customer", cascade = { CascadeType.PERSIST, CascadeType.REMOVE })
	private Set<Payment> payments;

	public void addPayment(Payment payment) {
		payments.add(payment);
		payment.setCustomer(this);
	}

	public void removePayment(Payment payment) {
		payments.remove(payment);
		payment.setCustomer(null);
	}
}

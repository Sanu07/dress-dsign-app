package com.fashion.entity;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;

import com.fashion.dto.Measurements;
import com.fashion.enums.OrderStatusEnum;
import com.fashion.util.MeasurementsConverter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "ORDER_DETAILS")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Type(type = "pg-uuid")
	@Column(name = "_ID", updatable = false)
	private UUID id;

	@Column(name = "ORDER_NO", nullable = false, unique = true)
	private String orderNo;

	@CreationTimestamp
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	@Column(name = "CREATED_AT", updatable = false)
	private LocalDateTime createdAt;

	@Column(name = "ESTIMATED_DELIVERY_DATE")
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	private LocalDateTime estimatedDeliveryDate;

	@Column(name = "ORDER_DELIVERED_ON")
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	private LocalDateTime orderDeliveredOn;

	@UpdateTimestamp
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	@Column(name = "LAST_UPDATED_AT")
	private LocalDateTime updatedAt;

	@Enumerated(EnumType.STRING)
	@Column(name = "STATUS", nullable = false)
	private OrderStatusEnum orderStatus;
	
	@Version
	private int version;
	
	@JsonIgnore
	@ManyToOne(cascade = { CascadeType.PERSIST })
	@JoinColumn(name = "customer_id")
	private Customer customer;

	@Convert(converter = MeasurementsConverter.class)
	@Column(name = "MEASUREMENTS")
    private Map<String, Measurements> measurements;
	
	@OneToMany(mappedBy = "order", cascade = { CascadeType.PERSIST, CascadeType.REMOVE })
	private Set<Payment> payments;

	public void addPayment(Payment payment) {
		payments.add(payment);
		payment.setOrder(this);
	}

	public void removePayment(Payment payment) {
		payments.remove(payment);
		payment.setOrder(null);
	}

}

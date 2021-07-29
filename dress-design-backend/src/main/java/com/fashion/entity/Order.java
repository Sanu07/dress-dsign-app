package com.fashion.entity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fashion.dto.Measurements;
import com.fashion.enums.OrderStatusEnum;
import com.fashion.util.MeasurementsConverter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder(builderMethodName = "orderBuilder")
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "ORDER_DETAILS")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Order extends BaseEntity{

	@Column(name = "ORDER_ID")
	@NotBlank
	private String orderId;

	@Column(name = "ESTIMATED_DELIVERY_DATE")
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	private LocalDateTime estimatedDeliveryDate;

	@Column(name = "ORDER_DELIVERED_ON")
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	private LocalDateTime orderDeliveredOn;

	@Enumerated(EnumType.STRING)
	@Column(name = "STATUS", nullable = false)
	private OrderStatusEnum orderStatus;

	@Convert(converter = MeasurementsConverter.class)
	@Column(name = "MEASUREMENTS")
	private List<Measurements> measurements;
	
	@Column(name = "TOTAL_AMOUNT")
	private Double totalAmount;
	
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;

	@OneToMany(mappedBy = "order")
	@JsonIgnore
	private Set<Payment> payments;

	@OneToOne(mappedBy = "order")
	@JsonIgnore
	private Feedback feedback;

}

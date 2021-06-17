package com.fashion.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(builderMethodName = "feedbackBuilder")
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "FEEDBACK_DETAILS")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Feedback extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "DESCRIPTION", nullable = false)
	private String description;

	@Column(name = "RATING", nullable = false)
	private Integer rating;

	@OneToOne
	@JoinColumn(name = "order_id")
	private Order order;

	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;

}

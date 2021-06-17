package com.fashion.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.CreatedBy;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(builderMethodName = "customerBuilder")
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "CUSTOMER_DETAILS")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Customer extends BaseEntity {

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

	@CreatedBy
	@Column(name = "CREATED_BY_USER_ID")
	private String createdByUserId;

	@OneToMany(mappedBy = "customer")
	@JsonIgnore
	private Set<Order> orders;

	@OneToMany(mappedBy = "customer")
	@JsonIgnore
	private Set<Feedback> feedbacks;

	@OneToMany(mappedBy = "customer")
	private Set<Payment> payments;
	
}

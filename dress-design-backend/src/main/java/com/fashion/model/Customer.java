
package com.fashion.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor
@Entity
@Table(name = "CUSTOMER_DETAILS")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "_ID")
	private long id;

	@Column(name = "CUSTOMER_REF_NO", nullable = false)
	private String customerRefNo;

	@Column(name = "CUSTOMER_NAME", nullable = false)
	private String customerName;

	@Column(name = "CUSTOMER_PHONE", unique = true, nullable = false)
	private String customerPhone;

	@Column(name = "CUSTOMER_EMAIL", unique = true)
	private String customerEmail;

	@Column(name = "CUSTOMER_ADDRESS", nullable = false)
	private String customerAddress;
	
	@OneToMany(mappedBy = "customer")
	@JsonIgnore
	private List<Orders> orders;
}

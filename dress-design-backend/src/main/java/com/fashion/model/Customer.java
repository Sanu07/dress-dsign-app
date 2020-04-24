
package com.fashion.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

	// 1st 2 last 2 alphabets and then last 4 digits of their ph no
	@Column(name = "CUSTOMER_REF_NO")
	private String customer;

	@Column(name = "CUSTOMER_NAME")
	private String customerName;

	@Column(name = "CUSTOMER_PHONE")
	private String phone;

	@Column(name = "CUSTOMER_EMAIL")
	private String email;

	@Column(name = "CUSTOMER_ADDRESS")
	private String address;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "customer")
	private List<Orders> orders;
}

package com.fashion.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor
@Entity
@Table(name = "DRESS_DETAILS")
public class Dress {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "DRESS_ID")
	private long id;
	private String dressId;
	private DressMeasurements dressMeasurements;
	private String dressType;
	private Orders orders;
	private Customer customer;
}

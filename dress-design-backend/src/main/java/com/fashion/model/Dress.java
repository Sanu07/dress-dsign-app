package com.fashion.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fashion.enumutil.DressType;

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
	@Column(name = "_ID")
	private long id;
	
	@Column(name = "DRESS_REF_NO")
	private String dressId;
	
	@OneToOne
	private DressMeasurements dressMeasurements;
	
	private DressType dressType;
	
	@OneToOne
	private Orders orders;
	
	@Column(name = "TOTAL_AMOUNT")
	private String totalAmount;
}

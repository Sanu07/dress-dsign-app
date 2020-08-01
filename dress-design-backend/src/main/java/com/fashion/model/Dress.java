package com.fashion.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fashion.enumutil.DressType;
import com.fasterxml.jackson.annotation.JsonIgnore;

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
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "dress_measurements_id")
	private DressMeasurements dressMeasurements;
	
	@Column(name = "DRESS_TYPE")
	private DressType dressType = DressType.ANARKALI_AND_CHURIDAAR;
	
	@OneToOne(mappedBy = "dress")
	@JsonIgnore
	private Orders orders;
	
}

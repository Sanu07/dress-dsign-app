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
@Table(name = "DRESS_TYPE")
public class DressType {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "DRESS_TYPE_ID")
	private long id;
	
	@Column(name = "LEHENGA")
	private String lehenga;
	
	@Column(name = "GHAGRA")
	private String ghagra;
	
	@Column(name = "SALWAR_KAMEEZ")
	private String salwarKameez;
	
	@Column(name = "ANARKALI_AND_CHURIDAAR")
	private String anarkaliAndChuridaar;
}

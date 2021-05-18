package com.fashion.entity;

import java.util.UUID;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.Type;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor
@Builder
@Entity
public class Measurements {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Type(type = "pg-uuid")
	@Column(name = "_ID", updatable = false)
	private UUID id;
	private String name;
	private String value;
	private Double amount;
}

package com.fashion.dto;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.Entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Measurements implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String size;
	private Double amount;
}

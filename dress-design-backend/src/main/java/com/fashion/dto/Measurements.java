package com.fashion.dto;

import java.io.Serializable;

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
	
	private String name;
	private String size;
	private Double amount;
}

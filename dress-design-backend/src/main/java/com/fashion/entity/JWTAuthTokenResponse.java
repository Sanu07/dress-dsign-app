package com.fashion.entity;

import java.io.Serializable;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JWTAuthTokenResponse implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String token;

}

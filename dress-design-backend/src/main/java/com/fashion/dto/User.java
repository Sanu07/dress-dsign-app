package com.fashion.dto;

import java.util.UUID;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
@Builder
@Document(collection = "user_details")
public class User {
	@Id
	private UUID id;

	private String fullName;

	private String password;

	private String email;

	private String loginId;

	private long phone;

}

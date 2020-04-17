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
@Table(name = "user_details")
@SuppressWarnings("unused")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private long id;
	@Column(name = "FULL_NAME", nullable = false)
	private String fullName;
	@Column(name = "PASSWORD", nullable = false)
	private String password;
	@Column(name = "LOGIN_ID", nullable = false)
	private String loginId;
	@Column(name = "EMAIL")
	private String email;
	@Column(name = "PHONE", nullable = false)
	private long phone;
	@Column(name = "GENDER")
	private String gender;
}

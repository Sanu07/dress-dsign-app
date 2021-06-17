package com.fashion.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "USER_DETAILS")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class User extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "FULL_NAME", nullable = false)
	private String fullName;

	@Column(name = "LOGIN_ID", nullable = false)
	private String loginId;

	@Column(name = "PASSWORD", nullable = false)
	private String password;

	@Column(name = "EMAIL", nullable = false)
	private String email;

	@Column(name = "PHONE", nullable = false)
	private String phone;

}
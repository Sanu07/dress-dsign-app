package com.fashion.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor
@Entity
@Table(name = "RECEIVED_DETAILS")
public class ReceivedDates {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "RECEIVED_ID")
	private long id;

	@Column(name = "RECEIVED_AMOUNT")
	private String paidAmount;

	@Column(name = "RECEIVED_DATE")
	@Temporal(TemporalType.DATE)
	private Date receivedDate = new Date();

	@Column(name = "DUE_AMOUNT")
	private String dueAmount;
}
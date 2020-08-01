package com.fashion.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor
@Entity
@Table(name = "DRESS_MEASUREMENTS")
public class DressMeasurements {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "_ID")
	private long id;
	
	@Column(name = "NECK")
	private String neck;
	
	@Column(name = "OVER_BUST")
	private String overBust;
	
	@Column(name = "BUST")
	private String bust;
	
	@Column(name = "UNDER_BUST")
	private String underBust;
	
	@Column(name = "WAIST")
	private String waist;
	
	@Column(name = "HIPS")
	private String hips;
	
	@Column(name = "NECK_TO_HEEL")
	private String neckToHeel;
	
	@Column(name = "NECK_TO_ABOVE_KNEE")
	private String neckToAboveKnee;
	
	@Column(name = "ABOVE_KNEE_TO_ANKLE")
	private String aboveKneeToAnkle;
	
	@Column(name = "ARM_LENGTH")
	private String armLength;
	
	@Column(name = "SHOULDER_SEAM")
	private String shoulderSeam;
	
	@Column(name = "ARM_HOLE")
	private String armHole;
	
	@Column(name = "BICEP")
	private String bicep;
	
	@Column(name = "FORE_ARM")
	private String foreArm;
	
	@Column(name = "WRIST")
	private String wrist;
	
	@Column(name = "V_NECK_OUT")
	private String vneckOut;
	
	@Column(name = "SHOULDER_TO_WAIST")
	private String shoulderToWaist;
	
	@Column(name = "WAIST_TO_ABOVE_KNEE")
	private String waistToAboveKnee;
	
	@Type(type="text")
	@Column(name = "COMMENTS", columnDefinition = "TEXT default ''")
	private String comments;

}


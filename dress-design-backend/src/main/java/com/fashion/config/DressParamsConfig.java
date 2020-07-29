package com.fashion.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:dress.properties")
public class DressParamsConfig {

	@Value("${neck}")
	private String neck;
	
	@Value("${overbust}")
	private String overBust;
	
	@Value("${bust}")
	private String bust;
	
	@Value("${underbust}")
	private String underBust;
	
	@Value("${waist}")
	private String waist;
	
	@Value("${hips}")
	private String hips;
	
	@Value("${necktoheel}")
	private String neckToHeel;
	
	@Value("${necktoaboveknee}")
	private String neckToAboveKnee;
	
	@Value("${abovekneetoankle}")
	private String aboveKneeToAnkle;
	
	@Value("${armlength}")
	private String armLength;
	
	@Value("${shoulderseam}")
	private String shoulderSeam;
	
	@Value("${armhole}")
	private String armHole;
	
	@Value("${bicep}")
	private String bicep;
	
	@Value("${forearm}")
	private String foreArm;
	
	@Value("${wrist}")
	private String wrist;
	
	@Value("${vneckout}")
	private String vneckOut;
	
	@Value("${shouldertowaist}")
	private String shoulderToWaist;
	
	@Value("${waisttoaboveknee}")
	private String waistToAboveKnee;

	public String getNeck() {
		return neck;
	}

	public void setNeck(String neck) {
		this.neck = neck;
	}

	public String getOverBust() {
		return overBust;
	}

	public void setOverBust(String overBust) {
		this.overBust = overBust;
	}

	public String getBust() {
		return bust;
	}

	public void setBust(String bust) {
		this.bust = bust;
	}

	public String getUnderBust() {
		return underBust;
	}

	public void setUnderBust(String underBust) {
		this.underBust = underBust;
	}

	public String getWaist() {
		return waist;
	}

	public void setWaist(String waist) {
		this.waist = waist;
	}

	public String getHips() {
		return hips;
	}

	public void setHips(String hips) {
		this.hips = hips;
	}

	public String getNeckToHeel() {
		return neckToHeel;
	}

	public void setNeckToHeel(String neckToHeel) {
		this.neckToHeel = neckToHeel;
	}

	public String getNeckToAboveKnee() {
		return neckToAboveKnee;
	}

	public void setNeckToAboveKnee(String neckToAboveKnee) {
		this.neckToAboveKnee = neckToAboveKnee;
	}

	public String getAboveKneeToAnkle() {
		return aboveKneeToAnkle;
	}

	public void setAboveKneeToAnkle(String aboveKneeToAnkle) {
		this.aboveKneeToAnkle = aboveKneeToAnkle;
	}

	public String getArmLength() {
		return armLength;
	}

	public void setArmLength(String armLength) {
		this.armLength = armLength;
	}

	public String getShoulderSeam() {
		return shoulderSeam;
	}

	public void setShoulderSeam(String shoulderSeam) {
		this.shoulderSeam = shoulderSeam;
	}

	public String getArmHole() {
		return armHole;
	}

	public void setArmHole(String armHole) {
		this.armHole = armHole;
	}

	public String getBicep() {
		return bicep;
	}

	public void setBicep(String bicep) {
		this.bicep = bicep;
	}

	public String getForeArm() {
		return foreArm;
	}

	public void setForeArm(String foreArm) {
		this.foreArm = foreArm;
	}

	public String getWrist() {
		return wrist;
	}

	public void setWrist(String wrist) {
		this.wrist = wrist;
	}

	public String getVneckOut() {
		return vneckOut;
	}

	public void setVneckOut(String vneckOut) {
		this.vneckOut = vneckOut;
	}

	public String getShoulderToWaist() {
		return shoulderToWaist;
	}

	public void setShoulderToWaist(String shoulderToWaist) {
		this.shoulderToWaist = shoulderToWaist;
	}

	public String getWaistToAboveKnee() {
		return waistToAboveKnee;
	}

	public void setWaistToAboveKnee(String waistToAboveKnee) {
		this.waistToAboveKnee = waistToAboveKnee;
	}
	
}

package com.fashion.enumutil;

public enum DressType {
	
	LEHENGA("L"), GHAGRA("G"), SALWAR_KAMEEZ("SK"), ANARKALI_AND_CHURIDAAR("AC");

	private String dressType;

	public String getDressType() {
		return this.dressType;
	}

	DressType(String dressType) {
		this.dressType = dressType;
	}
}

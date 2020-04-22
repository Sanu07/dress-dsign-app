package com.fashion.service;

import com.fashion.model.DressMeasurements;

public interface DressMeasurementsService {
	
	public DressMeasurements saveDressMeasurements(DressMeasurements measurements);
	
	public DressMeasurements updateDressMeasurements(DressMeasurements dressMeasurements);
	
	public Iterable<DressMeasurements> getAllDressMeasurements();
	
	public DressMeasurements getDressMeasurement(long dressMeasurementId);
	
	public void deleteDressMeasurements(long dressMeasurementId);
}

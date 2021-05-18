package com.fashion.service;

import com.fashion.entity.Measurements;

public interface DressMeasurementsService {
	
	public Measurements saveDressMeasurements(Measurements measurements);
	
	public Measurements updateDressMeasurements(Measurements dressMeasurements);
	
	public Iterable<Measurements> getAllDressMeasurements();
	
	public Measurements getDressMeasurement(long dressMeasurementId);
	
	public void deleteDressMeasurements(long dressMeasurementId);
}

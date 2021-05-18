package com.fashion.command.service;

import org.springframework.stereotype.Service;

import com.fashion.entity.Measurements;

@Service
public interface MeasurementsCommandService {
	
	public Measurements saveDressMeasurements(Measurements measurements);
	
	public Measurements updateDressMeasurements(Measurements dressMeasurements);
	
	public void deleteDressMeasurements(long dressMeasurementId);
}

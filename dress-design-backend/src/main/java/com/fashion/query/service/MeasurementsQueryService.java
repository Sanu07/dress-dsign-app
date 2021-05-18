package com.fashion.query.service;

import org.springframework.stereotype.Service;

import com.fashion.entity.Measurements;

@Service
public interface MeasurementsQueryService {
	
	public Iterable<Measurements> getAllDressMeasurements();
	
	public Measurements getDressMeasurement(long dressMeasurementId);
}

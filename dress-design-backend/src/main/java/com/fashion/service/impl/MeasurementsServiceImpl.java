package com.fashion.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fashion.dao.MeasurementsDao;
import com.fashion.model.DressMeasurements;
import com.fashion.service.DressMeasurementsService;

@Service
public class MeasurementsServiceImpl implements DressMeasurementsService {

	@Autowired
	MeasurementsDao measurementDao;

	@Override
	public DressMeasurements saveDressMeasurements(DressMeasurements measurements) {
		return measurementDao.save(measurements);
	}

	@Override
	public DressMeasurements updateDressMeasurements(DressMeasurements dressMeasurements) {
		return measurementDao.save(dressMeasurements);
	}

	@Override
	public Iterable<DressMeasurements> getAllDressMeasurements() {
		return measurementDao.findAll();
	}

	@Override
	public DressMeasurements getDressMeasurement(long dressMeasurementId) {
		return measurementDao.findById(dressMeasurementId).orElse(new DressMeasurements());
	}

	@Override
	public void deleteDressMeasurements(long dressMeasurementId) {
		measurementDao.deleteById(dressMeasurementId);
	}

}

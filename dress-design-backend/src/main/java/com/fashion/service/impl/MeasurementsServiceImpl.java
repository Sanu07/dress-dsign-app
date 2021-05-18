package com.fashion.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fashion.command.dao.MeasurementsCommandDao;
import com.fashion.entity.Measurements;
import com.fashion.service.DressMeasurementsService;

@Service
public class MeasurementsServiceImpl implements DressMeasurementsService {

	@Autowired
	MeasurementsCommandDao measurementDao;

	@Override
	public Measurements saveDressMeasurements(Measurements measurements) {
		return measurementDao.save(measurements);
	}

	@Override
	public Measurements updateDressMeasurements(Measurements dressMeasurements) {
		return measurementDao.save(dressMeasurements);
	}

	@Override
	public Iterable<Measurements> getAllDressMeasurements() {
		return measurementDao.findAll();
	}

	@Override
	public Measurements getDressMeasurement(long dressMeasurementId) {
		return measurementDao.findById(dressMeasurementId).orElse(new Measurements());
	}

	@Override
	public void deleteDressMeasurements(long dressMeasurementId) {
		measurementDao.deleteById(dressMeasurementId);
	}

}

package com.fashion.command.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fashion.command.dao.MeasurementsCommandDao;
import com.fashion.command.service.MeasurementsCommandService;
import com.fashion.entity.Measurements;

@Service
public class MeasurementsCommandServiceImpl implements MeasurementsCommandService {

	@Autowired
	MeasurementsCommandDao measurementCommandDao;

	@Override
	public Measurements saveDressMeasurements(Measurements measurements) {
		return measurementCommandDao.save(measurements);
	}

	@Override
	public Measurements updateDressMeasurements(Measurements dressMeasurements) {
		return measurementCommandDao.save(dressMeasurements);
	}

	@Override
	public void deleteDressMeasurements(long dressMeasurementId) {
		measurementCommandDao.deleteById(dressMeasurementId);
	}

}

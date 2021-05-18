
package com.fashion.query.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.fashion.command.dao.MeasurementsCommandDao;
import com.fashion.entity.Measurements;
import com.fashion.query.service.MeasurementsQueryService;

public class MeasurementsQueryServiceImpl implements MeasurementsQueryService {

	@Autowired
	private MeasurementsCommandDao measurementQueryDao;
	
	@Override
	public Iterable<Measurements> getAllDressMeasurements() {
		return measurementQueryDao.findAll();
	}

	@Override
	public Measurements getDressMeasurement(long dressMeasurementId) {
		return measurementQueryDao.findById(dressMeasurementId).orElse(new Measurements());
	}

}

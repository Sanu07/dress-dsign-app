package com.fashion.dao;

import org.springframework.data.repository.CrudRepository;

import com.fashion.model.DressMeasurements;

public interface MeasurementsDao extends CrudRepository<DressMeasurements, Long>{

}

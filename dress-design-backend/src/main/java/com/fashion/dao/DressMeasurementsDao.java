package com.fashion.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fashion.model.DressMeasurements;

@Repository
public interface DressMeasurementsDao extends CrudRepository<DressMeasurements, Long>{

}

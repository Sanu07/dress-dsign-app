package com.fashion.command.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fashion.entity.Measurements;

@Repository
public interface MeasurementsCommandDao extends JpaRepository<Measurements, Long> {

}

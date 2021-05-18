package com.fashion.command.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fashion.command.service.impl.MeasurementsCommandServiceImpl;
import com.fashion.entity.Measurements;
import com.fashion.service.DressMeasurementsService;

@RestController
@RequestMapping("/measurements") 
@CrossOrigin(origins = "*")
public class MeasurementsCommandController {

	@Autowired
	DressMeasurementsService measurementsService;
	
	@Autowired
	MeasurementsCommandServiceImpl dm;
	
	@PostMapping
	public Measurements saveMeasurements(@RequestBody Measurements measurements) {
		return measurementsService.saveDressMeasurements(measurements);
	}
	
	@PutMapping("/{measurementId}")
	public Measurements updateMeasurements(@RequestBody Measurements dressMeasurements) {
		return measurementsService.updateDressMeasurements(dressMeasurements);
	}
	
	@DeleteMapping
	public void deleteMeasurements(@PathVariable long dressMeasurementId) {
		measurementsService.deleteDressMeasurements(dressMeasurementId);
	}
	
}

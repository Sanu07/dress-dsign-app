package com.fashion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fashion.model.DressMeasurements;
import com.fashion.service.DressMeasurementsService;

@RestController
@CrossOrigin(origins = "*")
public class DressMeasurementsController {

	@Autowired
	DressMeasurementsService measurementsService;
	
	@PostMapping("/measurements")
	public DressMeasurements saveMeasurements(@RequestBody DressMeasurements measurements) {
		return measurementsService.saveDressMeasurements(measurements);
	}
	
	@GetMapping("/measurements")
	public List<DressMeasurements> getAllMeasurements() {
		return (List<DressMeasurements>) measurementsService.getAllDressMeasurements();
	}
	
	@GetMapping("/measurements/{measurementId}")
	public DressMeasurements getMeasurement(@PathVariable("measurementId") long dressMeasurementId) {
		return measurementsService.getDressMeasurement(dressMeasurementId);
	}
	
	@PutMapping("/measurements")
	public DressMeasurements updateMeasurements(@RequestBody DressMeasurements dressMeasurements) {
		return measurementsService.updateDressMeasurements(dressMeasurements);
	}
	
	@DeleteMapping("/measurements/{measurementId}")
	public void deleteMeasurements(@PathVariable("measurementId") long dressMeasurementId) {
		measurementsService.deleteDressMeasurements(dressMeasurementId);
	}
}

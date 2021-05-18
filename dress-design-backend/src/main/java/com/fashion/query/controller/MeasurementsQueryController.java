package com.fashion.query.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.reactive.WebFluxAutoConfiguration.EnableWebFluxConfiguration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fashion.entity.Measurements;
import com.fashion.service.DressMeasurementsService;

@RestController
@RequestMapping("/measurements") 
@CrossOrigin(origins = "*")
public class MeasurementsQueryController {

	@Autowired
	DressMeasurementsService measurementsService;
	
	@GetMapping
	public List<Measurements> getAllMeasurements() {
		return (List<Measurements>) measurementsService.getAllDressMeasurements();
	}
	
	@GetMapping("/{measurementId}")
	public Measurements getMeasurement(@PathVariable long dressMeasurementId) {
		return measurementsService.getDressMeasurement(dressMeasurementId);
	}
	
}

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

import com.fashion.config.DressParamsConfig;
import com.fashion.model.Dress;
import com.fashion.service.DressService;

@RestController
@CrossOrigin("*")
public class DressController {

	@Autowired
	DressService dressService;
	
	@Autowired
	DressParamsConfig dressParams;
	
	@PostMapping("/dress")
	public Dress saveDress(@RequestBody Dress dress) {
		return dressService.saveDress(dress);
	}
	
	@GetMapping("/dress")
	public List<Dress> getAllDresss() {
		return (List<Dress>) dressService.getAllDresses();
	}
	
	@GetMapping("/dress/params")
	public DressParamsConfig getAllDresssParams() {
		return dressParams;
	}
	
	@GetMapping("/dress/{dressId}")
	public Dress getDress(@PathVariable("dressId") long dressId) {
		return dressService.getDress(dressId);
	}
	
	@PutMapping("/dress")
	public Dress updateDress(@RequestBody Dress dress) {
		return dressService.updateDress(dress);
	}
	
	@DeleteMapping("/dress/{dressId}")
	public void deleteDress(@PathVariable("dressId") long dressId) {
		dressService.deleteDress(dressId);;
	}
}

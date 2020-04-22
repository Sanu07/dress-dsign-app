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

import com.fashion.model.DressType;
import com.fashion.service.DressTypeService;

@RestController
@CrossOrigin(origins = "*")
public class DressTypeController {
	
	@Autowired
	DressTypeService dressTypeService;
	
	@PostMapping("/types")
	public DressType saveDressType(@RequestBody DressType dressTypes) {
		return dressTypeService.saveDressTypes(dressTypes); 
	}
	
	@GetMapping("/types")
	public List<DressType> getAllDressTypes() {
		return (List<DressType>) dressTypeService.getAllDressTypes();
	}
	
	@GetMapping("/types/{dressTypeId}")
	public DressType getDressTypes(@PathVariable long dressTypeId) {
		return dressTypeService.getDressTypes(dressTypeId);
	}
	
	@PutMapping("/types")
	public DressType updateDressType(@RequestBody DressType dressTypes) {
		return dressTypeService.updateDressTypes(dressTypes);
	}
	
	@DeleteMapping("/types/{dressTypeId}")
	public void deleteDressType(@PathVariable long dressTypeId) {
		dressTypeService.deleteDressTypes(dressTypeId);
	}
}

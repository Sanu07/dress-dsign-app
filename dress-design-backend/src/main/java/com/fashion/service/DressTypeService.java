package com.fashion.service;

import com.fashion.entity.Measurements;
import com.fashion.entity.DressType;

public interface DressTypeService {
	
	public DressType saveDressTypes(DressType dressTypes);
	
	public DressType updateDressTypes(DressType dressTypes);
	
	public Iterable<DressType> getAllDressTypes();
	
	public DressType getDressTypes(long dressTypeId);
	
	public void deleteDressTypes(long dressTypeId);
}

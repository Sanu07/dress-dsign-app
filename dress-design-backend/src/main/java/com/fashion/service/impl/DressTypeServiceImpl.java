package com.fashion.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fashion.command.dao.DressTypeDao;
import com.fashion.entity.DressType;
import com.fashion.service.DressTypeService;

@Service
public class DressTypeServiceImpl implements DressTypeService{

	@Autowired
	DressTypeDao dressTypesDao;
	
	@Override
	public DressType saveDressTypes(DressType dressTypes) {
		return dressTypesDao.save(dressTypes);
	}

	@Override
	public DressType updateDressTypes(DressType dressTypes) {
		return dressTypesDao.save(dressTypes);
	}

	@Override
	public Iterable<DressType> getAllDressTypes() {
		return dressTypesDao.findAll();
	}

	@Override
	public DressType getDressTypes(long dressTypeId) {
		return dressTypesDao.findById(dressTypeId).orElse(null);
	}

	@Override
	public void deleteDressTypes(long dressTypeId) {
		dressTypesDao.deleteById(dressTypeId);
	}

}

package com.fashion.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fashion.dao.DressDao;
import com.fashion.model.Dress;
import com.fashion.service.DressService;

@Service
public class DressServiceImpl implements DressService {

	@Autowired
	DressDao dressDao;
	
	@Override
	public Dress saveDress(Dress dress) {
		return dressDao.save(dress);
	}

	@Override
	public Dress updateDress(Dress dress) {
		return dressDao.save(dress);
	}

	@Override
	public Iterable<Dress> getAllDresses() {
		return dressDao.findAll();
	}

	@Override
	public Dress getDress(long dressId) {
		return dressDao.findById(dressId).orElse(null);
	}

	@Override
	public void deleteDress(long dressId) {
		dressDao.deleteById(dressId);
	}

}

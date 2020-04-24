package com.fashion.service;

import com.fashion.model.Dress;

public interface DressService {

	public Dress saveDress(Dress dress);

	public Dress updateDress(Dress dress);

	public Iterable<Dress> getAllDresses();

	public Dress getDress(long dressId);

	public void deleteDress(long dressId);
}

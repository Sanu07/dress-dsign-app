package com.fashion.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fashion.dao.PaymentReceivedDao;
import com.fashion.model.ReceivedDates;
import com.fashion.service.PaymentReceivedService;

@Service
public class PaymentReceivedDatesServiceImpl implements PaymentReceivedService {

	@Autowired
	private PaymentReceivedDao paymentReceivedDao;

	@Override
	public List<ReceivedDates> getAllReceivedDates() {
		return paymentReceivedDao.findAll();
	}

	@Override
	public ReceivedDates getReceivedDate(long id) {
		return paymentReceivedDao.findById(id).orElse(null);
	}

	@Override
	public ReceivedDates saveReceivedDate(ReceivedDates receivedDates) {
		return paymentReceivedDao.save(receivedDates);
	}

	@Override
	public ReceivedDates updateReceivedDate(ReceivedDates receivedDates) {
		return paymentReceivedDao.save(receivedDates);
	}

	@Override
	public void deleteReceivedDate(long id) {
		paymentReceivedDao.deleteById(id);
	}

}

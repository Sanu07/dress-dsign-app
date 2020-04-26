package com.fashion.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fashion.dao.PaymentDao;
import com.fashion.model.Payment;
import com.fashion.service.PaymentsService;

@Service
public class PaymentsServiceImpl implements PaymentsService{

	@Autowired
	PaymentDao paymentsDao;
	
	@Override
	public Payment savePayment(Payment payment) {
		return paymentsDao.save(payment);
	}

	@Override
	public Payment updatePayment(Payment payment) {
		return paymentsDao.save(payment);
	}

	@Override
	public Iterable<Payment> getAllPayments() {
		return paymentsDao.findAll();
	}

	@Override
	public Payment getPayment(long paymentId) {
		return paymentsDao.findById(paymentId).orElse(null);
	}

	@Override
	public void deletePayment(long paymentId) {
		paymentsDao.deleteById(paymentId);
	}

}

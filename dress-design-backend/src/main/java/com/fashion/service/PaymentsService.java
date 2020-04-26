package com.fashion.service;

import com.fashion.model.Payment;

public interface PaymentsService {

	public Payment savePayment(Payment payment);

	public Payment updatePayment(Payment payment);

	public Iterable<Payment> getAllPayments();

	public Payment getPayment(long paymentId);

	public void deletePayment(long paymentId);
}

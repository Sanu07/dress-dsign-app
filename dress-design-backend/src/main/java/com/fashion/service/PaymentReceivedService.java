package com.fashion.service;

import java.util.List;

import com.fashion.model.ReceivedDates;

public interface PaymentReceivedService {
	public List<ReceivedDates> getAllReceivedDates();

	public ReceivedDates getReceivedDate(long id);

	public ReceivedDates saveReceivedDate(ReceivedDates receivedDates);

	public ReceivedDates updateReceivedDate(ReceivedDates receivedDates);

	public void deleteReceivedDate(long id);
}

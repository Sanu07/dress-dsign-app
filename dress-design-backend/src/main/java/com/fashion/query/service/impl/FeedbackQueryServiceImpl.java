package com.fashion.query.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fashion.dto.Customer;
import com.fashion.dto.Feedback;
import com.fashion.dto.Order;
import com.fashion.query.dao.FeedbackQueryDao;
import com.fashion.query.dao.OrderQueryDao;
import com.fashion.query.service.CustomerQueryService;
import com.fashion.query.service.FeedbackQueryService;
import com.fashion.query.service.OrderQueryService;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class FeedbackQueryServiceImpl extends BaseServiceImpl implements FeedbackQueryService {

	private final FeedbackQueryDao feedbackDao;
	private final OrderQueryDao orderDao;
	private OrderQueryService orderService;
	
	public FeedbackQueryServiceImpl(FeedbackQueryDao feedbackDao, OrderQueryDao orderDao,
			@Lazy OrderQueryService orderService) {
		super();
		this.feedbackDao = feedbackDao;
		this.orderDao = orderDao;
		this.orderService = orderService;
	}
	
	@Override
	public Flux<Feedback> getAllFeedbacks() {
		return feedbackDao.findAll();
	}

	@Override
	public Mono<Feedback> getFeedbackById(String feedbackId) {
		return feedbackDao.findById(feedbackId);
	}

	@Override
	public ResponseEntity<Feedback> saveFeedback(Feedback feedback) {
		feedbackDao.save(feedback).subscribe(savedFeedback -> {
			log.info("Feedback saved in DB {} ", savedFeedback);
			updateOrderWithFeedback(savedFeedback);
		});
		return ResponseEntity.ok(feedback);
	}

	@Override
	public ResponseEntity<Feedback> updateFeedback(Feedback feedback) {
		feedbackDao.save(feedback).subscribe(updatedFeedback -> {
			log.info("Feedback updated in DB {} ", updatedFeedback);
			updateOrderWithFeedback(updatedFeedback);
		});
		return ResponseEntity.ok(feedback);
	}

	@Override
	public Mono<Feedback> deleteFeedbackById(String feedbackId) {
		Boolean acknowledged = updateSingleObject(Feedback.class, feedbackId, "status", false, Boolean.class);
		if (acknowledged) {
			log.info("Feedback with Id {} deleted successfully ", feedbackId);
			Mono<Feedback> updatedFeedback = feedbackDao.findById(feedbackId);
			updatedFeedback.subscribe(fdbk -> {
				updateOrderWithFeedback(fdbk);
			});
		}
		return null;
	}
	
	@Override
	public void updateOrderWithFeedback(Feedback feedback) {
		if (StringUtils.isNotEmpty(feedback.getOrderId())) {
			Mono<Order> order = orderDao.findByOrderId(feedback.getOrderId());
			order.subscribe(o -> {
				if (o != null) {
					o.setFeedback(feedback);
					o.setCustomerId(feedback.getCustomerId());
					orderService.saveOrder(o);
				}
			});
		}
	}

	@Override
	public void deleteFeedbacksByCustomerId(String customerId) {
		Boolean acknowledged = updateMultipleObjects(Feedback.class, "customerId", customerId, String.class, "status", false, Boolean.class);
		if (acknowledged) {
			log.info("Feedbacks deleted for customer Id {} ", customerId);
		}
	}

	@Override
	public void deleteFeedbacksByOrderId(String orderId) {
		Boolean acknowledged = updateMultipleObjects(Feedback.class, "orderId", orderId, String.class, "status", false, Boolean.class);
		if (acknowledged) {
			log.info("Feedbacks deleted for order Id {} ", orderId);
		}
	}
	
}

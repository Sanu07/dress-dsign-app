package com.fashion.query.service.impl;

import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fashion.dto.Feedback;
import com.fashion.dto.Order;
import com.fashion.query.dao.FeedbackQueryDao;
import com.fashion.query.dao.OrderQueryDao;
import com.fashion.query.service.FeedbackQueryService;
import com.fashion.query.service.OrderQueryService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
@Slf4j
public class FeedbackQueryServiceImpl implements FeedbackQueryService {

	private FeedbackQueryDao feedbackDao;
	private OrderQueryDao orderDao;
	private OrderQueryService orderService;

	@Override
	public Flux<Feedback> getAllFeedbacks() {
		return feedbackDao.findAll();
	}

	@Override
	public Mono<Feedback> getFeedbackById(UUID feedbackId) {
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
	public Mono<Feedback> deleteFeedbackById(UUID feedbackId) {
		return feedbackDao.deleteFeedbackById(feedbackId, false);
	}

	@Override
	public void updateOrderWithFeedback(Feedback feedback) {
		if (StringUtils.isNotEmpty(feedback.getOrderId())) {
			Mono<Order> order = orderDao.findByOrderNo(feedback.getOrderId());
			order.subscribe(o -> {
				if (o != null) {
					o.setFeedback(feedback);
					orderDao.save(o).subscribe(ord -> {
						orderService.updateCustomerWithOrder(ord);
					});
				}
			});
		}
	}

}

package com.fashion.util;

import com.fashion.dto.Feedback;
import com.fashion.dto.Order;

public class EntityToDTOConverter {

	public static Feedback createDTOFeedback(com.fashion.entity.Feedback feedback) {
		return Feedback.builder().id(feedback.getId()).description(feedback.getDescription())
				.rating(feedback.getRating()).version(feedback.getVersion()).createdAt(feedback.getCreatedAt())
				.customerId(feedback.getCustomer().getCustomerId()).orderId(feedback.getOrder().getOrderNo()).build();
	}

	public static Order createDTOOrder(com.fashion.entity.Order order) {
		return Order.builder().id(order.getId()).orderNo(order.getOrderNo())
				.createdAt(order.getCreatedAt())
				.estimatedDeliveryDate(order.getEstimatedDeliveryDate())
				.orderDeliveredOn(order.getOrderDeliveredOn())
				.updatedAt(order.getUpdatedAt())
				.orderStatus(order.getOrderStatus())
				.version(order.getVersion())
				.customerId(order.getCustomer().getCustomerId())
				.measurements(order.getMeasurements())
				.status(true)
				.build();
	}
	
}

package com.fashion.constants;

public class AppConstants {

	public static final String DRESS_CUSTOMER_EVENTS_TOPIC = "dress-customer-events";
	public static final String DRESS_ORDER_EVENTS_TOPIC = "dress-order-events";
	public static final String DRESS_GENERAL_EVENTS_TOPIC = "dress-general-events";
	public static final String DRESS_USER_EVENTS_TOPIC = "dress-user-events";
	
	public static final String DRESS_CUSTOMER_CREATE_EVENT_KEY = "customer-create-event-key";
	public static final String DRESS_CUSTOMER_UPDATE_EVENT_KEY = "customer-update-event-key";
	public static final String DRESS_CUSTOMER_DELETE_EVENT_KEY = "customer-delete-event-key";
	
	public static final String DRESS_ORDER_CREATE_EVENT_KEY = "order-create-event-key";
	public static final String DRESS_ORDER_UPDATE_EVENT_KEY = "order-update-event-key";
	public static final String DRESS_ORDER_DELETE_EVENT_KEY = "order-delete-event-key";
	
	public static final String DRESS_GENERAL_FEEDBACK_EVENT_KEY = "general-feedback-event-key";
	public static final String DRESS_GENERAL_PAYMENT_EVENT_KEY = "general-payment-event-key";
	
	public static final String DRESS_USER_CREATE_EVENT_KEY = "user-create-event-key";
	public static final String DRESS_USER_UPDATE_EVENT_KEY = "user-update-event-key";
	public static final String DRESS_USER_DELETE_EVENT_KEY = "user-delete-event-key";
	
	
	public static final Integer DELETE_EVENT_PARTITION = 0;
	public static final Integer CREATE_EVENT_PARTITION = 1;
	public static final Integer UPDATE_EVENT_PARTITION = 2;
	public static final Integer FEEDBACK_EVENT_PARTITION = 0;
	
	public static final String DRESS_CUSTOMER_GROUP_ID = "customer-group-id";
	public static final String DRESS_ORDER_GROUP_ID = "customer-group-id";
	public static final String DRESS_GENERAL_GROUP_ID = "customer-group-id";
}

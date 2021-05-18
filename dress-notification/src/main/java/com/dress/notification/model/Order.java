package com.dress.notification.model;

import java.util.List;

import lombok.Data;

@Data
public class Order {
    private Integer orderId;
    private String date;
    private Account account;
    private Payment payment;
    private List<Item> items;
}
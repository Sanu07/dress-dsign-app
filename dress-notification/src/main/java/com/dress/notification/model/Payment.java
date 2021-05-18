package com.dress.notification.model;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class Payment {
    private BigDecimal amount;
    private String cardNumber;
    private String cvv;
    private String month;
    private String year;
}
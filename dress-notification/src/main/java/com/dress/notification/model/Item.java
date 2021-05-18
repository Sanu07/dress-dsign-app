package com.dress.notification.model;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class Item {
    private String sku;
    private String name;
    private Integer quantity;
    private BigDecimal price;
}
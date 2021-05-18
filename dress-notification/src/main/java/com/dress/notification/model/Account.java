package com.dress.notification.model;

import lombok.Data;

@Data
public class Account {
    private String name;
    private String phoneNumber;
    private String email;
    private Address address;


}
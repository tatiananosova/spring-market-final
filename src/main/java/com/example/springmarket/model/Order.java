package com.example.springmarket.model;

import java.time.LocalDateTime;

public class Order {
    private LocalDateTime orderDate;
    private Cart cart;
    private User user;
    private String comment;

    public Order(LocalDateTime orderDate, Cart cart, User user, String comment) {
        this.orderDate = orderDate;
        this.cart = cart;
        this.user = user;
        this.comment = comment;
    }
}

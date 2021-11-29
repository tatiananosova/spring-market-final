package com.example.springmarket.model.builder;

import com.example.springmarket.model.Cart;
import com.example.springmarket.model.Order;
import com.example.springmarket.model.User;

import java.time.LocalDateTime;

public class OrderBuilder {
    private LocalDateTime orderDate;
    private Cart cart;
    private User user;
    private String comment;

    public static OrderBuilder builder() {
        return new OrderBuilder();
    }

    public OrderBuilder orderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
        return this;
    }

    public OrderBuilder orderDate() {
        this.orderDate = LocalDateTime.now();
        return this;
    }

    public OrderBuilder cart(Cart cart) {
        this.cart = cart;
        return this;
    }

    public OrderBuilder user(User user) {
        this.user = user;
        return this;
    }

    public OrderBuilder comment(String comment) {
        this.comment = comment;
        return this;
    }

    public Order build() {
        if (cart == null) {
            throw new IllegalStateException("");
        }
        if (user == null) {
            throw new IllegalStateException("");
        }
        return new Order(orderDate, cart, user, comment);
    }
}

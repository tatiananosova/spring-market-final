package com.example.springmarket.payment;

public class PayPalPayment implements Payment{

    @Override
    public void pay(double amount) {
        System.out.println("Processing PayPal payment...");
    }
}

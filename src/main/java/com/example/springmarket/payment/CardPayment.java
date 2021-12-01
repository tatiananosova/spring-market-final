package com.example.springmarket.payment;

public class CardPayment implements Payment{

    @Override
    public void pay(double amount) {
        System.out.println("Processing card payment...");
    }
}

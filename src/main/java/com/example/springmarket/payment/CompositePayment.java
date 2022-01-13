package com.example.springmarket.payment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CompositePayment implements Payment {

    private List<Payment> payments = new ArrayList<>();

    @Override
    public void pay(double amount) {
        for (Payment payment : payments) {
            payment.pay(amount);
        }
    }

    public Payment add(Payment... payments) {
        this.payments.addAll(Arrays.asList(payments));
        return this;
    }

}

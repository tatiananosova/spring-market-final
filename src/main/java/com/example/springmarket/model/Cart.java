package com.example.springmarket.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Component
@SessionScope
public class Cart {
    private List<Product> cart = new ArrayList<>();

    public void addToCart(Product product) {
        cart.add(product);
    }
}

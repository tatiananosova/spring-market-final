package com.example.springmarket.controllers;

import com.example.springmarket.model.Product;
import com.example.springmarket.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cart")
@RequiredArgsConstructor
public class CartControllerV1 {
    private final CartService cartService;

    @PutMapping("/{id}")
    public void addToCart(@PathVariable Long id) {
         cartService.addToCart(id);
    }

    @GetMapping
    public List<Product> getCart() {
        return cartService.getCart();
    }

    @GetMapping("/cost")
    public Integer getCartCost() {
        return cartService.getCartCost();
    }
}

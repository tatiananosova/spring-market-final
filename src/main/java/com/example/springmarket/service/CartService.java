package com.example.springmarket.service;

import com.example.springmarket.model.Cart;
import com.example.springmarket.model.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CartService {

    @Autowired
    private Cart cart;
    private final ProductService productService;

    public void addToCart(Long id) {
        Product product = productService.findById(id);
        cart.addToCart(product);
    }

    public int getCartCost() {
        return cart.getCart().stream().mapToInt(Product::getCost).sum();
    }

    public List<Product> getCart() {
        return cart.getCart();
    }
}

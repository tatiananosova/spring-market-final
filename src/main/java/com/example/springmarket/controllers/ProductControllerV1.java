package com.example.springmarket.controllers;

import com.example.springmarket.model.Product;
import com.example.springmarket.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductControllerV1 {
    private final ProductService productService;

    @GetMapping
    public Page<Product> getAllProducts(@RequestParam(required = false) Map<String, String> params,
                                        @RequestParam(name = "page-number", defaultValue = "1") Integer pageNumber,
                                        @RequestParam(name = "page-size", defaultValue = "5") Integer pageSize) {
        return productService.findAll(params, pageNumber,pageSize);
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product create(@RequestBody Product product) {
        return productService.save(product);
    }

    @PutMapping
    public Product update(@RequestBody Product product) {
        return productService.save(product);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(Long id) {
        productService.deleteById(id);
    }

    @GetMapping("/{id}/delete")
    public void deleteProductById(@PathVariable Long id) {
        productService.deleteById(id);
    }

    @GetMapping("/search_by_title")
    public Product searchByTitle(@RequestParam String title) {
        return productService.findByTitle(title);
    }

    @GetMapping("/search_by_title_like")
    public List<Product> searchByTitleLike(@RequestParam String titleLike) {
        return productService.findAllByTitleIsContaining(titleLike);
    }

    @GetMapping("/search_by_cost_between")
    public List<Product> searchByCostBetween(@RequestParam int min, @RequestParam int max) {
        return productService.findAllByCostBetween(min, max);
    }

    @GetMapping("/search_by_cost_after")
    public List<Product> searchByCostAfter(@RequestParam int cost) {
        return productService.findAllByCostAfter(cost);
    }

    @GetMapping("/search_by_cost_before")
    public List<Product> searchByCostBefore(@RequestParam int cost) {
        return productService.findAllByCostBefore(cost);
    }
}

package com.example.springmarket.service;

import com.example.springmarket.model.Category;
import com.example.springmarket.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id).orElseThrow(() -> new NoSuchElementException(
                String.format("category with id - %s was not found", id)));
    }

    public Category getCategoryByName(String name) {
        return categoryRepository.findByCategoryName(name);
    }
}

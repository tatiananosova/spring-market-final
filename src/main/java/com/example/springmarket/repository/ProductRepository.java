package com.example.springmarket.repository;

import com.example.springmarket.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>, JpaSpecificationExecutor<Product> {
    Optional<Product> findByTitle(String title);
    List<Product> findAllByCostBetween(int min, int max);
    List<Product> findAllByCostAfter(int cost);
    List<Product> findAllByCostBefore(int cost);
    List<Product> findAllByTitleIsContaining(String titleContains);

}

package com.example.springmarket.service.specification;

import com.example.springmarket.model.Product;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import java.util.Map;
import java.util.Objects;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ProductSpecification {

    public static Specification<Product> titleEq(String title) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("title"), title);
    }

    public static Specification<Product> costEq(Integer cost) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("cost"), cost);
    }

    public static Specification<Product> titleLike(String title) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(root.get("title"), title);
    }

    public static Specification<Product> build(Map<String, String> params) {
        return params.entrySet().stream()
                .filter(it-> StringUtils.hasText(it.getValue()))
                .map(it -> {
                    if ("title".equals(it.getKey())) {
                        return ProductSpecification.titleEq(it.getValue());
                    }
                    if ("cost".equals(it.getKey())) {
                        return ProductSpecification.costEq(Integer.parseInt(it.getValue()));
                    }
                    return null;
                })
                .filter(Objects::nonNull)
                .reduce(Specification::and)
                .orElse(null);
    }
}

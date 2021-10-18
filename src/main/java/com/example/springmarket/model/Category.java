package com.example.springmarket.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "categories", uniqueConstraints={@UniqueConstraint(columnNames="category_name")})
@Data
@NoArgsConstructor
public class Category implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "category_name")
    private String categoryName;

    @JsonIgnore
    @Column(nullable = false)
    @OneToMany(mappedBy = "category",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private Set<Product> products;

    public void setProducts(Product product) {
        if ( products.size() == 0) {
            products = new HashSet<>();
        }
        products.add(product);
    }
}

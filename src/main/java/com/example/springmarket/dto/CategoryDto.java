package com.example.springmarket.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Set;

//FIXME use DTO
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDto {
    private Integer id;
    private String categoryName;
    private Set<ProductDto> productSet;

}

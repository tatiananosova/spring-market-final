package com.example.springmarket.dto;

import lombok.Data;

//FIXME use DTO
@Data
public class ProductDto {

    private Integer id;
    private String name;
    private Integer quantity;
    private Float price;
    private CategoryDto category;
}

package com.example.tiendavirtual.dtos;

import lombok.Data;

@Data 
public class ProductResponseDto {
    private String name;
    private String description;
    private Double price;
    private Integer stock;
}

package com.example.tiendavirtual.models;

import java.util.UUID;

import lombok.Data;

@Data 
public class Product {
    private UUID id;
    private String code;
    private String name;
    private String description;
    private Double price;
    private Integer stock;
}

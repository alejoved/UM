package com.example.tiendavirtual.dtos;

import lombok.Data;

@Data 
public class CustomerUpdateDto {
    private String name;
    private String identification;
    private String email;
    private String address;
}

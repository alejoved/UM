package com.example.tiendavirtual.mappers;

import com.example.tiendavirtual.dtos.CustomerResponseDto;
import com.example.tiendavirtual.entities.CustomerEntity;
import com.example.tiendavirtual.models.Customer;

public class CustomerMapper {
    
    public static Customer entityToModel(CustomerEntity customerEntity){
        Customer customer = new Customer();
        customer.setId(customerEntity.getId());
        customer.setName(customerEntity.getName());
        customer.setIdentification(customerEntity.getIdentification());
        customer.setEmail(customerEntity.getEmail());
        customer.setAddress(customerEntity.getAddress());
        return customer;
    }

    public static CustomerResponseDto modelToDto(Customer customer){
        CustomerResponseDto dto = new CustomerResponseDto();
        dto.setName(customer.getName());
        dto.setIdentification(customer.getIdentification());
        dto.setAddress(customer.getAddress());
        return dto;
    }
}

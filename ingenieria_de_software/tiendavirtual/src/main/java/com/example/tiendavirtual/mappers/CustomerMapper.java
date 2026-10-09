package com.example.tiendavirtual.mappers;

import com.example.tiendavirtual.dtos.CustomerCreateDto;
import com.example.tiendavirtual.dtos.CustomerResponseDto;
import com.example.tiendavirtual.entitites.CustomerEntity;
import com.example.tiendavirtual.models.Customer;

public class CustomerMapper {
    
    public static CustomerResponseDto modelToDto(Customer customer){
        CustomerResponseDto dto = new CustomerResponseDto();
        dto.setName(customer.getName());
        dto.setIdentification(customer.getIdentification());
        dto.setAddress(customer.getAddress());
        return dto;
    }

    public static Customer entityToModel(CustomerEntity customerEntity){
        Customer customer = new Customer();
        customer.setId(customerEntity.getId());
        customer.setName(customerEntity.getName());
        customer.setIdentification(customerEntity.getIdentification());
        customer.setEmail(customerEntity.getEmail());
        customer.setAddress(customerEntity.getAddress());
        return customer;
    }

    public static CustomerEntity modelToEntity(Customer customer){
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setId(customer.getId());
        customerEntity.setName(customer.getName());
        customerEntity.setIdentification(customer.getIdentification());
        customerEntity.setEmail(customer.getEmail());
        customerEntity.setAddress(customer.getAddress());
        return customerEntity;
    }

    public static Customer dtoToModel(CustomerCreateDto dto){
        Customer customer = new Customer();
        customer.setName(dto.getName());
        customer.setIdentification(dto.getIdentification());
        customer.setAddress(dto.getAddress());
        customer.setEmail(dto.getEmail());
        return customer;
    }
}

package com.example.tiendavirtual.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.tiendavirtual.dtos.CustomerResponseDto;
import com.example.tiendavirtual.mappers.CustomerMapper;
import com.example.tiendavirtual.models.Customer;
import com.example.tiendavirtual.services.CustomerService;

@RestController 
@RequestMapping("/api/customer")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }

    @GetMapping 
    public ResponseEntity<List<CustomerResponseDto>> getAllCustomers(){
        List<Customer> customers = customerService.getAllCustomers();
        List<CustomerResponseDto> customersResponseDto = customers.stream().map(CustomerMapper::modelToDto).toList();
        return ResponseEntity.ok(customersResponseDto);
    }

}

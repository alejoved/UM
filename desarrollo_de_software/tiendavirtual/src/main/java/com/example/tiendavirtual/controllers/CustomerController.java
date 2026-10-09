package com.example.tiendavirtual.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.tiendavirtual.dtos.CustomerCreateDto;
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
        List<CustomerResponseDto> customerResponseDto = customers.stream().map(CustomerMapper::modelToDto).toList();
        return ResponseEntity.ok(customerResponseDto);
    }

    @GetMapping("/{identification}")
    public ResponseEntity<CustomerResponseDto> getByIdentification(@PathVariable("identification") String identification){
        Customer customer = customerService.getByIdentification(identification);
        CustomerResponseDto customerResponseDto = CustomerMapper.modelToDto(customer);
        return ResponseEntity.ok(customerResponseDto);
    }

    @PostMapping 
    public ResponseEntity<CustomerResponseDto> create(@RequestBody CustomerCreateDto customerCreateDto){
        Customer customer = CustomerMapper.dtoToModel(customerCreateDto);
        Customer customerCreate = customerService.create(customer);
        CustomerResponseDto customerResponseDto = CustomerMapper.modelToDto(customerCreate);
        return ResponseEntity.ok(customerResponseDto);
    }
    
}

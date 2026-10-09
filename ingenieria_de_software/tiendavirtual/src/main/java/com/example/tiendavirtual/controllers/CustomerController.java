package com.example.tiendavirtual.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.example.tiendavirtual.services.interf.ICustomerService;

@RestController 
@RequestMapping("/api/customer")
public class CustomerController {

    @Autowired 
    private ICustomerService customerService;

    @GetMapping
    public ResponseEntity<List<CustomerResponseDto>> getAll(){
        List<Customer> customers = customerService.getAll();
        List<CustomerResponseDto> customersDto = customers.stream().map(CustomerMapper::modelToDto).toList();
        return ResponseEntity.ok(customersDto);
    }

    @GetMapping("/{identification}")
    public ResponseEntity<CustomerResponseDto> getByIdentification(@PathVariable("identification") String identification){
        Customer customer = customerService.getByIdentification(identification);
        CustomerResponseDto customerDto = CustomerMapper.modelToDto(customer);
        return ResponseEntity.ok(customerDto);
    }

    @PostMapping
    public ResponseEntity<CustomerResponseDto> create(@RequestBody CustomerCreateDto customerCreateDto){
        Customer customer = CustomerMapper.dtoToModel(customerCreateDto);
        Customer customerCreate = customerService.create(customer);
        CustomerResponseDto customerDto = CustomerMapper.modelToDto(customerCreate);
        return ResponseEntity.ok(customerDto);
    }
    
}

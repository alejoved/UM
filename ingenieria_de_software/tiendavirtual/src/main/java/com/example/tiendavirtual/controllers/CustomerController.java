package com.example.tiendavirtual.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.tiendavirtual.services.interf.ICustomerService;

@RestController 
@RequestMapping("/api/customer")
public class CustomerController {

    @Autowired 
    private ICustomerService customerService;

    @GetMapping
    public ResponseEntity<String> getAll(){
        System.out.println("Estoy aca en el controlador de customer");
        customerService.getAll();
        return ResponseEntity.ok("customer");
    }
    
}

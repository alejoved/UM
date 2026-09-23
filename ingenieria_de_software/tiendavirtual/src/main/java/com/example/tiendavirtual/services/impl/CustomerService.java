package com.example.tiendavirtual.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tiendavirtual.models.Customer;
import com.example.tiendavirtual.repositories.interf.ICustomerRepository;
import com.example.tiendavirtual.services.interf.ICustomerService;

@Service 
public class CustomerService implements ICustomerService {

    @Autowired 
    ICustomerRepository customerRepository;

    @Override
    public List<Customer> getAll() {
        System.out.println("Estoy aca en el servicio de customer");
        customerRepository.getAll();
        return null;
    }
    
}

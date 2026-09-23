package com.example.tiendavirtual.repositories.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.tiendavirtual.models.Customer;
import com.example.tiendavirtual.repositories.interf.ICustomerRepository;

@Repository 
public class CustomerRepository implements ICustomerRepository{

    @Override
    public List<Customer> getAll() {
       System.out.println("Estoy en el repositorio de customer");
       return null;
    }
    
}

package com.example.tiendavirtual.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.tiendavirtual.entities.CustomerEntity;
import com.example.tiendavirtual.mappers.CustomerMapper;
import com.example.tiendavirtual.models.Customer;
import com.example.tiendavirtual.repositories.CustomerRepository;

@Service 
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    public List<Customer> getAllCustomers(){
        List<CustomerEntity> customersEntity = customerRepository.getAllCustomers();
        List<Customer> customers = customersEntity.stream().map(CustomerMapper::entityToModel).toList();
        return customers;
    }

    public Customer getByIdentification(String identification){
        CustomerEntity customerEntity = customerRepository.getByIdentification(identification);
        Customer customer = CustomerMapper.entityToModel(customerEntity);
        return customer;
    }
    
}

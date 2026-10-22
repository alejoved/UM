package com.example.tiendavirtual.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.example.tiendavirtual.entities.CustomerEntity;

@Repository 
@Primary 
public class CustomerRepository {
    
    @Autowired
    public CustomerJpaRepository repository;

    public List<CustomerEntity> getAllCustomers(){
        List<CustomerEntity> customersEntity = repository.findAll();
        return customersEntity;
    }

    public CustomerEntity getByIdentification(String identification){
        CustomerEntity customerEntity = repository.findByIdentification(identification);
        return customerEntity;
    }
}

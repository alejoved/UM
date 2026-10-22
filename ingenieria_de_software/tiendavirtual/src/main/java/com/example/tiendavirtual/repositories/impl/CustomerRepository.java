package com.example.tiendavirtual.repositories.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.example.tiendavirtual.entitites.CustomerEntity;
import com.example.tiendavirtual.repositories.interf.ICustomerJpaRepository;
import com.example.tiendavirtual.repositories.interf.ICustomerRepository;

@Repository
@Primary 
public class CustomerRepository implements ICustomerRepository{

    @Autowired
    private ICustomerJpaRepository repository;

    @Override
    public List<CustomerEntity> getAll() {
        List<CustomerEntity> customerEntities = repository.findAll();
        return customerEntities;
    }

    @Override
    public CustomerEntity getByIdentification(String identification) {
        Optional<CustomerEntity> customerEntity = repository.getByIdentification(identification);
        return customerEntity.get();
    }

    @Override 
    public CustomerEntity create(CustomerEntity customerEntity){
        CustomerEntity customerCreate = repository.save(customerEntity);
        return customerCreate;
    }
    
}

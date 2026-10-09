package com.example.tiendavirtual.repositories.interf;

import java.util.List;

import com.example.tiendavirtual.entitites.CustomerEntity;

public interface ICustomerRepository {
    public List<CustomerEntity> getAll();
    public CustomerEntity getByIdentification(String identification);
    public CustomerEntity create(CustomerEntity customerEntity);
}

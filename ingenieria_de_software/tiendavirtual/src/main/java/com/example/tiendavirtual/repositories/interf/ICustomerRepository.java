package com.example.tiendavirtual.repositories.interf;

import java.util.List;
import java.util.UUID;

import com.example.tiendavirtual.entitites.CustomerEntity;

public interface ICustomerRepository {
    public List<CustomerEntity> getAll();
    public CustomerEntity getByIdentification(String identification);
    public CustomerEntity create(CustomerEntity customerEntity);
    public CustomerEntity getById(UUID id);
    public CustomerEntity update(CustomerEntity customerEntity);
    public void delete(CustomerEntity customerEntity);
}

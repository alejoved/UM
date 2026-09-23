package com.example.tiendavirtual.repositories.interf;

import java.util.List;

import com.example.tiendavirtual.models.Customer;

public interface ICustomerRepository {
    public List<Customer> getAll();
}

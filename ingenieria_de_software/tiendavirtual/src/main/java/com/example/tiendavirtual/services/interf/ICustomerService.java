package com.example.tiendavirtual.services.interf;

import java.util.List;

import com.example.tiendavirtual.models.Customer;

public interface ICustomerService {
    public List<Customer> getAll();
    public Customer getByIdentification(String identification);
    public Customer create(Customer customer);
}

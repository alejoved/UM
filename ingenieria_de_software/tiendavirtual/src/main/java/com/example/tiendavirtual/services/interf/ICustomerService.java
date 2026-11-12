package com.example.tiendavirtual.services.interf;

import java.util.List;
import java.util.UUID;

import com.example.tiendavirtual.models.Customer;

public interface ICustomerService {
    public List<Customer> getAll();
    public Customer getByIdentification(String identification);
    public Customer getById(UUID id);
    public Customer create(Customer customer);
    public Customer update(UUID id, Customer customer);
    public void delete(UUID id);
}

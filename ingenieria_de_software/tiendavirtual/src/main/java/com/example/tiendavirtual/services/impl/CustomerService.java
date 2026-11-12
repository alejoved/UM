package com.example.tiendavirtual.services.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tiendavirtual.entitites.CustomerEntity;
import com.example.tiendavirtual.mappers.CustomerMapper;
import com.example.tiendavirtual.models.Customer;
import com.example.tiendavirtual.repositories.interf.ICustomerRepository;
import com.example.tiendavirtual.services.interf.ICustomerService;

@Service 
public class CustomerService implements ICustomerService {

    @Autowired 
    ICustomerRepository customerRepository;

    @Override
    public List<Customer> getAll() {
        List<CustomerEntity> customersEntity = customerRepository.getAll();
        List<Customer> customers = customersEntity.stream().map(CustomerMapper::entityToModel).toList();
        return customers;
    }
    
    @Override
    public Customer getByIdentification(String identification) {
        CustomerEntity customerEntity = customerRepository.getByIdentification(identification);
        Customer customer = CustomerMapper.entityToModel(customerEntity);
        return customer;
    }

    @Override
    public Customer getById(UUID id) {
        CustomerEntity customerEntity = customerRepository.getById(id);
        Customer customer = CustomerMapper.entityToModel(customerEntity);
        return customer;
    }

    @Override 
    public Customer create(Customer customer){
        CustomerEntity customerEntity = CustomerMapper.modelToEntity(customer);
        CustomerEntity createCustomerEntity = customerRepository.create(customerEntity);
        Customer createCustomer = CustomerMapper.entityToModel(createCustomerEntity);
        return createCustomer;

    }

    @Override 
    public Customer update(UUID id, Customer customer){
        CustomerEntity customerEntityExist = customerRepository.getById(id);
        Customer customerExist = CustomerMapper.entityToModel(customerEntityExist);
        customerExist.setName(customer.getName());
        customerExist.setIdentification(customer.getIdentification());
        customerExist.setEmail(customer.getEmail());
        customerExist.setAddress(customer.getAddress());
        CustomerEntity customerEntity = CustomerMapper.modelToEntity(customerExist);
        CustomerEntity customerEntityUpdate = customerRepository.update(customerEntity);
        Customer customerUpdate = CustomerMapper.entityToModel(customerEntityUpdate);
        return customerUpdate;
    }

    public void delete(UUID id){
        CustomerEntity customerEntity = customerRepository.getById(id);
        customerRepository.delete(customerEntity);
    }
}

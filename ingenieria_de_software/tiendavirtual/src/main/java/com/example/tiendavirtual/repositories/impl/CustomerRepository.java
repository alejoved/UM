package com.example.tiendavirtual.repositories.impl;

import java.sql.PreparedStatement;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.tiendavirtual.entitites.CustomerEntity;
import com.example.tiendavirtual.repositories.interf.ICustomerRepository;

@Repository
public class CustomerRepository implements ICustomerRepository{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<CustomerEntity> getAll() {
        String sql = "SELECT * FROM customers";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            CustomerEntity customerEntity = new CustomerEntity();
            customerEntity.setId(rs.getObject("id", UUID.class));
            customerEntity.setName(rs.getString("name"));
            customerEntity.setIdentification(rs.getString("identification"));
            customerEntity.setEmail(rs.getString("email"));
            customerEntity.setAddress(rs.getString("address"));
            return customerEntity;
        });
    }

    @Override
    public CustomerEntity getByIdentification(String identification) {
        String sql = "SELECT * FROM customers WHERE identification = ? ";
        List<CustomerEntity> customersEntity = jdbcTemplate.query(sql, (rs, rowNum) -> {
            CustomerEntity customerEntity = new CustomerEntity();
            customerEntity.setId(rs.getObject("id", UUID.class));
            customerEntity.setName(rs.getString("name"));
            customerEntity.setIdentification(rs.getString("identification"));
            customerEntity.setEmail(rs.getString("email"));
            customerEntity.setAddress(rs.getString("address"));
            return customerEntity;
        }, identification);
        return customersEntity.stream().findFirst().get();
    }

    @Override 
    public CustomerEntity create(CustomerEntity customerEntity){
        String sql = "INSERT INTO customers (id, name, identification, email, address) values (?, ?, ?, ?, ?)";
        
        UUID generatedId = UUID.randomUUID();
        customerEntity.setId(generatedId);
        
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setObject(1, generatedId);
            ps.setString(2, customerEntity.getName());
            ps.setString(3, customerEntity.getIdentification());
            ps.setString(4, customerEntity.getEmail());
            ps.setString(5, customerEntity.getAddress());
            return ps;
        });
        return customerEntity;
    }
    
}

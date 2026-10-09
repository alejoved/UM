package com.example.tiendavirtual.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.tiendavirtual.entities.CustomerEntity;

@Repository 
public class CustomerRepository {
    
    private final JdbcTemplate jdbc;

    public CustomerRepository(JdbcTemplate jdbc){
        this.jdbc = jdbc;
    }

    public List<CustomerEntity> getAllCustomers(){
        String sql = "SELECT * FROM customers";
        return jdbc.query(sql, (rs, rowNum) -> {
            CustomerEntity customerEntity = new CustomerEntity();
            customerEntity.setId(rs.getObject("id", UUID.class));
            customerEntity.setName(rs.getString("name"));
            customerEntity.setIdentification(rs.getString("identification"));
            customerEntity.setEmail(rs.getString("email"));
            customerEntity.setAddress(rs.getString("address"));
            return customerEntity;
        });
    }
}

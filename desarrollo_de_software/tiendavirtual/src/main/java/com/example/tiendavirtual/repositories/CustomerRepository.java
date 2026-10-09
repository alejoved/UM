package com.example.tiendavirtual.repositories;

import java.sql.PreparedStatement;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;
import com.example.tiendavirtual.entities.CustomerEntity;

@Repository 
public class CustomerRepository {

    private final JdbcTemplate jdbcTemplate;

    public CustomerRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
    public List<CustomerEntity> getAllCustomerEntity(){
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

    public CustomerEntity getByIdentification(String identification){
        String sql = "SELECT * FROM customers WHERE identification = ?";
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

    public CustomerEntity create(CustomerEntity customerEntity){
        String sql = "INSERT INTO customers (id, name, identification, email, address) values (?, ?, ?, ?, ?)";
        UUID genratedId = UUID.randomUUID();
        customerEntity.setId(genratedId);

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setObject(1, customerEntity.getId());
            ps.setString(2, customerEntity.getName());
            ps.setString(3, customerEntity.getIdentification());
            ps.setString(4, customerEntity.getEmail());
            ps.setString(5, customerEntity.getAddress());
            return ps;
        });
        return customerEntity;
    }
}

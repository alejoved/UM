package com.example.tiendavirtual.repositories.interf;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.tiendavirtual.entitites.CustomerEntity;

@Repository 
public interface ICustomerJpaRepository extends JpaRepository<CustomerEntity, UUID> {
    
    @Query(value = "select c from CustomerEntity c where c.identification = :identification")
    Optional<CustomerEntity> getByIdentification(String identification);
    
}

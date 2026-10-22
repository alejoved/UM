package com.example.tiendavirtual.repositories.interf;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.tiendavirtual.entitites.ProductEntity;

@Repository 
public interface IProductJpaRepository extends JpaRepository<ProductEntity, UUID> {

    public Optional<ProductEntity> findByCode(String code);
    
}

package com.example.tiendavirtual.repositories.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.example.tiendavirtual.entitites.ProductEntity;
import com.example.tiendavirtual.repositories.interf.IProductJpaRepository;
import com.example.tiendavirtual.repositories.interf.IProductRepository;

@Repository
@Primary 
public class ProductRepository implements IProductRepository {

    @Autowired
    private IProductJpaRepository repository;

    @Override
    public List<ProductEntity> getAll() {
        List<ProductEntity> productEntities = repository.findAll();
        return productEntities;
        
    }

    @Override
    public ProductEntity getByCode(String code) {
        Optional<ProductEntity> productEntity = repository.findByCode(code);
        return productEntity.get();
    }

    @Override
    public ProductEntity create(ProductEntity productEntity) {
        ProductEntity productCreate = repository.save(productEntity);
        return productCreate;
    }
    
}

package com.example.tiendavirtual.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;

import com.example.tiendavirtual.entities.ProductEntity;

@Repository
@Primary  
public class ProductRepository {

    @Autowired 
    private IProductJpaRepository repository;
    
    public List<ProductEntity> getAllProductEntity(){
       List<ProductEntity> productsEntity = repository.findAll();
       return productsEntity;
    }

    public ProductEntity getByCode(String code){
        ProductEntity productEntity = repository.findByCode(code);
        return productEntity;
    }

    public ProductEntity getById(UUID id){
        ProductEntity productEntity = repository.findById(id).get();
        return productEntity;
    }
}

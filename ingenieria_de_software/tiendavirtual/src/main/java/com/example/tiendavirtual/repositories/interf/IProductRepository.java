package com.example.tiendavirtual.repositories.interf;

import java.util.List;

import com.example.tiendavirtual.entitites.ProductEntity;

public interface IProductRepository {
    public List<ProductEntity> getAll();
    public ProductEntity getByCode(String code);
    public ProductEntity create(ProductEntity productEntity);
}

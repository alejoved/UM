package com.example.tiendavirtual.repositories.interf;

import java.util.List;
import java.util.UUID;

import com.example.tiendavirtual.entitites.ProductEntity;

public interface IProductRepository {
    public List<ProductEntity> getAll();
    public ProductEntity getByCode(String code);
    public ProductEntity getById(UUID id);
    public ProductEntity create(ProductEntity productEntity);
}

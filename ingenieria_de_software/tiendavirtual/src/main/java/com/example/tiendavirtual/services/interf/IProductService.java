package com.example.tiendavirtual.services.interf;

import java.util.List;
import java.util.UUID;

import com.example.tiendavirtual.models.Product;

public interface IProductService {
    public List<Product> getAll();
    public Product getByCode(String code);
    public Product getById(UUID id);
    public Product create(Product product);
}

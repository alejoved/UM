package com.example.tiendavirtual.services.interf;

import java.util.List;

import com.example.tiendavirtual.models.Product;

public interface IProductService {
    public List<Product> getAll();
    public Product getByCode(String identification);
    public Product create(Product product);
}

package com.example.tiendavirtual.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tiendavirtual.entitites.ProductEntity;
import com.example.tiendavirtual.mappers.ProductMapper;
import com.example.tiendavirtual.models.Product;
import com.example.tiendavirtual.repositories.interf.IProductRepository;
import com.example.tiendavirtual.services.interf.IProductService;

@Service 
public class ProductService implements IProductService {

    @Autowired 
    private IProductRepository productRepository;

    @Override
    public List<Product> getAll() {
        List<ProductEntity> productsEntity = productRepository.getAll();
        List<Product> products = productsEntity.stream().map(ProductMapper::entityToModel).toList();
        return products;
    }

    @Override
    public Product getByCode(String code) {
        ProductEntity productEntity = productRepository.getByCode(code);
        Product product = ProductMapper.entityToModel(productEntity);
        return product;
    }

    @Override
    public Product create(Product product) {
        ProductEntity productEntity = ProductMapper.modelToEntity(product);
        ProductEntity createProductEntity = productRepository.create(productEntity);
        Product createProduct = ProductMapper.entityToModel(createProductEntity);
        return createProduct;
        
    }
    
}

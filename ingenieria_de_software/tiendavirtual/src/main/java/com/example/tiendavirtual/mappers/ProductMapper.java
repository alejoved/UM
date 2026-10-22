package com.example.tiendavirtual.mappers;

import com.example.tiendavirtual.dtos.ProductCreateDto;
import com.example.tiendavirtual.dtos.ProductResponseDto;
import com.example.tiendavirtual.entitites.ProductEntity;
import com.example.tiendavirtual.models.Product;

public class ProductMapper {
    
    public static Product entityToModel(ProductEntity productEntity){
        Product product = new Product();
        product.setId(productEntity.getId());
        product.setCode(productEntity.getCode());
        product.setName(productEntity.getName());
        product.setDescription(productEntity.getDescription());
        product.setPrice(productEntity.getPrice());
        product.setStock(productEntity.getStock());
        return product;
    }

    public static ProductEntity modelToEntity(Product product){
        ProductEntity productEntity = new ProductEntity();
        productEntity.setId(product.getId());
        productEntity.setCode(product.getCode());
        productEntity.setName(product.getName());
        productEntity.setDescription(product.getDescription());
        productEntity.setPrice(product.getPrice());
        productEntity.setStock(product.getStock());
        return productEntity;
    }

    public static ProductResponseDto modelToDto(Product product){
        ProductResponseDto dto = new ProductResponseDto();
        dto.setName(product.getName());
        dto.setDescription(product.getDescription());
        dto.setPrice(product.getPrice());
        dto.setStock(product.getStock());
        return dto;
    }

    public static Product dtoToModel(ProductCreateDto dto){
        Product product = new Product();
        product.setCode(dto.getCode());
        product.setName(dto.getName());
        product.setDescription(dto.getDescription());
        product.setPrice(dto.getPrice());
        product.setStock(dto.getStock());
        return product;
    }
}

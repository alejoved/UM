package com.example.tiendavirtual.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.tiendavirtual.dtos.ProductCreateDto;
import com.example.tiendavirtual.dtos.ProductResponseDto;
import com.example.tiendavirtual.mappers.ProductMapper;
import com.example.tiendavirtual.models.Product;
import com.example.tiendavirtual.services.interf.IProductService;

@RestController 
@RequestMapping("/api/product")
public class ProductController {
    
    @Autowired 
    private IProductService productService;
    
    @GetMapping
    public ResponseEntity<List<ProductResponseDto>> getAll(){
        List<Product> products = productService.getAll();
        List<ProductResponseDto> productsDto = products.stream().map(ProductMapper::modelToDto).toList();
        return ResponseEntity.ok(productsDto);
    }

    @GetMapping("/{code}")
    public ResponseEntity<ProductResponseDto> getByCode(@PathVariable("code") String code){
        Product product = productService.getByCode(code);
        ProductResponseDto productDto = ProductMapper.modelToDto(product);
        return ResponseEntity.ok(productDto);
    }

    @PostMapping
    public ResponseEntity<ProductResponseDto> create(@RequestBody ProductCreateDto productCreateDto){
        Product product = ProductMapper.dtoToModel(productCreateDto);
        Product productCreate = productService.create(product);
        ProductResponseDto productDto = ProductMapper.modelToDto(productCreate);
        return ResponseEntity.ok(productDto);
    }
}

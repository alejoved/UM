package com.example.tiendavirtual.entitites;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity 
@Table(name = "products")
@Data 
public class ProductEntity {
    @Id 
    @GeneratedValue 
    private UUID id;
    @Column 
    private String code;
    @Column 
    private String name;
    @Column 
    private String description;
    @Column 
    private Double price;
    @Column 
    private Integer stock;

    @ManyToMany(mappedBy = "products")
    private List<InvoiceEntity> invoices = new ArrayList<>();
}

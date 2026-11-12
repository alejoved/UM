package com.example.tiendavirtual.entities;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "invoices")
@Data   
public class InvoiceEntity {

    @Id 
    @GeneratedValue 
    private UUID id;

    @Column 
    private String number;

    @Column 
    private LocalDate date;

    @Column 
    private Double total;

    //Customer
    @ManyToOne
    @JoinColumn(name="customer_id")
    private CustomerEntity customer;

    //Productos
    @ManyToMany
    @JoinTable(
        name= "invoice_product",
        joinColumns = @JoinColumn(name = "invoice_id"),
        inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<ProductEntity> products;
    
}

package com.example.tiendavirtual.entitites;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity 
@Table(name = "customers")
@Data 
public class CustomerEntity {
    
   @Id 
   @GeneratedValue 
   private UUID id;

   @Column 
   private String name;

   @Column 
   private String identification;

   @Column 
   private String email;

   @Column 
   private String address;

   @OneToMany(mappedBy = "customer")
   private List<InvoiceEntity> invoices = new ArrayList<>();
}

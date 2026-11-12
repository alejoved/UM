package com.example.tiendavirtual.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.tiendavirtual.entities.InvoiceEntity;

@Repository 
public interface IInvoiceJpaRepository extends JpaRepository<InvoiceEntity, UUID> {
    
}

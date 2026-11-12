package com.example.tiendavirtual.repositories.interf;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

import com.example.tiendavirtual.entitites.InvoiceEntity;

@Repository 
public interface IInvoiceJpaRepository extends JpaRepository<InvoiceEntity, UUID> {
    
}

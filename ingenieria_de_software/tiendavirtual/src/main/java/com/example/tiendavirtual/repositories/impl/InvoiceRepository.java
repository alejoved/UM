package com.example.tiendavirtual.repositories.impl;

import com.example.tiendavirtual.repositories.interf.IInvoiceJpaRepository;
import com.example.tiendavirtual.repositories.interf.IInvoiceRepository;
import com.example.tiendavirtual.entitites.InvoiceEntity;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository
@Primary 
public class InvoiceRepository implements IInvoiceRepository {
    
    @Autowired 
    private IInvoiceJpaRepository invoiceJpaRepository;

    @Override
    public List<InvoiceEntity> getAll() {
        List<InvoiceEntity> invoices = invoiceJpaRepository.findAll();
        return invoices;
    }

    @Override
    public InvoiceEntity create(InvoiceEntity invoiceEntity) {
        InvoiceEntity createdInvoice = invoiceJpaRepository.save(invoiceEntity);
        return createdInvoice;
    }
    
}

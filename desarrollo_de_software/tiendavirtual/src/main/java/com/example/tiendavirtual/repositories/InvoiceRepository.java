package com.example.tiendavirtual.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.example.tiendavirtual.entities.InvoiceEntity;

@Repository 
@Primary 
public class InvoiceRepository {
    
    @Autowired 
    private IInvoiceJpaRepository repository;

    public List<InvoiceEntity> getAll(){
        List<InvoiceEntity> invoicesEntity = repository.findAll();
        return invoicesEntity;
    }

    public InvoiceEntity create(InvoiceEntity invoiceEntity){
        InvoiceEntity invoiceEntityCreate = repository.save(invoiceEntity);
        return invoiceEntityCreate;
    }

}

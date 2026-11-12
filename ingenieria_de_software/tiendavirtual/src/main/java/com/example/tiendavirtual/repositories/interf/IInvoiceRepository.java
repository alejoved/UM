package com.example.tiendavirtual.repositories.interf;

import java.util.List;

import com.example.tiendavirtual.entitites.InvoiceEntity;

public interface IInvoiceRepository {
    public List<InvoiceEntity> getAll();
    public InvoiceEntity create(InvoiceEntity invoiceEntity);
}

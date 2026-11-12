package com.example.tiendavirtual.services.interf;

import com.example.tiendavirtual.models.Invoice;

import java.util.List;

public interface IInvoiceService {
    public List<Invoice> getAll();
    public Invoice create(Invoice invoice);
}

package com.example.tiendavirtual.services.impl;

import com.example.tiendavirtual.services.interf.ICustomerService;
import com.example.tiendavirtual.services.interf.IInvoiceService;
import com.example.tiendavirtual.services.interf.IProductService;
import com.example.tiendavirtual.entitites.CustomerEntity;
import com.example.tiendavirtual.entitites.InvoiceEntity;
import com.example.tiendavirtual.entitites.ProductEntity;
import com.example.tiendavirtual.mappers.CustomerMapper;
import com.example.tiendavirtual.mappers.InvoiceMapper;
import com.example.tiendavirtual.mappers.ProductMapper;
import com.example.tiendavirtual.models.Customer;
import com.example.tiendavirtual.models.Invoice;
import com.example.tiendavirtual.models.Product;
import com.example.tiendavirtual.repositories.interf.IInvoiceRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service 
public class InvoiceService implements IInvoiceService {

    @Autowired 
    private IInvoiceRepository invoiceRepository;

    @Autowired 
    private ICustomerService customerService; 

    @Autowired
    private IProductService productService;

    @Override
    public List<Invoice> getAll() {
        List<InvoiceEntity> invoiceEntities = invoiceRepository.getAll();
        List<Invoice> invoices = invoiceEntities.stream()
                .map(InvoiceMapper::entityToModel)
                .toList();
        return invoices;
    }

    @Override
    public Invoice create(Invoice invoice) {
        Customer customer = customerService.getById(invoice.getCustomerId());
        InvoiceEntity invoiceEntity = new InvoiceEntity();
        invoiceEntity.setNumber(invoice.getNumber());
        invoiceEntity.setDate(invoice.getDate());
        CustomerEntity customerEntity = CustomerMapper.modelToEntity(customer);
        invoiceEntity.setCustomer(customerEntity);
        List<ProductEntity> productsEntity = new ArrayList<>();
        Double total = 0.0;
        for (UUID productId : invoice.getProductIds()) {
            Product product = productService.getById(productId);
            ProductEntity productEntity = ProductMapper.modelToEntity(product);
            productsEntity.add(productEntity);
            total = total + product.getPrice();
        }
        invoiceEntity.setProducts(productsEntity);
        invoiceEntity.setTotal(total);
        InvoiceEntity createdInvoiceEntity = invoiceRepository.create(invoiceEntity);
        Invoice invoiceCreate = InvoiceMapper.entityToModel(createdInvoiceEntity);
        return invoiceCreate;
    }
}

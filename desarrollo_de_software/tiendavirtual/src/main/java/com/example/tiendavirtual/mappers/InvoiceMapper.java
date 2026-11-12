package com.example.tiendavirtual.mappers;

import java.util.List;
import java.util.UUID;

import com.example.tiendavirtual.dtos.InvoiceCreateDto;
import com.example.tiendavirtual.dtos.InvoiceResponseDto;
import com.example.tiendavirtual.entities.InvoiceEntity;
import com.example.tiendavirtual.models.Invoice;

public class InvoiceMapper {
    
    public static Invoice dtoToModel(InvoiceCreateDto invoiceCreateDto){
        Invoice invoice = new Invoice();
        invoice.setNumber(invoiceCreateDto.getNumber());
        invoice.setDate(invoiceCreateDto.getDate());
        invoice.setCustomerId(invoiceCreateDto.getCustomerId());
        invoice.setProductIds(invoiceCreateDto.getProductIds());
        return invoice;
    }

    public static InvoiceEntity modelToEntity(Invoice invoice){
        InvoiceEntity invoiceEntity = new InvoiceEntity();
        invoiceEntity.setId(invoice.getId());
        invoiceEntity.setDate(invoice.getDate());
        invoiceEntity.setTotal(invoice.getTotal());
        return invoiceEntity;
    }

    public static Invoice entityToModel(InvoiceEntity invoiceEntity){
        Invoice invoice = new Invoice();
        invoice.setId(invoiceEntity.getId());
        invoice.setNumber(invoiceEntity.getNumber());
        invoice.setDate(invoiceEntity.getDate());
        invoice.setTotal(invoiceEntity.getTotal());
        invoice.setCustomerId(invoiceEntity.getCustomer().getId());
        List<UUID> productIds = invoiceEntity.getProducts().stream().map(product -> product.getId()).toList();
        invoice.setProductIds(productIds);
        return invoice;
    }

    public static InvoiceResponseDto modelToDto(Invoice invoice){
        InvoiceResponseDto invoiceResponseDto = new InvoiceResponseDto();
        invoiceResponseDto.setNumber(invoice.getNumber());
        invoiceResponseDto.setDate(invoice.getDate());
        invoiceResponseDto.setTotal(invoice.getTotal());
        invoiceResponseDto.setCustomerId(invoice.getCustomerId());
        invoiceResponseDto.setProductIds(invoice.getProductIds());
        return invoiceResponseDto;
    }
}

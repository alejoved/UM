package com.example.tiendavirtual.mappers;

import com.example.tiendavirtual.dtos.InvoiceCreateDto;
import com.example.tiendavirtual.dtos.InvoiceResponseDto;
import com.example.tiendavirtual.entitites.InvoiceEntity;
import com.example.tiendavirtual.models.Invoice;
import java.util.List;
import java.util.UUID;

public class InvoiceMapper {
    
    public static Invoice entityToModel(InvoiceEntity entity) {
        Invoice invoice = new Invoice();
        invoice.setId(entity.getId());
        invoice.setNumber(entity.getNumber());
        invoice.setDate(entity.getDate());
        invoice.setTotal(entity.getTotal());
        invoice.setCustomerId(entity.getCustomer().getId());
        
        List<UUID> productIds = entity.getProducts().stream()
                .map(product -> product.getId())
                .toList();
        invoice.setProductIds(productIds);
        return invoice;
    }

    public static InvoiceResponseDto modelToDto(Invoice invoice) {
        InvoiceResponseDto dto = new InvoiceResponseDto();
        dto.setNumber(invoice.getNumber());
        dto.setDate(invoice.getDate());
        dto.setTotal(invoice.getTotal());
        dto.setCustomerId(invoice.getCustomerId());
        dto.setProductIds(invoice.getProductIds());
        return dto;
    }

    public static Invoice createDtoToModel(InvoiceCreateDto dto) {
        Invoice invoice = new Invoice();
        invoice.setNumber(dto.getNumber());
        invoice.setDate(dto.getDate());
        invoice.setCustomerId(dto.getCustomerId());
        invoice.setProductIds(dto.getProductIds());
        return invoice;
    }
}

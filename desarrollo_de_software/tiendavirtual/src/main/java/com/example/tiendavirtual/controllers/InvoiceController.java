package com.example.tiendavirtual.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.tiendavirtual.dtos.InvoiceCreateDto;
import com.example.tiendavirtual.dtos.InvoiceResponseDto;
import com.example.tiendavirtual.mappers.InvoiceMapper;
import com.example.tiendavirtual.models.Invoice;
import com.example.tiendavirtual.services.InvoiceService;

@RestController 
@RequestMapping("/api/invoice") 
public class InvoiceController {

    private final InvoiceService invoiceService;

    public InvoiceController(InvoiceService invoiceService){
        this.invoiceService = invoiceService;
    }

    @GetMapping 
    public ResponseEntity<List<InvoiceResponseDto>> getAllInvoices(){
        List<Invoice> invoices = invoiceService.getAllInvoices();
        List<InvoiceResponseDto> invoiceResponseDto = invoices.stream().map(InvoiceMapper::modelToDto).toList();
        return ResponseEntity.ok(invoiceResponseDto);
    }
    
    @PostMapping 
    public ResponseEntity<InvoiceResponseDto> create(@RequestBody InvoiceCreateDto invoiceCreateDto){
        Invoice invoice = InvoiceMapper.dtoToModel(invoiceCreateDto);
        Invoice invoiceCreate = invoiceService.create(invoice);
        InvoiceResponseDto invoiceResponseDto = InvoiceMapper.modelToDto(invoiceCreate);
        return ResponseEntity.ok(invoiceResponseDto);
    }
}

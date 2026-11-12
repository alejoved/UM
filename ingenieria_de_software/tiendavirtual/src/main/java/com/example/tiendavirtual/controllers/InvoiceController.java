package com.example.tiendavirtual.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import java.util.List;
import com.example.tiendavirtual.models.Invoice;
import com.example.tiendavirtual.mappers.InvoiceMapper;
import com.example.tiendavirtual.dtos.InvoiceCreateDto;
import com.example.tiendavirtual.dtos.InvoiceResponseDto;

import com.example.tiendavirtual.services.interf.IInvoiceService;

@RestController
@RequestMapping("/api/invoice")
public class InvoiceController {
    @Autowired 
    private IInvoiceService invoiceService;

    @GetMapping 
    public ResponseEntity<List<InvoiceResponseDto>> getAllInvoices() {
        List<Invoice> invoices = invoiceService.getAll();
        List<InvoiceResponseDto> invoiceResponses = invoices.stream()
                .map(InvoiceMapper::modelToDto)
                .toList();
        return ResponseEntity.ok(invoiceResponses);
    }

    @PostMapping
    public ResponseEntity<InvoiceResponseDto> createInvoice(@RequestBody InvoiceCreateDto invoiceCreateDto) {
        Invoice invoice = InvoiceMapper.createDtoToModel(invoiceCreateDto);
        Invoice createdInvoice = invoiceService.create(invoice);
        InvoiceResponseDto invoiceResponseDto = InvoiceMapper.modelToDto(createdInvoice);
        return ResponseEntity.ok(invoiceResponseDto);
    }
}

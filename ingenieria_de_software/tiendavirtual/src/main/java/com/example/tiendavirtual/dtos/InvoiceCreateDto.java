package com.example.tiendavirtual.dtos;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Data 
public class InvoiceCreateDto {
    private String number;
    private LocalDate date;
    private UUID customerId;
    private List<UUID> productIds;
}

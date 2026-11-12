package com.example.tiendavirtual.dtos;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import lombok.Data;

@Data 
public class InvoiceCreateDto {
    private LocalDate date;
    private String number;
    private UUID customerId;
    private List<UUID> productIds;
}

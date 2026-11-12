package com.example.tiendavirtual.models;

import java.time.LocalDate;
import java.util.UUID;
import java.util.List;

import lombok.Data;

@Data 
public class Invoice {
    private UUID id;
    private String number;
    private LocalDate date;
    private Double total;
    private UUID customerId;
    private List<UUID> productIds;
}

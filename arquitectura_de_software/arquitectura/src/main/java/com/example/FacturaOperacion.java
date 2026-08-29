package com.example;

public class FacturaOperacion {
    
    public void calcularTotal(Factura factura) {
        double total = factura.getSubtotal() + (factura.getSubtotal() * factura.getImpuesto() / 100);
        System.out.println("El total de la factura es: " + total);
    }

    public void calcularImpuesto(Factura factura) {
        double impuesto = factura.getSubtotal() * factura.getImpuesto() / 100;
        System.out.println("El impuesto de la factura es: " + impuesto);
    }
}

package com.example;

public class Main {
    public static void main(String[] args) {
        Factura factura = new Factura("Empresa XYZ", "123456789", "Calle Falsa 123", 19, 200000);
        FacturaOperacion operacion = new FacturaOperacion();
        operacion.calcularTotal(factura);

        operacion.calcularImpuesto(factura);
    }
}
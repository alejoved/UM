package com.example;

public class PagoTarjeta implements MedioPago {

    @Override
    public void pagar(double valor) {
        System.out.println("Estoy pagando con TARJETAS el valor de: " + valor);
    }
    
}

package com.example;

public class PagoNequi implements MedioPago {

    @Override
    public void pagar(double valor) {
        System.out.println("Estoy pagando con NEQUI el valor de: " + valor);
    }
    
}

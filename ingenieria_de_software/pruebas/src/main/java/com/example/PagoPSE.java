package com.example;

public class PagoPSE implements MedioPago {

    @Override
    public void pagar(double valor) {
        System.out.println("Estoy pagando con PSE el valor de: " + valor);
    }
    
}

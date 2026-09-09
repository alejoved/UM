package com.example;

public class Ejecucion {
    public void procesarPago(MedioPago medioPago, double valor) {
        medioPago.pagar(valor);
    }
}

package com.example.o;

public class Ejecucion {
    public void procesarCobro(MedioPago medioPago, double monto){
        medioPago.cobrar(monto);
    }
}

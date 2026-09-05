package com.example.o;

public class PagoTarjeta implements MedioPago{

    @Override
    public void cobrar(double monto) {
        System.out.println("Procesando pago con tarjeta del monto: " + monto);
    }
    
}

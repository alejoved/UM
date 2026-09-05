package com.example.o;

public class PagoBilleteraDigital implements MedioPago {

    @Override
    public void cobrar(double monto) {
        System.out.println("Procesando pago con billetera digital del monto: " + monto);
    }
    
}

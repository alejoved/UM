package com.example;

public class CuentaCorriente extends Cuenta {

    public CuentaCorriente(String propietario, double saldo) {
        super(propietario, saldo);
    }

    @Override 
    public void retirar(double valor){
        double impuesto = 10000;
        setSaldo(getSaldo() - valor - impuesto);
    }
    
}

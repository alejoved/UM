package com.example.l;

public abstract class Cuenta {
    double saldo;

    public Cuenta(double saldo){
        this.saldo = saldo;
    }

    public double consultarSaldo(){
        return saldo;
    }

    public double retirarSaldo(double retiro){
        return saldo - retiro;
    }
}

package com.example;

public abstract class Cuenta {
    private String propietario;
    private double saldo;

    public Cuenta (String propietario, double saldo){
        this.propietario = propietario;
        this.saldo = saldo;
    }
    public void consignar(double valor){
        saldo = saldo + valor;
    }

    public void retirar(double valor){
        saldo = saldo - valor;
    }

    public String getPropietario() {
        return propietario;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}

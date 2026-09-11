package com.example;

public class Cuenta implements CuentaOperacion {
    private String identificador;
    private double saldo;

    public String getIdentificador() {
        return identificador;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public void retirar(double valor) {
        saldo = saldo - valor;
    }

    @Override
    public void consignar(double valor) {
        saldo = saldo + valor;
    }
}

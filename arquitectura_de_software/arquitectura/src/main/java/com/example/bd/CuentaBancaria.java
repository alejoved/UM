package com.example.bd;

public class CuentaBancaria implements CuentaOperacion {
    private String identificador;
    private double saldo;

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getIdentificador() {
        return identificador;
    }

    public double getSaldo() {
        return saldo;
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

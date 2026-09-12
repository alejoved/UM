package com.example;

import com.example.i.ClienteEmail;
import com.example.l.Cuenta;
import com.example.l.CuentaAhorros;
import com.example.o.Ejecucion;
import com.example.o.PagoPSE;
import com.example.o.PagoTarjeta;

import java.util.Scanner;

import com.example.bd.CuentaBancaria;
import com.example.i.*;

public class Main {
    public static void main(String[] args) {
        //Factura factura = new Factura("Empresa XYZ", "123456789", "Calle Falsa 123", 19, 200000);
        //FacturaOperacion operacion = new FacturaOperacion();
        //operacion.calcularTotal(factura);

        //operacion.calcularImpuesto(factura);

        //Ejecucion ejecucion = new Ejecucion();
        //ejecucion.procesarCobro(new PagoPSE(), 120000);

        //ejecucion.procesarCobro(new PagoTarjeta(), 98000);

        //Cuenta cuenta = new CuentaAhorros(10000000);
        //double restante = cuenta.retirarSaldo(4500000);
        //System.out.println("Me quedo en la cuenta de ahorros: "+restante);

        //NotificadorEmail notificadorEmail = new ClienteEmail();
        //notificadorEmail.enviarEmail("alejoved@gmail", "cualquier mensaje");

        Scanner scanner = new Scanner(System.in);
        CuentaBancaria cuentaBancaria = new CuentaBancaria();
        System.out.println("Por favor ingrese el identificador de la cuenta");
        String identificador = scanner.nextLine();
        System.out.println("Por favor ingrese el saldo de la cuenta");
        double saldo = scanner.nextDouble();
        cuentaBancaria.setIdentificador(identificador);
        cuentaBancaria.setSaldo(saldo);

        int opcion = 0;
        while (opcion != 3){
            System.out.println("Menu: 1. Retirar 2. Consignar 3. Salir");
            opcion = scanner.nextInt();
            if(opcion == 1){
                System.out.println("Por favor ingrese el monto a retirar");
                double valor = scanner.nextDouble();
                cuentaBancaria.retirar(valor);
            }
            if(opcion ==2){
                System.out.println("Por favor ingrese el monto a consignar");
                double valor = scanner.nextDouble();
                cuentaBancaria.consignar(valor);
            }
            System.out.println("El saldo de tu cuenta es de: "+cuentaBancaria.getSaldo());
        }
    }
}
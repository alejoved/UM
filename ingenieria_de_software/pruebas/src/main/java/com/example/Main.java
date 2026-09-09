package com.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Calculadora calculadora = new Calculadora();
        
        //double resultadoSuma = calculadora.suma(5, 3);
        //System.out.println("Resultado de la suma: " + resultadoSuma);

        //double resultadoResta = calculadora.resta(5, 3);
        //System.out.println("Resultado de la resta: " + resultadoResta);

        //double resultadoMultiplicacion = calculadora.multiplicacion(5, 3);
        //System.out.println("Resultado de la multiplicación: " + resultadoMultiplicacion);

        //double resultadoDivision = calculadora.division(10, 2);
        //System.out.println("Resultado de la división: " + resultadoDivision);

        //MAIN DEL PRINCIPIO S
        //System.out.println("Ingrese los datos del cliente");
        //Scanner scanner = new Scanner(System.in);
        //System.out.println("Ingrese el nombre");
        //String nombre = scanner.nextLine();
        //System.out.println("Ingrese el telefono");
        //String telefono = scanner.nextLine();
        //System.out.println("Ingrese el correo");
        //String correo = scanner.nextLine();

        //Cliente cliente = new Cliente(nombre, telefono, correo);

        //System.out.println("El correo del cliente es: " + cliente.getCorreo());

        //MAIN DEL PRINCIPIO O
        //Ejecucion ejecucion = new Ejecucion();
        //ejecucion.procesarPago(new PagoPSE(), 200000);
        //ejecucion.procesarPago(new PagoNequi(), 450000);

        //MAIN DEL PRINCIPIO L
        Cuenta cuenta1 = new CuentaAhorros("SERGIO", 500000);
        cuenta1.retirar(150000);
        System.out.println("EL saldo de SERGIO es de : "+ cuenta1.getSaldo());

        Cuenta cuenta2 = new CuentaCorriente("ALEJANDRO", 280000);
        cuenta2.retirar(50000);
        System.out.println("EL saldo de ALEJANDRO es de : "+ cuenta2.getSaldo());
    }
}
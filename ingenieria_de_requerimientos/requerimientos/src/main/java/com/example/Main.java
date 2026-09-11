package com.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Calculadora calculadora = new Calculadora();

        //double suma = calculadora.suma(10, 15);
        //System.out.println("La suma es de: " + suma);

        //double resta = calculadora.resta(22, 12);
        //System.out.println("La resta es de: " + resta);
        //System.out.println("Vamos a sumar");
        //Scanner scanner = new Scanner(System.in);
        //double a = scanner.nextDouble();
        //double b = scanner.nextDouble();
        //double resultadoSuma = calculadora.suma(a,b);
        //System.out.println("El resultado de la suma es: " + resultadoSuma);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Por favor ingresa el identificador de la cuenta");
        String identificador= scanner.nextLine();
        System.out.println("Por favor ingrese el saldo de la cuenta");
        double saldo = scanner.nextDouble();
        Cuenta cuenta = new Cuenta();
        cuenta.setIdentificador(identificador);
        cuenta.setSaldo(saldo);

        int opcion = 0;
        while(opcion != 3){
            System.out.println("Menu: 1. Retirar. 2. Consignar 3. Salir");
            opcion = scanner.nextInt();
            if(opcion==1){
                System.out.println("Cuanto quieres retirar");
                double retirar = scanner.nextDouble();
                cuenta.retirar(retirar);
            }
            if(opcion==2){
                System.out.println("Cuanto quieres consignar");
                double consignar = scanner.nextDouble();
                cuenta.consignar(consignar);
            }
            System.out.println("Tienes en tu cuenta: "+cuenta.getSaldo());
        }
        

    }
}
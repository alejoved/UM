package com.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Calculadora calculadora = new Calculadora();

        //double suma = calculadora.suma(10, 15);
        //System.out.println("La suma es de: " + suma);

        //double resta = calculadora.resta(22, 12);
        //System.out.println("La resta es de: " + resta);
        System.out.println("Vamos a sumar");
        Scanner scanner = new Scanner(System.in);
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double resultadoSuma = calculadora.suma(a,b);
        System.out.println("El resultado de la suma es: " + resultadoSuma);

    }
}
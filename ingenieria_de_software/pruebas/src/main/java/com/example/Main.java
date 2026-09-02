package com.example;

public class Main {
    public static void main(String[] args) {
        Calculadora calculadora = new Calculadora();
        
        double resultadoSuma = calculadora.suma(5, 3);
        System.out.println("Resultado de la suma: " + resultadoSuma);

        double resultadoResta = calculadora.resta(5, 3);
        System.out.println("Resultado de la resta: " + resultadoResta);

        double resultadoMultiplicacion = calculadora.multiplicacion(5, 3);
        System.out.println("Resultado de la multiplicación: " + resultadoMultiplicacion);

        double resultadoDivision = calculadora.division(10, 2);
        System.out.println("Resultado de la división: " + resultadoDivision);
    }
}
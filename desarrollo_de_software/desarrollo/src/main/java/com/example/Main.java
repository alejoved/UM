package com.example;

public class Main {
    public static void main(String[] args) {
        Usuario usuario = new Usuario("Alejandro Aguirre", "alejo@gmail.com", "3113395600");
        System.out.println(usuario.getNombre());
        System.out.println(usuario.getTelefono());
    }
}
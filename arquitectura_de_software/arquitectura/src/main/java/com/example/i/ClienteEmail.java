package com.example.i;

public class ClienteEmail implements NotificadorEmail {

    @Override
    public void enviarEmail(String correo, String mensaje) {
       System.out.println("Estoy enviando un email");
    }
    
}

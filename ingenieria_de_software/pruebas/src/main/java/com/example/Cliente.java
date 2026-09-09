package com.example;

public class Cliente {
    //Aplicar el principio de Responsabilidad unica
    private String nombre;
    private String telefono;
    private String correo;

    public Cliente(String nombre, String telefono, String correo){
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }
    
    public String getTelefono() {
        return telefono;
    }

    public String getCorreo() {
        return correo;
    }

}

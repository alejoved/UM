package com.example;

public class Factura {
    private String razonSocial;
    private String identificacion;
    private String direccion;
    private int impuesto;
    private double subtotal;

    public Factura(String razonSocial, String identificacion, String direccion, int impuesto, double subtotal) {
        this.razonSocial = razonSocial;
        this.identificacion = identificacion;
        this.direccion = direccion;
        this.impuesto = impuesto;
        this.subtotal = subtotal;
    }

    // getters and setters for the attributes can be added here if needed
    public String getRazonSocial() {
        return razonSocial;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public String getDireccion() {
        return direccion;
    }

    public int getImpuesto() {
        return impuesto;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setImpuesto(int impuesto) {
        this.impuesto = impuesto;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

}
package com.example;

import com.example.l.Cuenta;
import com.example.l.CuentaAhorros;
import com.example.o.Ejecucion;
import com.example.o.PagoPSE;
import com.example.o.PagoTarjeta;

public class Main {
    public static void main(String[] args) {
        //Factura factura = new Factura("Empresa XYZ", "123456789", "Calle Falsa 123", 19, 200000);
        //FacturaOperacion operacion = new FacturaOperacion();
        //operacion.calcularTotal(factura);

        //operacion.calcularImpuesto(factura);

        //Ejecucion ejecucion = new Ejecucion();
        //ejecucion.procesarCobro(new PagoPSE(), 120000);

        //ejecucion.procesarCobro(new PagoTarjeta(), 98000);

        Cuenta cuenta = new CuentaAhorros(10000000);
        double restante = cuenta.retirarSaldo(4500000);
        System.out.println("Me quedo en la cuenta de ahorros: "+restante);
    }
}
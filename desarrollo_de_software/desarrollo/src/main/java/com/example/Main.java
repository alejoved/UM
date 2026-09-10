package com.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        //System.out.println("Ingrese los datos del cliente");
        //System.out.println("Ingrese el nombre");
        //String nombre = scanner.nextLine();
        //System.out.println("Ingrese el correo");
        //String correo = scanner.nextLine();
        //System.out.println("Ingrese el telefono");
        //String telefono = scanner.nextLine();
        //Usuario usuario = new Usuario(nombre, correo, telefono);
        //System.out.println("---------------------------");
        //System.out.println(usuario.getNombre());
        //System.out.println(usuario.getTelefono());

        //CuentaCorriente cuentaCorriente = new CuentaCorriente(200000);
        //cuentaCorriente.consignar(50000);
        //System.out.println("Me quedo en la cuenta: "+ cuentaCorriente.getSaldo());

        String sql = "select * from cuentas";
        try (Connection conn = BaseDatos.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
                try (ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) {
                        String identificador = rs.getString("identificador");
                        double saldo = rs.getDouble("saldo");
                        System.out.println("La cuenta tiene identificador: "+identificador);
                        System.out.println("La cuenta tiene un saldo de: "+saldo);
                    }
            }
        }
    }
}
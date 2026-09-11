<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>com.example</groupId>
    <artifactId>desarrollo</artifactId>
    <version>1.0-SNAPSHOT</version>

    <properties>
        <maven.compiler.source>17</maven.compiler.source>
        <maven.compiler.target>17</maven.compiler.target>
    </properties>

    <dependencies>
        <!-- PostgreSQL JDBC driver -->
        <dependency>
            <groupId>org.postgresql</groupId>
            <artifactId>postgresql</artifactId>
            <version>42.6.0</version>
        </dependency>

        <!-- Opcional: HikariCP para pool de conexiones (recomendado en producción) -->
        <dependency>
            <groupId>com.zaxxer</groupId>
            <artifactId>HikariCP</artifactId>
            <version>5.0.1</version>
        </dependency>
    </dependencies>
</project>

CREATE TABLE cuentas (
    id SERIAL PRIMARY KEY,
    tipo VARCHAR(50) NOT NULL, -- 'AHORROS' o 'CORRIENTE'
    saldo NUMERIC(12,2) NOT NULL
);

package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    // Puedes usar variables de entorno o cambiar los valores aquí
    private static final String URL = System.getenv().getOrDefault("DB_URL", "jdbc:postgresql://localhost:5432/tu_basedatos");
    private static final String USER = System.getenv().getOrDefault("DB_USER", "postgres");
    private static final String PASS = System.getenv().getOrDefault("DB_PASS", "password");

    public static Connection getConnection() throws SQLException {
        // No es necesario llamar a Class.forName con el driver moderno, pero puedes hacerlo si quieres:
        // Class.forName("org.postgresql.Driver");
        return DriverManager.getConnection(URL, USER, PASS);
    }
}


package com.example;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;

public class DatabaseHikari {
    private static HikariDataSource ds;

    static {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(System.getenv().getOrDefault("DB_URL", "jdbc:postgresql://localhost:5432/tu_basedatos"));
        config.setUsername(System.getenv().getOrDefault("DB_USER", "postgres"));
        config.setPassword(System.getenv().getOrDefault("DB_PASS", "password"));
        config.setMaximumPoolSize(10);
        config.setMinimumIdle(2);
        config.setPoolName("my-pool");
        ds = new HikariDataSource(config);
    }

    public static DataSource getDataSource() {
        return ds;
    }
}

package com.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CuentaDAO {

    // Usando Database.getConnection() (DriverManager). Si usas Hikari, reemplaza por ds.getConnection().
    public void save(Cuenta cuenta, String tipo) throws SQLException {
        String sql = "INSERT INTO cuentas (tipo, saldo) VALUES (?, ?)";
        try (Connection conn = Database.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, tipo);
            ps.setDouble(2, cuenta.getSaldo());
            ps.executeUpdate();
        }
    }

    public Cuenta findById(int id) throws SQLException {
        String sql = "SELECT tipo, saldo FROM cuentas WHERE id = ?";
        try (Connection conn = Database.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    double saldo = rs.getDouble("saldo");
                    String tipo = rs.getString("tipo");
                    if ("AHORROS".equalsIgnoreCase(tipo)) return new CuentaAhorros(saldo);
                    else return new CuentaCorriente(saldo);
                } else {
                    return null;
                }
            }
        }
    }

    public void updateSaldo(int id, double nuevoSaldo) throws SQLException {
        String sql = "UPDATE cuentas SET saldo = ? WHERE id = ?";
        try (Connection conn = Database.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setDouble(1, nuevoSaldo);
            ps.setInt(2, id);
            ps.executeUpdate();
        }
    }

    public List<Cuenta> findAll() throws SQLException {
        String sql = "SELECT tipo, saldo FROM cuentas";
        List<Cuenta> list = new ArrayList<>();
        try (Connection conn = Database.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                double saldo = rs.getDouble("saldo");
                String tipo = rs.getString("tipo");
                if ("AHORROS".equalsIgnoreCase(tipo)) list.add(new CuentaAhorros(saldo));
                else list.add(new CuentaCorriente(saldo));
            }
        }
        return list;
    }

    // Ejemplo seguro para retirar con chequeo de saldo (transaccional y con SELECT FOR UPDATE si quieres serializable)
    public boolean retirarSeguro(int id, double valor) throws SQLException {
        String select = "SELECT saldo FROM cuentas WHERE id = ? FOR UPDATE";
        String update = "UPDATE cuentas SET saldo = ? WHERE id = ?";
        try (Connection conn = Database.getConnection()) {
            try {
                conn.setAutoCommit(false);
                try (PreparedStatement ps = conn.prepareStatement(select)) {
                    ps.setInt(1, id);
                    try (ResultSet rs = ps.executeQuery()) {
                        if (!rs.next()) {
                            conn.rollback();
                            return false;
                        }
                        double saldo = rs.getDouble("saldo");
                        if (saldo < valor) {
                            conn.rollback();
                            return false;
                        }
                        double nuevo = saldo - valor;
                        try (PreparedStatement ps2 = conn.prepareStatement(update)) {
                            ps2.setDouble(1, nuevo);
                            ps2.setInt(2, id);
                            ps2.executeUpdate();
                        }
                        conn.commit();
                        return true;
                    }
                }
            } finally {
                conn.setAutoCommit(true);
            }
        }
    }
}


package com.example;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        try (Connection c = Database.getConnection()) {
            System.out.println("Conexión OK a: " + c.getMetaData().getURL());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

//codigo portable para convertir a api rest

<parent>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-parent</artifactId>
    <version>3.5.5</version>
    <relativePath/>
</parent>

<dependencies>
    <!-- Crear endpoints REST y ejecutar un servidor embebido -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>

    <!-- Validar datos recibidos en las peticiones -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-validation</artifactId>
    </dependency>

    <!-- Pruebas para controladores y servicios -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-test</artifactId>
        <scope>test</scope>
    </dependency>
</dependencies>

<build>
    <plugins>
        <plugin>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-maven-plugin</artifactId>
        </plugin>
    </plugins>
</build>

<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>

<dependency>
    <groupId>org.postgresql</groupId>
    <artifactId>postgresql</artifactId>
    <scope>runtime</scope>
</dependency>

src/main/java/com/example/
├── Main.java
├── controller/
├── service/
├── repository/
└── model/
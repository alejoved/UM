# Primer parcial — Desarrollo de Software

## Actividad práctica integradora: Gestión de usuarios y facturas

**Lenguaje:** Java 17  
**Persistencia:** PostgreSQL  

## Contexto

Una empresa necesita una aplicación de consola para registrar usuarios y las facturas asociadas a sus compras o servicios. El prototipo inicial contiene las clases `Usuario` y `BaseDatos`, además de un `Main` que demuestra una consulta de clientes y facturas. El estudiante deberá completar el dominio de facturación aplicando encapsulamiento, clases, interfaces, herencia y separación de responsabilidades.

La aplicación debe permitir registrar usuarios, registrar facturas, consultar la información almacenada y calcular el impuesto y el total de cada factura. El cálculo debe realizarse en Java mediante objetos del dominio, no como una operación escondida dentro de `Main`.

## Código base y clases obligatorias

Cree el proyecto Maven `examen` y conserve el paquete `com.example`. Las clases existentes son una guía de diseño, no una solución completa.

Debe agregar como mínimo:

```text
com.example
├── BaseDatos.java
├── Main.java
├── Usuario.java
├── Factura.java
├── FacturaOperacion.java
```

La interfaz `FacturaOperacion` debe declarar:

```java
double calcularImpuesto();
double calcularTotal();
```

`Factura` debe implementar la interfaz y contener como mínimo los datos de identificación, concepto, subtotal y porcentaje de impuesto se debe sobrescribir al menos `calcularImpuesto()` o `calcularTotal()` 

Para consultar las facturas se puede ejecutar `SELECT * FROM facturas`, recorrer el `ResultSet`.

## Requisitos funcionales

### RF-01. Registrar usuario

El sistema debe solicitar nombre, email y teléfono. Debe validar que los campos no estén vacíos. Si el registro es exitoso, debe mostrar el identificador asignado. El email no debe duplicarse

### RF-02. Registrar factura

El sistema debe solicitar número, concepto, subtotal, porcentaje de impuesto, tipo de factura y usuario propietario. No debe permitir campos vacíos, subtotal negativo, impuesto negativo

### RF-03. Calcular impuesto

El método `calcularImpuesto()` debe devolver el resultado de la siguiente fórmula:

```text
montoImpuesto = subtotal * porcentajeImpuesto / 100
```

El resultado debe poder mostrarse desde el menú y no debe quedar almacenado como un valor fijo ingresado por el usuario.

### RF-04. Calcular total

El método `calcularTotal()` debe devolver:

```text
total = subtotal + calcularImpuesto()
```

El cálculo debe reutilizar `calcularImpuesto()` para evitar duplicar la fórmula.

### RF-05. Consultar usuarios y facturas

El sistema debe permitir:

- Consultar todos los usuarios.
- Consultar todas las facturas con número, concepto, subtotal, impuesto, tipo y propietario.

Las consultas deben utilizar `PreparedStatement`

### RF-06. Aplicar comportamiento según el tipo de factura

La interfaz `FacturaOperacion` debe definir `calcularImpuesto()` y `calcularTotal()`.

### RF-07. Menú de consola

El menú debe repetirse hasta seleccionar `0. Salir` y ofrecer como mínimo:

```text
1. Registrar usuario
2. Registrar factura
3. Consultar usuarios en base de datos
4. Consultar facturas en base de datos
5. Calcular impuesto
6. Calcular total
0. Salir
```

## Requisitos técnicos obligatorios

1. Los atributos de las entidades deben ser `private`.
2. `Factura` debe implementar `FacturaOperacion`.
3. Las operaciones deben ejecutarse sobre una referencia de tipo `Factura` o `FacturaOperacion`, demostrando polimorfismo.
4. La conexión debe obtenerse desde `BaseDatos.getConnection()`.
5. Toda conexión, sentencia y resultado JDBC debe cerrarse mediante `try`.
6. Las consultas deben utilizar `PreparedStatement`.
7. La fórmula del impuesto debe estar en el dominio de factura y no repetida en cada opción del menú.

## Entregables

- Código fuente completo dentro del proyecto Maven.
- Codigo ejecutandose y las funciones del menu correctas

---

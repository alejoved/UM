# Primer parcial — Desarrollo de Software

## Actividad práctica integradora: Gestión de usuarios y facturas

**Lenguaje:** Java 17  
**Persistencia:** PostgreSQL mediante JDBC  

## Contexto

Una empresa necesita una aplicación de consola para registrar usuarios y las facturas asociadas a sus compras o servicios. El prototipo inicial contiene las clases `Usuario` y `BaseDatos`, además de un `Main` que demuestra una consulta de clientes y facturas. El estudiante deberá completar el dominio de facturación aplicando encapsulamiento, clases, interfaces, herencia y separación de responsabilidades.

La aplicación debe permitir registrar usuarios, registrar facturas, consultar la información almacenada y calcular el impuesto y el total de cada factura. El cálculo debe realizarse en Java mediante objetos del dominio, no como una operación escondida dentro de `Main`.

## Objetivos de aprendizaje

Al finalizar la actividad, el estudiante deberá poder:

- Modelar usuarios y facturas mediante clases Java.
- Aplicar encapsulamiento con atributos `private`, constructores y métodos de acceso.
- Definir una interfaz `FacturaOperacion` con las operaciones de cálculo del dominio.
- Aplicar herencia y polimorfismo mediante distintos tipos de factura.
- Conectarse a PostgreSQL y cerrar recursos correctamente.
- Usar `PreparedStatement` para consultar datos.
- Separar la interacción de consola, la lógica de facturación y la persistencia.
- Validar entradas y manejar errores sin finalizar la aplicación inesperadamente.

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

Las opciones inválidas deben mostrar un mensaje y volver al menú. El programa no debe terminar por una entrada no numérica.

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

# Cuestionario de opción múltiple

**Instrucciones:** seleccione una única respuesta correcta en cada pregunta. Cada pregunta vale 3 puntos. Las opciones son `A`, `B`, `C` y `D`.

### 1. Encapsulamiento de `Factura`

En la clase `Factura`, los atributos `subtotal` e `impuesto` están declarados como `private`. ¿Cuál es la principal ventaja de este diseño?

A. Permite que cualquier clase cambie los valores sin validaciones.
B. Oculta el estado interno y permite controlar el acceso mediante métodos.
C. Convierte automáticamente a `Factura` en una interfaz.
D. Impide que otras clases calculen el total.

### 2. Interfaz `FacturaOperacion`

¿Qué contrato define correctamente una interfaz `FacturaOperacion` con los métodos `calcularImpuesto()` y `calcularTotal()`?

A. Toda clase que la implemente debe proporcionar ambos métodos.
B. La interfaz almacena el subtotal de todas las facturas.
C. La interfaz crea automáticamente una conexión a PostgreSQL.
D. Solo `FacturaInternacional` puede implementar sus métodos.

### 3. Cálculo del impuesto

Una factura tiene subtotal `200000` y porcentaje de impuesto `19`. ¿Qué valor debe devolver `calcularImpuesto()`?

A. `3800`
B. `200019`
C. `38000`
D. `238000`

### 4. Cálculo del total

Si una factura tiene subtotal `100000` y `calcularImpuesto()` devuelve `19000`, ¿qué debe devolver `calcularTotal()`?

A. `81000`
B. `100000`
C. `119000`
D. `190000`

### 6. `ResultSet`

¿Cuál es la responsabilidad principal de `ResultSet` al ejecutar `SELECT * FROM facturas`?

A. Abrir la conexión con PostgreSQL.
B. Preparar la cadena SQL antes de enviarla.
C. Representar las filas devueltas y permitir recorrerlas.
D. Calcular automáticamente el impuesto de cada factura.

### 7. `try`

¿Por qué se recomienda utilizar `try (Connection conn = ...; PreparedStatement ps = ...)`?

A. Para evitar que la consulta tenga resultados.
B. Para cerrar automáticamente los recursos que implementan `AutoCloseable`.
C. Para convertir una consulta SQL en una clase Java.
D. Para impedir que `SQLException` exista.

### 8. Consulta sin condiciones SQL

La actividad no incluye condiciones SQL. Para listar todas las facturas y luego localizar una por su número desde Java, ¿cuál opción es correcta?

A. Ejecutar `SELECT * FROM facturas` con `PreparedStatement`, recorrer el `ResultSet` y comparar el número en Java.
B. Concatenar el número al final de la cadena SQL.
C. Utilizar `Statement` y escribir el número directamente en la consulta.
D. No utilizar ninguna consulta y asumir que la factura existe.

### 9. Responsabilidad de `Factura`

¿Cuál es la responsabilidad más adecuada para `Factura`?

A. Mostrar todas las opciones del menú y leer datos con `Scanner`.
B. Representar visualmente el formulario de factura.
C. Representar las variables de las facturas y devolver datos claros.
D. Reemplazar la interfaz `FacturaOperacion` y calcular todos los totales.

### 10. Separación de responsabilidades

En la actividad se solicita que `Main` no contenga todos los cálculos ni todas las consultas SQL. ¿Cuál es la razón principal?

A. Las clases de dominio y repositorios separan el cálculo y la persistencia de la interacción de consola, facilitando el mantenimiento.
B. Java no permite escribir SQL ni realizar cálculos dentro de `Main`.
C. `Main` solo puede contener constructores y atributos privados.
D. Los repositorios reemplazan obligatoriamente a todas las clases de dominio.

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

### 3. Implementación de la interfaz

¿Cuál fragmento declara correctamente una clase `Factura` que cumple el contrato de `FacturaOperacion`?

A. `class Factura extends FacturaOperacion { }`
B. `class Factura implements FacturaOperacion { public double calcularImpuesto() { return 0; } public double calcularTotal() { return 0; } }`
C. `interface Factura implements FacturaOperacion { }`
D. `class Factura { private FacturaOperacion operacion; }`

### 4. Consulta con postgres

¿Cuál fragmento cumple los requisitos de utilizar `BaseDatos.getConnection()`, `PreparedStatement`?

A. `try (Connection conn = BaseDatos.getConnection(); PreparedStatement ps = conn.prepareStatement("SELECT * FROM facturas"); ResultSet rs = ps.executeQuery()) { while (rs.next()) { /* leer fila */ } }`
B. `Connection conn = BaseDatos.getConnection(); Statement st = conn.createStatement(); st.executeQuery("SELECT * FROM facturas");`
C. `PreparedStatement ps = BaseDatos.getConnection().prepareStatement("SELECT * FROM facturas"); ps.executeQuery();`
D. `try (Connection conn = BaseDatos.getConnection()) { conn.prepareStatement("SELECT * FROM facturas"); }`

### 5. `ResultSet`

¿Cuál es la responsabilidad principal de `ResultSet` al ejecutar `SELECT * FROM facturas`?

A. Abrir la conexión con PostgreSQL.
B. Preparar la cadena SQL antes de enviarla.
C. Representar las filas devueltas y permitir recorrerlas.
D. Calcular automáticamente el impuesto de cada factura.

## Clave de respuestas

| Pregunta | Respuesta |
|---:|:---:|
| 1 | B |
| 2 | A |
| 3 | B |
| 4 | A |
| 5 | B |
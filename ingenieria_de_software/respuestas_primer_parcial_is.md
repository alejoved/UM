# Cuestionario de opción múltiple

**Instrucciones:** seleccione una única respuesta correcta en cada pregunta. Cada pregunta vale 3 puntos. Las opciones son `A`, `B`, `C` y `D`.

### 1. Principio de Responsabilidad Única en `Cliente`

¿Cuál diseño aplica correctamente el principio **S — Responsabilidad Única**?

A. `Cliente` representa nombre, teléfono y correo, mientras otra clase se encarga de leer datos con `Scanner`.
B. `Cliente` representa datos, muestra el menú, calcula impuestos y procesa pagos.
C. `Cliente` crea facturas, selecciona medios de pago y almacena todas las cuentas.
D. `Cliente` reemplaza al servicio de facturación y controla toda la entrada y salida.

### 2. Principio de Responsabilidad Única en `Factura`

Según el enunciado, ¿qué responsabilidad debe permanecer principalmente dentro de `Factura`?

A. Leer opciones del menú y mostrar mensajes de consola.
B. Crear directamente objetos `PagoPSE`, `PagoNequi` y `PagoTarjeta`.
C. Calcular el impuesto y el total mediante `FacturaOperacion`.
D. Registrar clientes y decidir cómo se guardan en la colección.

### 3. Separación de responsabilidades

¿Cuál distribución de responsabilidades respeta mejor el principio **S**?

A. `Factura` calcula sus valores, el servicio coordina casos de uso y la interfaz de consola lee y muestra información.
B. `Main` concentra validaciones, cálculos, pagos, almacenamiento y lectura con `Scanner`.
C. El servicio imprime todos los mensajes, calcula impuestos y contiene los atributos de cada cliente.
D. La interfaz de consola modifica directamente el estado interno de las facturas y cuentas.

### 4. Principio Abierto/Cerrado en medios de pago

Se necesita agregar `PagoEfectivo`. ¿Qué solución aplica mejor el principio **O — Abierto/Cerrado**?

A. Crear `PagoEfectivo implements MedioPago` sin modificar la lógica central de procesamiento.
B. Agregar un `case` nuevo en cada método de `Ejecucion` que procese pagos.
C. Modificar `PagoPSE`, `PagoNequi` y `PagoTarjeta` para que conozcan la nueva clase.
D. Copiar el código de `pagar(double valor)` dentro de `Main`.

### 5. Dependencia de una abstracción

¿Cuál firma permite que `Ejecucion` cumpla el principio **O** y pueda trabajar con distintos medios de pago?

A. `public void procesarPago(PagoPSE pago, double valor)`
B. `public void procesarPago(Object pago, double valor)`
C. `public void procesarPago(MedioPago medioPago, double valor)`
D. `public void procesarPago(String tipoPago, double valor)`

### 6. Diseño que viola el principio Abierto/Cerrado

¿Por qué un `switch` que crea directamente cada medio de pago dentro de `Ejecucion` es un diseño menos adecuado?

A. Porque impide que `Factura` calcule el impuesto con `19 %`.
B. Porque obliga a modificar la lógica central cada vez que se agrega una implementación de `MedioPago`.
C. Porque evita que una cuenta corriente cobre una comisión.
D. Porque hace que los atributos de `Cliente` sean automáticamente públicos.

### 7. Sustitución de Liskov con cuentas

¿Qué situación demuestra mejor el principio **L — Sustitución de Liskov**?

```java
Cuenta cuenta = new CuentaAhorros("SERGIO", 500000);
cuenta.consignar(100000);
```

A. `CuentaAhorros` puede utilizarse como `Cuenta` sin romper el contrato de consignar valores positivos.
B. `CuentaAhorros` debe ignorar todas las reglas definidas en `Cuenta`.
C. `Cuenta` debe conocer y crear internamente todas sus subclases.
D. La referencia de tipo `Cuenta` solo puede apuntar a objetos de la clase `Cuenta`.

### 8. Sustitución de Liskov con medios de pago

Si un servicio recibe un `MedioPago`, ¿qué debe cumplir cualquier implementación como `PagoPSE`, `PagoNequi` o `PagoTarjeta`?

A. Debe permitir que el servicio la use mediante `pagar(double valor)` sin depender de su clase concreta.
B. Debe modificar el código del servicio para agregar un método exclusivo para cada pago.
C. Debe heredar obligatoriamente de `Factura` para poder procesar un pago.
D. Debe aceptar valores menores o iguales a cero para ser compatible con todas las facturas.

### 9. Reglas de subtipos de `Cuenta`

¿Cuál diseño mantiene la sustitución correcta de las cuentas y sus reglas específicas?

A. `CuentaAhorros` puede quedar con saldo negativo aunque `Cuenta` prohíba retiros inválidos.
B. `CuentaCorriente` puede redefinir el retiro para aplicar una comisión documentada, manteniendo las validaciones generales.
C. `CuentaCorriente` debe eliminar la validación de valores menores o iguales a cero.
D. `CuentaAhorros` debe cambiar el tipo de todos los métodos públicos de `Cuenta`.

### 10. Evaluación integrada de S, O y L

¿Cuál propuesta cumple mejor los tres principios aplicados en el parcial?

A. `Factura` calcula impuesto y total; un servicio recibe `MedioPago`; las subclases de `Cuenta` conservan el contrato base.
B. `Main` calcula facturas y usa un `switch` para crear cada pago; las cuentas ignoran las reglas de `Cuenta`.
C. `Ejecucion` contiene el menú, los cálculos de factura y una condición distinta para cada subclase.
D. Cada medio de pago conoce todas las facturas y cada factura crea directamente sus cuentas.

## Clave de respuestas

| Pregunta | Respuesta |
|---:|:---:|
| 1 | A |
| 2 | C |
| 3 | A |
| 4 | A |
| 5 | C |
| 6 | B |
| 7 | A |
| 8 | A |
| 9 | B |
| 10 | A |
# Primer parcial — Ingeniería de Software

## Actividad práctica integradora: Casos de uso y sistema de facturación

**Lenguaje:** Java 17  
**Pruebas:** JUnit 5  

## Contexto

Una empresa necesita un prototipo para registrar clientes, generar facturas y recibir pagos por distintos medios. El proyecto de referencia contiene clases para representar clientes y cuentas, una interfaz `MedioPago`, implementaciones de `PagoPSE`, `PagoNequi` y `PagoTarjeta`, una clase `Ejecucion` que procesa pagos, una calculadora y ejemplos de herencia con `CuentaAhorros` y `CuentaCorriente`.

El objetivo es transformar ese prototipo en una aplicación de dominio coherente. Antes de programar, se debe describir los casos de uso y las reglas del negocio. Después debe implementar el modelo, separar responsabilidades, aplicar polimorfismo y crear pruebas automatizadas.

La solución no requiere base de datos ni interfaz gráfica. La información puede permanecer en memoria durante la ejecución.

## Código base

Cree un proyecto Maven `examen` y conserve el paquete `com.example`. Las clases existentes son una guía de diseño, no una solución completa.

```text
├── Factura.java
├── Cliente.java
├── Cuenta.java
├── CuentaAhorro.java
├── CuentaCorriente.java
├── FacturaOperacion.java
└── Main.java
```

## Reglas del dominio

1. Un `Cliente` debe tener nombre, teléfono y correo. Ninguno puede estar vacío.
2. Una `Factura` debe tener número, cliente, concepto y subtotal.
3. El subtotal no puede ser negativo.
4. El porcentaje de impuesto debe estar entre `0` y `100`.
5. El impuesto se calcula con la fórmula:

```text
montoImpuesto = subtotal * porcentajeImpuesto / 100
```

6. El total se calcula así:

```text
total = subtotal + montoImpuesto
```

7. Una factura nueva comienza en estado `PENDIENTE`.
8. Solo una factura pendiente puede pagarse.
9. Una factura no puede marcarse como `PAGADA` si el medio de pago rechaza la operación.
10. Una factura pagada no puede volver a pagarse.
11. El monto pagado debe ser mayor que cero y debe cubrir el total de la factura.
12. `PagoPSE`, `PagoNequi` y `PagoTarjeta` deben implementar `MedioPago`.
13. `Ejecucion` o un servicio equivalente debe recibir un `MedioPago`, no una clase concreta, para demostrar polimorfismo.
14. `CuentaAhorros` y `CuentaCorriente` deben conservar la relación de herencia con `Cuenta`.
15. Una cuenta no puede aceptar consignaciones o retiros con valores menores o iguales a cero.
16. Una cuenta de ahorros no puede quedar con saldo negativo.
17. Una cuenta corriente puede cobrar una comisión fija de mantenimiento o de retiro, pero la regla debe estar documentada y probada.

## Requisitos funcionales

### RF-01. Registrar clientes

El sistema debe permitir registrar clientes y rechazar campos vacíos. Debe permitir consultar los datos de un cliente mediante métodos de acceso sin exponer directamente sus atributos.

### RF-02. Crear facturas

El sistema debe permitir crear facturas con número, cliente, concepto, subtotal y porcentaje de impuesto. Debe rechazar datos inválidos y establecer el estado inicial en `PENDIENTE`.

### RF-03. Calcular impuesto y total

La factura debe ofrecer operaciones para calcular el impuesto y el total. El total debe reutilizar el cálculo del impuesto y no duplicar la fórmula en `Main`.

### RF-04. Procesar pagos

El sistema debe permitir pagar una factura mediante cualquier objeto que implemente `MedioPago`. El pago aprobado cambia el estado de la factura a `PAGADA`; el pago rechazado conserva el estado `PENDIENTE`.

### RF-05. Consultar facturas

El sistema debe mostrar una lista de facturas con número, cliente, subtotal, impuesto, total y estado. Las facturas deben poder identificarse por su número usando una colección en memoria.

### RF-06. Operar cuentas

El sistema debe permitir consignar y retirar desde una referencia de tipo `Cuenta`. Las subclases pueden redefinir el comportamiento cuando exista una regla específica, como una comisión de retiro en `CuentaCorriente`.

### RF-07. Menú de consola

El menú debe ofrecer como mínimo:

```text
1. Registrar cliente
2. Registrar cuenta
2. Crear factura
4. Calcular impuesto
5. Calcular total
6. Pagar factura
0. Salir
```

Las opciones inválidas y los valores no numéricos deben mostrar un mensaje comprensible sin finalizar abruptamente el programa.

## Requisitos técnicos y SOLID

1. Todos los atributos del dominio deben ser `private`.
2. `Factura` debe implementar una interfaz `FacturaOperacion` que declare `calcularImpuesto()` y `calcularTotal()`.
3. `MedioPago` debe continuar siendo una interfaz con el método `pagar(double valor)`.
4. `PagoPSE`, `PagoNequi` y `PagoTarjeta` deben implementar `MedioPago`.
5. El procesamiento debe recibir una referencia `MedioPago`, como ocurre en `Ejecucion`.
6. `CuentaAhorros` y `CuentaCorriente` deben extender `Cuenta`.
7. La lógica de cálculo de factura no debe quedar dentro de `Main`.
8. La clase `Cliente` debe representar datos del cliente.
9. El servicio de facturación debe coordinar casos de uso, pero no debe concentrar todos los detalles de entrada y salida.
10. No se permite resolver los medios de pago con un `switch` que cree directamente cada clase dentro de `Ejecucion`.
11. Se debe utilizar Scanner para recoleccion de datos.
12. Se deben incluir pruebas unitarias para resultados correctos y reglas de rechazo.

### Aplicación esperada de SOLID

- **S — Responsabilidad única:** `Cliente` representa datos; `Factura` calcula sus valores; el servicio coordina; la interfaz de consola lee y muestra.
- **O — Abierto/cerrado:** se debe poder agregar `PagoRappi` o `PagoBancario` creando una nueva implementación de `MedioPago` sin modificar la lógica central de `Ejecucion`.
- **L — Sustitución de Liskov:** cualquier implementación válida de `MedioPago` debe poder utilizarse donde se espera `MedioPago` sin romper el caso de uso.

## Casos de prueba mínimos

| ID | Situación | Resultado esperado |
|---|---|---|
| T-01 | Crear cliente con datos válidos | Cliente creado |
| T-02 | Crear cliente con correo vacío | Operación rechazada |
| T-03 | Crear factura con subtotal negativo | Operación rechazada |
| T-04 | Calcular impuesto de `100000` al `19 %` | `19000` |
| T-05 | Calcular total de `100000` al `19 %` | `119000` |

## Entregables

- Código fuente completo en el proyecto Maven.
- Codigo que se ejecuta correctamente.
- Pruebas unitarias que se ejecutan correctamente.

---

# Cuestionario de opción múltiple

**Instrucciones:** seleccione una única respuesta correcta en cada pregunta. Cada pregunta vale 3 puntos. Las opciones son `A`, `B`, `C` y `D`.

### 1. Pruebas con JUnit

¿qué función cumple la anotación `@Test` colocada antes de métodos de pruebas unitarias?

A. Indica que el método debe ejecutarse automáticamente como una prueba independiente.
B. Crea una nueva instancia de `Calculadora` antes de cada método.
C. Compara el resultado obtenido con el resultado esperado.
D. Captura las excepciones producidas por cualquier método de Java.

### 2. Cálculo de impuesto

Una factura tiene subtotal `200000` y porcentaje de impuesto `19`. ¿Qué resultado debe devolver `calcularImpuesto()`?

A. `3800`
B. `200019`
C. `38000`
D. `238000`

### 3. Cálculo del total

Si una factura tiene subtotal `100000` y su impuesto calculado es `19000`, ¿cuál debe ser su total?

A. `81000`
B. `100000`
C. `119000`
D. `190000`

### 4. Polimorfismo con medios de pago

¿Qué demuestra principalmente el siguiente método?

```java
public void procesarPago(MedioPago medioPago, double valor) {
	medioPago.pagar(valor);
}
```

A. Que `Ejecucion` solo puede trabajar con `PagoPSE`.
B. Que el método usa una abstracción y puede recibir distintas implementaciones de `MedioPago`.
C. Que Java permite herencia múltiple entre medios de pago.
D. Que la interfaz `MedioPago` almacena el valor pagado.

### 5. Principio Open/Closed

Se necesita agregar `PagoRappi` como nuevo medio de pago. ¿Qué opción respeta mejor el principio Open/Closed?

A. Crear `PagoRappi implements MedioPago` sin modificar `Ejecucion`.
B. Agregar un nuevo `case` dentro de `Ejecucion` para cada pago.
C. Eliminar la interfaz y copiar el método de pago en `Main`.
D. Modificar todas las clases de pago existentes para reconocer `PagoRappi`.

### 6. Herencia de cuentas

En el código se utiliza:

```java
Cuenta cuenta1 = new CuentaAhorros("SERGIO", 500000);
```

¿Qué concepto se evidencia?

A. Una variable de tipo base referencia un objeto de una subclase.
B. Una clase implementa una interfaz funcional.
C. Una cuenta contiene otra cuenta por composición.
D. Un método estático reemplaza a un constructor.

### 7. Sobrescritura en `CuentaCorriente`

Si `CuentaCorriente` redefine `retirar` y descuenta además una comisión de `10000`, ¿qué sucede al retirar `50000` de un saldo de `280000`?

A. El saldo final es `230000`.
B. El saldo final es `220000`.
C. El saldo final es `280000` porque la clase base no puede ser sobrescrita.
D. Se produce una excepción necesariamente.

### 8. Encapsulamiento y responsabilidad única

¿Cuál diseño respeta mejor el principio de Responsabilidad Única?

A. `Cliente` guarda sus datos, mientras otra clase lee con `Scanner` y procesa pagos.
B. `Cliente` guarda datos, lee la consola, imprime facturas y cobra pagos.
C. `Factura` contiene el menú completo y el código de cada medio de pago.
D. `Main` valida, calcula, persiste y prueba todo el sistema.

### 9. Pruebas unitarias

Según el proyecto, ¿para qué se utiliza principalmente JUnit?

A. Para escribir y ejecutar pruebas automatizadas que verifiquen el comportamiento de las clases.
B. Para crear interfaces gráficas para la aplicación.
C. Para conectar la aplicación con una base de datos.
D. Para reemplazar las clases del dominio por métodos estáticos.

### 10. Pruebas unitarias

En la prueba `test_multiplicacion_numeros_positivos()`, se ejecuta `assertEquals(20.0, resultado)` después de calcular `5 * 4`. ¿Qué verifica esta instrucción?

A. Que el método `multiplicacion()` reciba exactamente dos objetos.
B. Que el resultado obtenido sea igual al valor esperado `20.0`.
C. Que la calculadora no pueda realizar divisiones.
D. Que el método de prueba se ejecute antes que todos los demás.

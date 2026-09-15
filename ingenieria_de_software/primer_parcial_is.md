# Primer parcial — Ingeniería de Software

## Actividad práctica integradora: Casos de uso y sistema de facturación

**Lenguaje:** Java 17  
**Pruebas:** JUnit 5  

## Contexto

Una empresa necesita un prototipo para registrar clientes, generar facturas y recibir pagos por distintos medios. El proyecto de referencia contiene clases para representar clientes y cuentas, una interfaz `MedioPago`, implementaciones de `PagoPSE`, `PagoNequi` y `PagoTarjeta`, una clase `Ejecucion` que procesa pagos, una calculadora y ejemplos de herencia con `CuentaAhorros` y `CuentaCorriente`.

El objetivo es transformar ese prototipo en una aplicación de dominio coherente. Antes de programar, se debe describir los casos de uso y las reglas del negocio. Después debe implementar el modelo, separar responsabilidades, aplicar los principios SOLID y crear pruebas automatizadas.

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
- **O — Abierto/cerrado:** se debe poder agregar `PagoTarjeta` o `PagoEfectivo` creando una nueva implementación de `MedioPago` sin modificar la lógica central de `Ejecucion`.
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

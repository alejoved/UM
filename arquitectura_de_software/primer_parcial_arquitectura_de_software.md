# Examen — Arquitectura de Software

**Nombre y apellido:** ____________________________________  
**Fecha:** ____________________  
**Puntaje:** 10 puntos (1 punto por pregunta)

## Instrucciones

- Seleccione **una única respuesta correcta** por pregunta.
- Cada pregunta tiene seis opciones posibles: `A`, `B`, `C`, `D`, `E` y `F`.
- En las preguntas de código, considere las clases Java del proyecto `arquitectura`.
- Justifique brevemente su elección cuando el docente lo solicite.

## Preguntas

### 1. CuentaBancaria e interfaz de operaciones

Considere las clases `CuentaBancaria` y `CuentaOperacion`. ¿Qué permite la declaración `public class CuentaBancaria implements CuentaOperacion`?

A. Que `CuentaBancaria` herede todos los atributos privados de cualquier otra cuenta.
B. Que `CuentaBancaria` deba implementar los métodos `retirar` y `consignar` definidos en la interfaz.
C. Que `CuentaOperacion` pueda crear directamente objetos de `CuentaBancaria`.
D. Que `CuentaBancaria` no pueda tener atributos privados.
E. Que los métodos de la interfaz se conviertan automáticamente en métodos estáticos.
F. Que `CuentaBancaria` pueda extender simultáneamente varias clases concretas.

### 2. Cálculo de una factura

Se crea una factura con subtotal `200000` e impuesto `19`, y luego se ejecuta `calcularTotal(factura)`. ¿Qué total imprime `FacturaOperacion`?

A. 200019
B. 200190
C. 219000
D. 238000
E. 380000
F. 200000

### 3. Flujo de salida en `Main`

En `Main`, el ciclo se ejecuta mientras `opcion != 3` y contiene la instrucción que imprime el saldo después de los bloques `if`. Si el usuario ingresa `3`, ¿qué ocurre?
```java
int opcion = 0;
while (opcion != 3){
    System.out.println("Menu: 1. Retirar 2. Consignar 3. Salir");
    opcion = scanner.nextInt();
    if(opcion == 1){
        System.out.println("Por favor ingrese el monto a retirar");
        double valor = scanner.nextDouble();
        cuentaBancaria.retirar(valor);
    }
    if(opcion ==2){
        System.out.println("Por favor ingrese el monto a consignar");
        double valor = scanner.nextDouble();
        cuentaBancaria.consignar(valor);
    }
    System.out.println("El saldo de tu cuenta es de: "+cuentaBancaria.getSaldo());
}
```

A. Se ejecuta `retirar(3)` y se descuenta el valor 3 del saldo.
B. Se ejecuta `consignar(3)` y se suma el valor 3 al saldo.
C. El ciclo termina sin imprimir el saldo en esa iteración.
D. El ciclo termina después de imprimir nuevamente el saldo actual.
E. Se produce una excepción porque no existe un `if` para la opción 3.
F. El ciclo continúa indefinidamente porque la opción 3 no modifica `saldo`.

### 4. Requisitos arquitectónicamente significativos

¿Cuál de los siguientes requisitos es más claramente un ASR y requiere una decisión arquitectónica explícita?

A. El campo `nombre` acepta como máximo 100 caracteres.
B. El sistema permite cambiar la foto de perfil.
C. El sistema muestra un mensaje de bienvenida después del registro.
D. El sistema procesa 100.000 transacciones por segundo.
E. El usuario puede seleccionar un color para su perfil.
F. El sistema permite consultar la fecha de creación de una cuenta.

### 5. Drivers arquitectónicos

Una empresa exige que los datos de salud permanezcan físicamente en Colombia debido a una regulación. ¿Qué tipo de driver arquitectónico representa principalmente esta condición?

A. Una restricción regulatoria que limita las alternativas de despliegue.
B. Un requisito funcional que obliga a crear una pantalla adicional.
C. Una preocupación de usabilidad relacionada con el aprendizaje.
D. Una táctica de rendimiento basada en caché.
E. Un patrón de diseño para encapsular objetos.
F. Un requisito de código que solo afecta una función.

### 6. Implementación de notificadores

Considere las declaraciones `NotificadorEmail notificador = new ClienteEmail();` y `NotificadorSMS notificador = new ClienteSMS();`. ¿Qué concepto de POO se evidencia principalmente?

A. Encapsulamiento de todos los atributos dentro de una clase abstracta.
B. Polimorfismo mediante referencias de tipo interfaz y objetos concretos diferentes.
C. Herencia múltiple entre `ClienteEmail` y `ClienteSMS`.
D. Sobrecarga de métodos con el mismo nombre y distintos parámetros.
E. Acoplamiento directo de `Main` con una única implementación de notificación.
F. Conversión automática de una interfaz en una clase concreta.

### 7. Comportamiento de `retirarSaldo`

Una instancia de `CuentaAhorros` se crea con saldo `1000000` y se ejecuta `double restante = cuenta.retirarSaldo(450000);`. Según la implementación actual de `Cuenta`, ¿qué sucede con el saldo interno de la cuenta?

A. El saldo queda en `550000`, porque `retirarSaldo` modifica el atributo.
B. El saldo queda en `1000000`, aunque el método retorna `550000` como resultado calculado.
C. El saldo queda en `1450000`, porque retirar suma el valor recibido.
D. El saldo queda en `0`, porque las cuentas de ahorro no permiten retiros.
E. Se produce un error de compilación porque `CuentaAhorros` no redefine `retirarSaldo`.
F. El saldo queda en `550000`, pero solo si la cuenta es `CuentaCorriente`.

### 8. Polimorfismo y Dependency Inversion en Java

Considere el siguiente código:

```java
public void procesarCobro(MedioPago medioPago, double monto) {
	medioPago.cobrar(monto);
}
```

¿Cuál afirmación describe mejor el diseño?

A. `Ejecucion` depende directamente de `PagoPSE` y no acepta otros medios.
B. El método usa una abstracción, por lo que puede recibir `PagoPSE`, `PagoTarjeta` o `PagoBilleteraDigital` mediante polimorfismo.
C. La interfaz `MedioPago` impide agregar nuevas formas de pago.
D. El método solo funciona si se modifica cada vez que aparece una nueva subclase.
E. El parámetro `MedioPago` es una instancia concreta de `PagoTarjeta`.
F. El método aplica herencia múltiple entre todas las formas de pago.

### 9. Principio Open/Closed

El sistema ya cuenta con `PagoPSE`, `PagoTarjeta` y `PagoBilleteraDigital`, todos implementando `MedioPago`. Se necesita agregar `PagoCripto`. ¿Qué modificación respeta mejor el principio Open/Closed?

A. Modificar `Ejecucion` agregando un `if` nuevo para cada tipo de pago.
B. Reescribir la interfaz `MedioPago` y eliminar sus implementaciones actuales.
C. Crear `PagoCripto implements MedioPago` sin cambiar `Ejecucion`.
D. Copiar el método `procesarCobro` dentro de cada clase de pago.
E. Hacer públicos los atributos internos de todas las clases.
F. Cambiar `MedioPago` por una cadena de texto con el nombre del medio.

### 10. Single Responsibility y separación de responsabilidades

En el código, `Factura` mantiene datos como subtotal e impuesto, mientras `FacturaOperacion` calcula e imprime el total y el impuesto. ¿Qué interpretación es más consistente con el principio Single Responsibility?

A. La separación permite que `Factura` represente sus datos y que otra clase concentre las operaciones; cada clase tiene un motivo de cambio más acotado.
B. Se viola necesariamente SRP porque toda clase debe tener exactamente un método.
C. `FacturaOperacion` debería encargarse también de enviar correos y acceder a la base de datos.
D. `Factura` debe heredar de `FacturaOperacion` para cumplir SRP.
E. Todos los cálculos deben pasar a `Main`, porque SRP prohíbe clases de servicio.
F. La solución correcta es combinar ambas clases en una sola para reducir el número de archivos.

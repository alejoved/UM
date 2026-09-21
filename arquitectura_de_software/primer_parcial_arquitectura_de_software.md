# Examen — Arquitectura de Software

**Nombre y apellido:** ____________________________________  
**Fecha:** ____________________  
**Puntaje:** 20 puntos

## Preguntas

### 1. CuentaBancaria e interfaz de operaciones
Considere las clases `CuentaBancaria` y `CuentaOperacion`. ¿Qué permite la declaración `public class CuentaBancaria implements CuentaOperacion`?
```java
public interface CuentaOperacion {
    void retirar(double valor);
    void consignar(double valor);
}
public class CuentaBancaria implements CuentaOperacion {
    // métodos de la cuenta bancaria
}
```
A. Que `CuentaBancaria` herede todos los atributos privados de cualquier otra cuenta.
B. Que `CuentaBancaria` deba implementar los métodos `retirar` y `consignar` definidos en la interfaz.
C. Que `CuentaOperacion` pueda crear directamente objetos de `CuentaBancaria`.
D. Que `CuentaBancaria` no pueda tener atributos privados.

### 2. Cálculo de una factura
Se crea una factura con subtotal `200000` e impuesto `19`, y luego se ejecuta `calcularTotal(factura)`. ¿Qué total imprime `FacturaOperacion`?
```java
public double calcularTotal(Factura factura) {
    double impuesto = factura.getSubtotal() * factura.getImpuesto() / 100;
    return factura.getSubtotal() + impuesto;
}
```
A. 200019
B. 200190
C. 219000
D. 238000

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

### 4. Requisitos arquitectónicamente significativos
¿Cuál de los siguientes requisitos es más claramente un ASR y requiere una decisión arquitectónica explícita?
A. El campo `nombre` acepta como máximo 100 caracteres.
B. El sistema permite cambiar la foto de perfil.
C. El sistema muestra un mensaje de bienvenida después del registro.
D. El sistema procesa 100.000 transacciones por segundo.

### 5. Drivers arquitectónicos
Una empresa exige que los datos de salud permanezcan físicamente en Colombia debido a una regulación. ¿Qué tipo de driver arquitectónico representa principalmente esta condición?
A. Una restricción regulatoria que limita las alternativas de despliegue.
B. Un requisito funcional que obliga a crear una pantalla adicional.
C. Una preocupación de usabilidad relacionada con el aprendizaje.
D. Una táctica de rendimiento basada en caché.

### 6. Implementación de notificadores
Considere las declaraciones `NotificadorEmail notificador = new ClienteEmail();` y `NotificadorSMS notificador = new ClienteSMS();`. ¿Qué concepto de POO se evidencia principalmente?
```java
public interface NotificadorEmail {
    void enviarEmail(String destinatario, String mensaje);
}
public class ClienteEmail implements NotificadorEmail {
    // implementación concreta
}
```
A. Encapsulamiento de todos los atributos dentro de una clase abstracta.
B. Polimorfismo mediante referencias de tipo interfaz y objetos concretos diferentes.
C. Herencia múltiple entre `ClienteEmail` y `ClienteSMS`.
D. Sobrecarga de métodos con el mismo nombre y distintos parámetros.

### 7. Comportamiento de `retirarSaldo`
Una instancia de `CuentaAhorros` se crea con saldo `1000000` y se ejecuta `double restante = cuenta.retirarSaldo(450000);`. Según la implementación actual de `Cuenta`, ¿qué sucede con el saldo interno de la cuenta?
```java
public double retirarSaldo(double valor) {
    return saldo - valor;
}
```
A. El saldo queda en `550000`, porque `retirarSaldo` modifica el atributo.
B. El saldo queda en `1000000`, aunque el método retorna `550000` como resultado calculado.
C. El saldo queda en `1450000`, porque retirar suma el valor recibido.
D. El saldo queda en `0`, porque las cuentas de ahorro no permiten retiros.

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

### 9. Principio Open/Closed
El sistema ya cuenta con `PagoPSE`, `PagoTarjeta` y `PagoBilleteraDigital`, todos implementando `MedioPago`. Se necesita agregar `PagoCripto`. ¿Qué modificación respeta mejor el principio Open/Closed?
```java
public interface MedioPago {
    void cobrar(double monto);
}
public class PagoPSE implements MedioPago {
    public void cobrar(double monto) { /* ... */ }
}
```
A. Modificar `Ejecucion` agregando un `if` nuevo para cada tipo de pago.
B. Reescribir la interfaz `MedioPago` y eliminar sus implementaciones actuales.
C. Crear `PagoCripto implements MedioPago` sin cambiar `Ejecucion`.
D. Copiar el método `procesarCobro` dentro de cada clase de pago.

### 10. Single Responsibility y separación de responsabilidades

En el código, `Factura` mantiene datos como subtotal e impuesto, mientras `FacturaOperacion` calcula e imprime el total y el impuesto. ¿Qué interpretación es más consistente con el principio Single Responsibility?
A. La separación permite que `Factura` represente sus datos y que otra clase concentre las operaciones; cada clase tiene un motivo de cambio más acotado.
B. Se viola necesariamente SRP porque toda clase debe tener exactamente un método.
C. `FacturaOperacion` debería encargarse también de enviar correos y acceder a la base de datos.
D. `Factura` debe heredar de `FacturaOperacion` para cumplir SRP.

### 11. Responsabilidad de `CuentaBancaria`
La clase `CuentaBancaria` administra el identificador, el saldo y las operaciones de retirar y consignar. ¿Qué análisis se relaciona mejor con el principio Single Responsibility?

```java
private String identificador;
private double saldo;

public void retirar(double valor) { saldo -= valor; }
public void consignar(double valor) { saldo += valor; }
```
A. La clase tiene responsabilidades relacionadas con el concepto de cuenta bancaria y su comportamiento básico.
B. La clase viola SRP únicamente porque tiene más de un atributo.
C. La clase debe incluir también el envío de correos para tener una responsabilidad completa.
D. La clase debe calcular facturas para evitar que existan clases de operación.

### 12. Extensión de medios de pago
El sistema ya tiene `PagoPSE`, `PagoTarjeta` y `PagoBilleteraDigital`, todos implementando `MedioPago`. Si se agrega `PagoCripto implements MedioPago`, ¿qué principio se aplica principalmente?
A. Single Responsibility, porque se elimina la interfaz `MedioPago`.
B. Open/Closed, porque se agrega una nueva implementación sin modificar las existentes.
C. Liskov Substitution, porque se cambia una clase concreta por otra sin contrato.
D. Interface Segregation, porque todas las clases deben implementar más métodos.

### 13. Sustitución de cuentas
`CuentaAhorros` y `CuentaCorriente` extienden la clase abstracta `Cuenta`, que permite consultar el saldo y calcular el saldo restante después de un retiro. ¿Qué condición representa mejor el principio Liskov Substitution?
```java
public abstract class Cuenta { /* saldo y operaciones comunes */ }
public class CuentaAhorros extends Cuenta { }
public class CuentaCorriente extends Cuenta { }
```
A. Una referencia de tipo `Cuenta` debe poder utilizar una `CuentaAhorros` o una `CuentaCorriente` sin romper el comportamiento esperado.
B. Cada subclase debe eliminar los métodos heredados para diferenciarse de la clase padre.
C. `CuentaAhorros` debe implementar obligatoriamente una interfaz no relacionada con `Cuenta`.
D. Una variable `Cuenta` solo puede almacenar objetos creados exactamente con `new Cuenta()`.

### 14. Interfaz `MedioPago`
La interfaz `MedioPago` declara únicamente `cobrar(double)`, y las clases `PagoPSE`, `PagoTarjeta` y `PagoBilleteraDigital` implementan ese método. ¿Qué ventaja SOLID se observa?
```java
public interface MedioPago {
    void cobrar(double monto);
}
```
A. Las implementaciones dependen de un contrato pequeño y específico para realizar cobros.
B. La interfaz obliga a cada medio de pago a implementar métodos de facturación y notificación.
C. La interfaz elimina la necesidad de que existan clases concretas.
D. La interfaz hace que todos los medios de pago compartan automáticamente sus atributos.

### 15. Segregación de interfaces en notificadores
El proyecto define `NotificadorEmail` con `enviarEmail(...)` y `NotificadorSMS` con `enviarSMS(...)`, en lugar de una interfaz única con ambos métodos. ¿Qué principio refleja principalmente esta decisión?
```java
public interface NotificadorEmail {
    void enviarEmail(String destinatario, String mensaje);
}
public interface NotificadorSMS {
    void enviarSMS(String numero, String mensaje);
}
```
A. Interface Segregation, porque cada cliente depende solo del método de notificación que necesita.
B. Open/Closed, porque se prohíbe agregar nuevos tipos de notificación.
C. Liskov Substitution, porque email y SMS tienen exactamente los mismos atributos.
D. Single Responsibility, porque una interfaz puede tener un único atributo.

### 16. Dependencia de `Ejecucion`
Considere el método `procesarCobro(MedioPago medioPago, double monto)`, que invoca `medioPago.cobrar(monto)`. ¿Qué decisión favorece el principio Dependency Inversion?
A. Recibir `MedioPago` permite que `Ejecucion` dependa de una abstracción y no de una clase concreta.
B. Crear dentro del método siempre un objeto `new PagoTarjeta()` para controlar el flujo.
C. Usar una cadena con valores como `"PSE"` y `"TARJETA"` en lugar de la interfaz.
D. Copiar el código de cobro de cada medio dentro de `Ejecucion`.

### 17. Cambio en el cálculo de facturas
Si cambia la fórmula para calcular el total de una factura, ¿qué modificación está más alineada con Single Responsibility en el diseño actual?
```java
public class Factura {
    private double subtotal;
    private double impuesto;
}
public class FacturaOperacion {
    public double calcularTotal(Factura factura) { /* ... */ }
}
```
A. Cambiar `FacturaOperacion`, que concentra el cálculo, sin modificar la clase `Factura` que representa los datos.
B. Agregar la fórmula dentro de cada getter de `Factura`.
C. Cambiar `Main` para que conozca todos los atributos internos de `Factura`.
D. Mover los métodos de pago a `Factura` para centralizar todas las operaciones.

### 18. Nueva implementación de notificación
Se requiere agregar notificaciones por WhatsApp. ¿Qué alternativa respeta mejor Open/Closed y la segregación de interfaces?
```java
public interface NotificadorEmail { void enviarEmail(String destino, String mensaje); }
public interface NotificadorSMS { void enviarSMS(String destino, String mensaje); }
```
A. Crear una interfaz `NotificadorWhatsApp` con `enviarWhatsApp(...)` y una clase que la implemente, sin agregar métodos innecesarios a las interfaces existentes.
B. Agregar `enviarWhatsApp(...)` a `NotificadorEmail` y `NotificadorSMS`, aunque sus clientes no lo necesiten.
C. Modificar `ClienteEmail` para que también procese pagos por WhatsApp.
D. Reemplazar todas las interfaces por una clase con muchos métodos públicos.

### 19. Abstracción de operaciones de cuenta
¿Qué beneficio aporta que `CuentaBancaria` implemente `CuentaOperacion` en lugar de que el código cliente invoque únicamente una clase concreta?
```java
CuentaOperacion cuenta = new CuentaBancaria();
cuenta.retirar(100);
```
A. El cliente puede trabajar contra el contrato de operaciones y sustituir la implementación por otra compatible.
B. La interfaz permite acceder directamente a los atributos privados de `CuentaBancaria`.
C. El uso de la interfaz elimina la necesidad de validar cualquier operación.
D. La clase queda obligada a heredar de todas las cuentas existentes.

### 20. Evaluación conjunta de SOLID
¿Cuál combinación describe mejor el diseño?
```java
public void procesarCobro(MedioPago medioPago, double monto) {
    medioPago.cobrar(monto);
}
```
A. `MedioPago` abstrae el cobro, `Ejecucion` depende de esa abstracción y cada pago concreto implementa su propio comportamiento.
B. `Ejecucion` debe conocer y crear cada medio de pago para cumplir Dependency Inversion.
C. Todas las responsabilidades deben concentrarse en `Main` para evitar dependencias entre clases.
D. Las interfaces deben declarar todos los métodos posibles para evitar crear nuevas interfaces.

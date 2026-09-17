 # Examen — Ingeniería de Requerimientos

**Nombre y apellido:** ____________________________________  
**Fecha:** ____________________  
**Puntaje:** 20 puntos (1 punto por pregunta)

## Preguntas

### 1. Niveles de requisitos

Una universidad establece como objetivo aumentar en un 20 % la cantidad de inscripciones en línea durante el próximo semestre. Luego, los estudiantes solicitan poder seleccionar materias y recibir una confirmación. ¿Cómo se clasifican correctamente esas dos expresiones?

A. La primera es un requisito de software y la segunda una regla de negocio.
B. La primera es un objetivo de negocio y la segunda un requisito de usuario.
C. La primera es un requisito de usuario y la segunda un requisito de sistema.
D. Ambas son requisitos de software porque serán implementadas por el sistema.

### 2. Interfaces y contrato en Java

Considere la declaración:

```java
public class Cuenta implements CuentaOperacion {
```

```java
public interface CuentaOperacion {
    public void retirar(double valor);
    public void consignar(double valor);
}
```

Referencia: `requerimientos/src/main/java/com/example/Cuenta.java` y `CuentaOperacion.java`.

¿Qué garantiza el uso de la interfaz `CuentaOperacion` en este proyecto?

A. Que `Cuenta` pueda heredar de `TarjetaCredito`.
B. Que `Cuenta` deba implementar los métodos `retirar(double valor)` y `consignar(double valor)`.
C. Que `Cuenta` almacene el saldo como una constante inmutable.
D. Que `CuentaOperacion` pueda acceder directamente al atributo privado `saldo`.

### 3. Diagrama de contexto

En un diagrama de contexto para un sistema de inscripción universitaria, ¿cuál elemento debe quedar fuera de la caja que representa al sistema?

A. El módulo interno que valida los cupos de las materias.
B. La base de datos utilizada por el sistema.
C. El servicio interno que genera la confirmación de inscripción.
D. El sistema bancario que devuelve la confirmación de un pago.

### 4. Caso de uso

En un caso de uso de “Procesar pago”, el cliente está autenticado y la factura se encuentra pendiente antes de comenzar. ¿Qué representan principalmente esas condiciones?

A. Actores secundarios.
B. Flujos alternativos.
C. Precondiciones.
D. Postcondiciones de éxito.

### 5. Historia de usuario y criterios de aceptación

¿Cuál opción representa mejor una historia de usuario válida y orientada a valor?

A. Como sistema, quiero guardar usuarios en una tabla para usar PostgreSQL.
B. Como desarrollador, quiero crear una clase `Cuenta` para terminar el módulo.
C. Como estudiante, quiero consultar mis calificaciones para conocer mi avance académico.
D. Como base de datos, quiero recibir consultas para devolver resultados.

### 6. Flujo del menú en `Main`

En el programa principal, si el usuario ingresa la opción `3` en el menú, según el código actual ¿qué ocurre exactamente?

```java
int opcion = 0;
while(opcion != 3){
    System.out.println("Menu: 1. Retirar. 2. Consignar 3. Salir");
    opcion = scanner.nextInt();
    if(opcion==1){
        System.out.println("Cuanto quieres retirar");
        double retirar = scanner.nextDouble();
        cuenta.retirar(retirar);
    }
    if(opcion==2){
        System.out.println("Cuanto quieres consignar");
        double consignar = scanner.nextDouble();
        cuenta.consignar(consignar);
    }
    System.out.println("Tienes en tu cuenta: "+cuenta.getSaldo());
}
```

Referencia: `requerimientos/src/main/java/com/example/Main.java`.

A. El programa sale inmediatamente sin imprimir el saldo final.
B. El programa intenta retirar 3 pesos del saldo.
C. El programa intenta consignar 3 pesos al saldo.
D. El ciclo termina, pero se imprime una última vez el saldo en esa misma iteración.

### 7. Interfaces en Java

Considere la declaración:

```java
public class Cuenta implements CuentaOperacion {
```

```java
@Override
public void retirar(double valor) {
    saldo = saldo - valor;
}

@Override
public void consignar(double valor) {
    saldo = saldo + valor;
}
```

Referencia: `requerimientos/src/main/java/com/example/Cuenta.java` y `CuentaOperacion.java`.

¿Cuál afirmación es correcta respecto del código entregado?

A. `CuentaOperacion` hereda de `Cuenta` y por eso puede crear objetos de `Cuenta`.
B. `Cuenta` está obligada a implementar los métodos declarados en `CuentaOperacion`.
C. `Cuenta` solo puede usar `retirar()` y `consignar()` desde dentro de la interfaz.
D. La interfaz puede almacenar directamente el atributo privado `saldo` de `Cuenta`.

### 8. Encapsulamiento y comportamiento

Un objeto `Cuenta` tiene `saldo = 1000`. Se ejecutan, en este orden:

```java
cuenta.retirar(250);
cuenta.consignar(100);
```

```java
private double saldo;

public void retirar(double valor) {
    saldo = saldo - valor;
}

public void consignar(double valor) {
    saldo = saldo + valor;
}
```

Referencia: `requerimientos/src/main/java/com/example/Cuenta.java`.

¿Cuál es el saldo final y qué característica del código permite modificarlo?

A. `850`; el saldo se modifica mediante métodos públicos que encapsulan el atributo privado.
B. `1150`; el saldo solo puede aumentar porque `CuentaOperacion` no permite retiros.
C. `750`; el atributo privado impide que los métodos de la misma clase lo modifiquen.
D. `1000`; los métodos solo declaran operaciones, pero no cambian el estado.

### 9. Análisis del menú de `Main`

En el programa `Main`, el usuario ingresa la opción `3` en el menu 1. retirar, 2. consignar, 3. salir Según el código actual, ¿qué sucede?
```java
int opcion = 0;
while(opcion != 3){
    System.out.println("Menu: 1. Retirar. 2. Consignar 3. Salir");
    opcion = scanner.nextInt();
    if(opcion==1){
        System.out.println("Cuanto quieres retirar");
        double retirar = scanner.nextDouble();
        cuenta.retirar(retirar);
    }
    if(opcion==2){
        System.out.println("Cuanto quieres consignar");
        double consignar = scanner.nextDouble();
        cuenta.consignar(consignar);
    }
    System.out.println("Tienes en tu cuenta: "+cuenta.getSaldo());
}
```
Referencia: `requerimientos/src/main/java/com/example/Main.java`.

A. El programa sale inmediatamente y muestra siempre el saldo antes de terminar.
B. El programa intenta retirar 3 pesos del saldo.
C. El programa intenta consignar 3 pesos al saldo.
D. El ciclo termina, pero igual se imprime el saldo una vez más en esa iteración.

### 10. Trazabilidad y diseño

Se necesita agregar al sistema el requisito: “Una cuenta corriente puede permitir un sobregiro máximo y una tarjeta de crédito puede pagar consumos liberando cupo”. ¿Cuál cambio representa mejor una evolución coherente al programa?

```java
public interface CuentaOperacion {
    public void retirar(double valor);
    public void consignar(double valor);
}

public interface TarjetaCreditoOperacion {
    public void pagar(double valor);
    public void liberarCupo(double valor);
}
```

Referencia: `requerimientos/src/main/java/com/example/CuentaOperacion.java` y `TarjetaCreditoOperacion.java`.

A. Agregar todos los métodos como código dentro de `Main` y eliminar las interfaces.
B. Colocar los métodos de tarjeta dentro de `Cuenta`, porque ambas manejan dinero.
C. Mantener `CuentaOperacion` para operaciones de cuenta y hacer que `TarjetaCredito` implemente `TarjetaCreditoOperacion`, agregando allí el comportamiento correspondiente.
D. Hacer públicos los atributos privados de `Cuenta` y `TarjetaCredito` para facilitar el acceso.

### 11. Estado inicial de una cuenta

Si se crea una cuenta con `new Cuenta()` y no se invoca `setSaldo`, ¿cuál es el valor que devuelve `getSaldo()` según Java?

```java
private double saldo;

public double getSaldo() {
    return saldo;
}
```

Referencia: `requerimientos/src/main/java/com/example/Cuenta.java`.

A. `null`, porque el saldo no fue inicializado.
B. `0.0`, porque los atributos numéricos de instancia reciben ese valor por defecto.
C. `NaN`, porque no existe una operación matemática inicial.
D. Se produce una excepción por falta de constructor.

### 12. Retiro sin validación

Una cuenta tiene saldo `100`. Se ejecuta `cuenta.retirar(150)`. ¿Qué sucede con el estado de la cuenta?

```java
public void retirar(double valor) {
    saldo = saldo - valor;
}
```

Referencia: `requerimientos/src/main/java/com/example/Cuenta.java`.

A. El retiro se rechaza y el saldo permanece en `100`.
B. Se lanza una excepción porque el saldo es insuficiente.
C. El saldo queda en `-50`, porque el método resta el valor sin validar fondos.
D. El saldo queda en `150`, porque retirar aumenta el saldo.

### 13. Identificador de la cuenta

¿Qué secuencia permite asignar el identificador `"C-10"` a una cuenta y luego consultarlo?

```java
public String getIdentificador() {
    return identificador;
}

public void setIdentificador(String identificador) {
    this.identificador = identificador;
}
```

Referencia: `requerimientos/src/main/java/com/example/Cuenta.java`.

A. `cuenta.setIdentificador("C-10");` y `cuenta.getIdentificador();`
B. `cuenta.getIdentificador("C-10");` y `cuenta.setIdentificador();`
C. `cuenta.identificador = "C-10";` y `cuenta.identificador;`
D. `Cuenta.setIdentificador("C-10");` y `Cuenta.getIdentificador();`

### 14. Encapsulamiento de atributos

Según la clase `Cuenta`, ¿cuál afirmación describe correctamente el acceso a `saldo`?

```java
private double saldo;

public double getSaldo() {
    return saldo;
}

public void setSaldo(double saldo) {
    this.saldo = saldo;
}
```

Referencia: `requerimientos/src/main/java/com/example/Cuenta.java`.

A. Es `public` y cualquier clase puede modificarlo directamente.
B. Es `protected` y solo las subclases pueden consultarlo.
C. Es `private`, pero la clase ofrece `getSaldo()` y `setSaldo()` para consultarlo y modificarlo.
D. Es `final`, por lo que no puede cambiar después de crear la cuenta.

### 15. Operaciones de `Calculadora`

¿Cuál es el resultado de ejecutar `new Calculadora().resta(22, 12)`?

```java
public double resta(double a, double b){
    return a - b;
}
```

Referencia: `requerimientos/src/main/java/com/example/Calculadora.java`.

A. `10.0`
B. `34.0`
C. `-10.0`
D. `0.0`

### 16. Separación de responsabilidades

¿Qué responsabilidad tiene actualmente la clase `Calculadora` en el proyecto?

```java
public double suma(double a, double b){
    return a + b;
}

public double resta(double a, double b){
    return a - b;
}
```

Referencia: `requerimientos/src/main/java/com/example/Calculadora.java`.

A. Administrar el saldo y el identificador de una cuenta.
B. Ejecutar el menú interactivo y leer opciones del teclado.
C. Implementar los contratos de `CuentaOperacion` y `TarjetaCreditoOperacion`.
D. Realizar operaciones básicas de suma y resta sobre valores recibidos.

### 17. Estado de `TarjetaCredito`

Respecto de la clase `TarjetaCredito` entregada, ¿qué puede afirmarse?

```java
public class TarjetaCredito {
    private String identificador;
    private double cupo;
}
```

Referencia: `requerimientos/src/main/java/com/example/TarjetaCredito.java`.

A. Implementa `TarjetaCreditoOperacion` y define `pagar` y `liberarCupo`.
B. Tiene los atributos privados `identificador` y `cupo`, pero no implementa operaciones de pago.
C. Hereda de `Cuenta` y reutiliza automáticamente su saldo.
D. Contiene métodos públicos para aumentar y disminuir el cupo.

### 18. Contrato de la interfaz de tarjeta

¿Qué métodos declara `TarjetaCreditoOperacion`?

```java
public interface TarjetaCreditoOperacion {
    public void pagar(double valor);
    public void liberarCupo(double valor);
}
```

Referencia: `requerimientos/src/main/java/com/example/TarjetaCreditoOperacion.java`.

A. `retirar(double)` y `consignar(double)`.
B. `suma(double, double)` y `resta(double, double)`.
C. `pagar(double)` y `liberarCupo(double)`.
D. `getCupo()` y `setCupo(double)`.

### 19. Entrada inicial en `Main`

En el programa `Main`, ¿qué valor se solicita antes de crear el objeto `Cuenta`?

```java
System.out.println("Por favor ingresa el identificador de la cuenta");
String identificador = scanner.nextLine();
System.out.println("Por favor ingrese el saldo de la cuenta");
double saldo = scanner.nextDouble();
Cuenta cuenta = new Cuenta();
```

Referencia: `requerimientos/src/main/java/com/example/Main.java`.

A. El valor de una compra con tarjeta.
B. El resultado de una suma.
C. El identificador de la cuenta y luego su saldo.
D. El cupo máximo de la tarjeta.

### 20. Comportamiento ante una opción distinta de 1, 2 o 3

Si en el menú de `Main` el usuario ingresa la opción `4`, ¿qué ocurre según el código actual?

```java
opcion = scanner.nextInt();
if(opcion==1){
    cuenta.retirar(retirar);
}
if(opcion==2){
    cuenta.consignar(consignar);
}
System.out.println("Tienes en tu cuenta: "+cuenta.getSaldo());
```

Referencia: `requerimientos/src/main/java/com/example/Main.java`.

A. Se retiran automáticamente 4 unidades del saldo.
B. Se consignan automáticamente 4 unidades del saldo.
C. Se lanza una excepción porque no existe la opción 4.
D. No se ejecuta ninguna operación de cuenta, se imprime el saldo y el ciclo continúa.

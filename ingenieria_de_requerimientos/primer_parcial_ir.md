 # Examen — Ingeniería de Requerimientos

**Nombre y apellido:** ____________________________________  
**Fecha:** ____________________  
**Puntaje:** 10 puntos (1 punto por pregunta)

## Instrucciones

- Seleccione **una única respuesta correcta** por pregunta.
- Todas las preguntas tienen seis opciones posibles: `A`, `B`, `C`, `D`, `E` y `F`.
- En las preguntas sobre código, considere únicamente el comportamiento mostrado en los archivos Java del proyecto `requerimientos`.
- Justifique brevemente su elección cuando el docente lo solicite.

## Preguntas

### 1. Niveles de requisitos

Una universidad establece como objetivo aumentar en un 20 % la cantidad de inscripciones en línea durante el próximo semestre. Luego, los estudiantes solicitan poder seleccionar materias y recibir una confirmación. ¿Cómo se clasifican correctamente esas dos expresiones?

A. La primera es un requisito de software y la segunda una regla de negocio.
B. La primera es un objetivo de negocio y la segunda un requisito de usuario.
C. La primera es un requisito de usuario y la segunda un requisito de sistema.
D. Ambas son requisitos de software porque serán implementadas por el sistema.
E. La primera es un caso de uso y la segunda un criterio de aceptación.
F. Ambas son reglas de negocio porque describen restricciones institucionales.

### 2. Interfaces y contrato en Java

Considere la declaración:

```java
public class Cuenta implements CuentaOperacion {
```

¿Qué garantiza el uso de la interfaz `CuentaOperacion` en este proyecto?

A. Que `Cuenta` pueda heredar de `TarjetaCredito`.
B. Que `Cuenta` deba implementar los métodos `retirar(double valor)` y `consignar(double valor)`.
C. Que `Cuenta` almacene el saldo como una constante inmutable.
D. Que `CuentaOperacion` pueda acceder directamente al atributo privado `saldo`.
E. Que `Cuenta` sea una clase abstracta y no pueda instanciarse.
F. Que `Main` no pueda crear objetos de tipo `Cuenta`.

### 3. Diagrama de contexto

En un diagrama de contexto para un sistema de inscripción universitaria, ¿cuál elemento debe quedar fuera de la caja que representa al sistema?

A. El módulo interno que valida los cupos de las materias.
B. La base de datos utilizada por el sistema.
C. El servicio interno que genera la confirmación de inscripción.
D. El sistema bancario que devuelve la confirmación de un pago.
E. La regla que impide inscribirse a una materia sin cupos.
F. La pantalla interna donde el estudiante selecciona materias.

### 4. Caso de uso

En un caso de uso de “Procesar pago”, el cliente está autenticado y la factura se encuentra pendiente antes de comenzar. ¿Qué representan principalmente esas condiciones?

A. Actores secundarios.
B. Flujos alternativos.
C. Precondiciones.
D. Postcondiciones de éxito.
E. Reglas de negocio.
F. Criterios de aceptación.

### 5. Historia de usuario y criterios de aceptación

¿Cuál opción representa mejor una historia de usuario válida y orientada a valor?

A. Como sistema, quiero guardar usuarios en una tabla para usar PostgreSQL.
B. Como desarrollador, quiero crear una clase `Cuenta` para terminar el módulo.
C. Como estudiante, quiero consultar mis calificaciones para conocer mi avance académico.
D. Como base de datos, quiero recibir consultas para devolver resultados.
E. Como administrador, quiero que el sistema sea moderno y fácil de usar.
F. Como aplicación, quiero ejecutar el método `getSaldo()` cuando se presione un botón.

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

A. El programa sale inmediatamente sin imprimir el saldo final.
B. El programa intenta retirar 3 pesos del saldo.
C. El programa intenta consignar 3 pesos al saldo.
D. El ciclo termina, pero se imprime una última vez el saldo en esa misma iteración.
E. Se produce una excepción porque la opción `3` no está contemplada en ningún `if`.
F. El ciclo continúa indefinidamente porque `opcion` nunca se actualiza.

### 7. Interfaces en Java

Considere la declaración:

```java
public class Cuenta implements CuentaOperacion {
```

¿Cuál afirmación es correcta respecto del código entregado?

A. `CuentaOperacion` hereda de `Cuenta` y por eso puede crear objetos de `Cuenta`.
B. `Cuenta` está obligada a implementar los métodos declarados en `CuentaOperacion`.
C. `Cuenta` solo puede usar `retirar()` y `consignar()` desde dentro de la interfaz.
D. La interfaz puede almacenar directamente el atributo privado `saldo` de `Cuenta`.
E. `Cuenta` se convierte automáticamente en una clase abstracta.
F. `CuentaOperacion` solo puede ser implementada por clases que también hereden de `TarjetaCredito`.

### 8. Encapsulamiento y comportamiento

Un objeto `Cuenta` tiene `saldo = 1000`. Se ejecutan, en este orden:

```java
cuenta.retirar(250);
cuenta.consignar(100);
```

¿Cuál es el saldo final y qué característica del código permite modificarlo?

A. `850`; el saldo se modifica mediante métodos públicos que encapsulan el atributo privado.
B. `1150`; el saldo solo puede aumentar porque `CuentaOperacion` no permite retiros.
C. `750`; el atributo privado impide que los métodos de la misma clase lo modifiquen.
D. `1000`; los métodos solo declaran operaciones, pero no cambian el estado.
E. `850`; únicamente el método `setSaldo()` puede modificar el saldo.
F. `750`; la interfaz reemplaza la implementación de los métodos de `Cuenta`.

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
A. El programa sale inmediatamente y muestra siempre el saldo antes de terminar.
B. El programa intenta retirar 3 pesos del saldo.
C. El programa intenta consignar 3 pesos al saldo.
D. El ciclo termina, pero igual se imprime el saldo una vez más en esa iteración.
E. Se produce una excepción porque la opción `3` no está contemplada en ningún `if`.
F. El ciclo continúa indefinidamente porque `opcion` nunca se actualiza.

### 10. Trazabilidad y diseño

Se necesita agregar al sistema el requisito: “Una cuenta corriente puede permitir un sobregiro máximo y una tarjeta de crédito puede pagar consumos liberando cupo”. ¿Cuál cambio representa mejor una evolución coherente al programa?

A. Agregar todos los métodos como código dentro de `Main` y eliminar las interfaces.
B. Colocar los métodos de tarjeta dentro de `Cuenta`, porque ambas manejan dinero.
C. Mantener `CuentaOperacion` para operaciones de cuenta y hacer que `TarjetaCredito` implemente `TarjetaCreditoOperacion`, agregando allí el comportamiento correspondiente.
D. Hacer públicos los atributos privados de `Cuenta` y `TarjetaCredito` para facilitar el acceso.
E. Reemplazar todas las clases por métodos estáticos en `Calculadora`.
F. Agregar únicamente comentarios en las interfaces, porque los requisitos no deben reflejarse en el código.

#### Estructura completa de un caso de uso

```
ID: CU-03
Nombre: Realizar transferencia bancaria
Actor primario: Cliente autenticado
Actores secundarios: Sistema de notificaciones, Core bancario
Precondiciones:
  - El cliente está autenticado en el sistema
  - La cuenta origen tiene saldo disponible
Postcondiciones (éxito):
  - El saldo de la cuenta origen disminuye en el monto
  - El saldo de la cuenta destino aumenta en el monto
  - Se registra la operación en el historial de ambas cuentas
  - Se envía notificación al cliente

Flujo principal:
  1. El cliente selecciona "Nueva transferencia"
  2. El cliente ingresa el número de cuenta destino y el monto
  3. El sistema valida los datos ingresados
  4. El sistema muestra un resumen para confirmación
  5. El cliente confirma la operación
  6. El sistema procesa la transferencia
  7. El sistema muestra el comprobante

Flujos alternativos:
  3a. Número de cuenta destino inexistente:
      3a.1 El sistema informa "Cuenta destino no encontrada"
      3a.2 El cliente puede corregir el dato (vuelve al paso 2) o cancelar
  5a. El cliente cancela la confirmación:
      5a.1 El sistema descarta la operación
      5a.2 El caso de uso termina sin cambios

Excepciones:
  3b. Saldo insuficiente:
      3b.1 El sistema informa "Saldo insuficiente para realizar la operación"
      3b.2 El caso de uso termina
  6a. Fallo en el servicio de transferencia:
      6a.1 El sistema revierte cualquier cambio parcial (rollback)
      6a.2 El sistema informa "No fue posible completar la transferencia. Intente más tarde"
      6a.3 El sistema registra el error internamente

Reglas de negocio referenciadas:
  - RN-07: El monto máximo de transferencia diaria es $100.000
  - RN-12: No se permiten transferencias a cuentas bloqueadas
```

#### Historias de usuario (User Stories)

Las historias de usuario describen el **valor** que un tipo de usuario obtiene al realizar algo. Son el vehículo de comunicación en el desarrollo ágil, no un documento formal.

**Formato estándar:**
> **Como** [rol del usuario], **quiero** [acción o funcionalidad], **para** [beneficio o valor obtenido].

**Criterios para una buena historia (INVEST):**
| Criterio | Significado |
|---|---|
| **I**ndependiente | No depende de otra historia para ser implementada o probada |
| **N**egociable | Es un punto de partida para una conversación, no un contrato fijo |
| **V**aliosa | Entrega valor real a un usuario o al negocio |
| **E**stimable | El equipo puede estimar el esfuerzo |
| **S**mall (pequeña) | Se puede implementar en una iteración |
| **T**estable | Tiene criterios claros de verificación |

**Ejemplos — bien vs. mal escritas:**

❌ Historia mal escrita:
> Como sistema, quiero guardar los datos del usuario en la base de datos.

Problemas: El actor es el sistema (no un usuario), no expresa valor, es técnica.

✅ Historia bien escrita:
> Como estudiante, quiero buscar libros por título o autor, para encontrar rápidamente el material que necesito para mis cursos.

#### Criterios de aceptación (CA)

Los CA son condiciones verificables que deben cumplirse para que la historia esté "terminada". Son el contrato entre el dueño del producto y el equipo.

**Formato Given/When/Then (Gherkin):**
```gherkin
# Historia: Buscar libros

Scenario: Búsqueda exitosa por título
  Given que existen libros con "Programación" en el título
  When el estudiante busca "Programación"
  Then el sistema muestra una lista con todos los libros que contienen "Programación"
  And cada resultado muestra: título, autor, disponibilidad

Scenario: Búsqueda sin resultados
  Given que no existen libros con "XYZ123" en el título o autor
  When el estudiante busca "XYZ123"
  Then el sistema muestra el mensaje "No se encontraron resultados para su búsqueda"

Scenario: Búsqueda con término vacío
  Given que el estudiante está en la pantalla de búsqueda
  When intenta buscar sin ingresar texto
  Then el sistema muestra "Por favor ingrese un término de búsqueda"
  And no se realiza ninguna consulta
```

**Buenas prácticas para CA:**
- Escribirlos **antes** de programar (guía la implementación y las pruebas).
- Ser específicos y medibles, no subjetivos ("rápido" es subjetivo; "en menos de 2 segundos" es medible).
- Cubrir: camino feliz, flujos alternativos y excepciones.
- Un CA = un escenario = una prueba de aceptación.

#### Reglas de negocio

Las **reglas de negocio** son restricciones o políticas del dominio que el sistema debe respetar, independientemente de cómo se implemente.

Ejemplos:
- RN-01: Un estudiante puede tener como máximo 3 préstamos de libros activos simultáneamente.
- RN-02: Un libro solo puede renovarse una vez por préstamo.
- RN-03: La renovación solo es posible si no hay otro estudiante con reserva activa del mismo libro.

---

#### Ejercicio 1: Redactar casos de uso completos

> **Sistema de pagos de servicios publicos:** Las entidades que intervienen son: Cuenta, Cuenta de Ahorros, Cuenta Corriente, Factura, Cliente y Pago. Construir el CRUD para cada entidad y las funcionalidades de procesarPago, obtenerSaldoCuenta, obtenerPagosPorCliente, ObtenerFacturasPorCliente.

Redactar **los casos de uso completos** de las funcionalidades:
- Actores primarios y secundarios.
- Precondiciones y postcondiciones.
- Flujo principal paso a paso.
- Al menos 2 flujos alternativos.
- Al menos 2 excepciones.

#### Ejercicio 2: Desarrollo en código aplicando pilares POO (20 min)

Tomando los casos de uso redactados en el ejercicio anterior, se debe implementar un prototipo en cualquier lenguaje de programacion que use explícitamente los 4 pilares:

1. **Abstracción** 
2. **Encapsulamiento** 
3. **Herencia**
4. **Polimorfismo**

**Entregable mínimo del ejercicio:**
- Diagrama de Clases.
- Casos de uso.
- Historias de Usuario en Jira.
- Código compilable y funcionando en el repositorio de talleres.
# Tercer corte: CRUD y facturación en Tienda Virtual

## 1. Comprender la arquitectura actual

Una solicitud HTTP atraviesa varias responsabilidades. Mantenerlas separadas reduce el acoplamiento y hace posible probar cada parte de manera independiente.

| Capa | Responsabilidad | Ubicación actual |
|---|---|---|
| Controlador REST | Recibir solicitudes HTTP, extraer parámetros y cuerpo, validar la entrada y construir respuestas HTTP. No debe contener reglas de negocio complejas. | [`controllers`](tiendavirtual/src/main/java/com/example/tiendavirtual/controllers) |
| DTO | Definir los datos que la API acepta o entrega. Evita exponer directamente las entidades de persistencia. | [`dtos`](tiendavirtual/src/main/java/com/example/tiendavirtual/dtos) |
| Mapper | Convertir entre DTO, modelo y entidad. Debe hacer transformaciones explícitas y previsibles. | [`mappers`](tiendavirtual/src/main/java/com/example/tiendavirtual/mappers) |
| Servicio | Coordinar el caso de uso y aplicar reglas del negocio, como existencia, coherencia, stock y transacciones. | [`services`](tiendavirtual/src/main/java/com/example/tiendavirtual/services) |
| Repositorio de aplicación | Expresar las operaciones de persistencia que necesita el servicio, sin exponer detalles innecesarios de JPA. | [`repositories/impl`](tiendavirtual/src/main/java/com/example/tiendavirtual/repositories/impl) y [`repositories/interf`](tiendavirtual/src/main/java/com/example/tiendavirtual/repositories/interf) |
| Repositorio Spring Data JPA | Ejecutar operaciones CRUD y consultas sobre la base de datos. | Interfaces `*JpaRepository` del proyecto |
| Entidad JPA | Representar una tabla y sus relaciones en la base de datos. | [`entitites`](tiendavirtual/src/main/java/com/example/tiendavirtual/entitites) |
| Modelo de dominio | Representar los datos usados por la lógica de la aplicación sin depender de anotaciones JPA. | [`models`](tiendavirtual/src/main/java/com/example/tiendavirtual/models) |

El recorrido esperado es:

1. El controlador recibe el request y obtiene los datos de la ruta o el cuerpo.
2. El DTO limita y valida la forma de entrada.
3. El mapper convierte el DTO a un modelo, si la aplicación mantiene ese modelo separado.
4. El servicio verifica reglas y coordina el caso de uso.
5. El repositorio consulta o modifica la persistencia.
6. El resultado vuelve por las capas, se transforma al DTO de respuesta y se traduce a un estado HTTP.

En este repositorio, los controladores llaman a interfaces de servicio; los servicios convierten modelos y entidades mediante mappers; y los repositorios de aplicación delegan en interfaces `JpaRepository`. Para las operaciones nuevas, se debe conservar el mismo flujo y evitar que el controlador manipule directamente entidades o repositorios JPA.

## 2. Qué significa CRUD y qué existe hoy

CRUD representa las cuatro operaciones básicas de persistencia:

| Operación | Significado | HTTP habitual |
|---|---|---|
| Create | Crear un recurso nuevo. | `POST` |
| Read | Consultar uno o varios recursos. | `GET` |
| Update | Modificar un recurso existente. | `PUT` o `PATCH` |
| Delete | Eliminar o desactivar un recurso. | `DELETE` |

En [`CustomerController`](tiendavirtual/src/main/java/com/example/tiendavirtual/controllers/CustomerController.java) y [`ProductController`](tiendavirtual/src/main/java/com/example/tiendavirtual/controllers/ProductController.java) están implementados `GET` de colección, `GET` de búsqueda y `POST`. Los servicios y repositorios de aplicación también solo declaran consulta y creación. Los identificadores funcionales para las búsquedas actuales son `identification` para Customer y `code` para Product; las entidades además tienen un UUID interno.

### Observaciones que condicionan la siguiente etapa

- Los DTO de respuesta no contienen todos los datos de identidad: `CustomerResponseDto` omite email y UUID, y `ProductResponseDto` omite code y UUID. Una respuesta de recurso normalmente debe incluir un identificador estable para que el cliente pueda volver a consultarlo o referenciarlo.
- Las búsquedas extraen el `Optional` con `.get()` en los repositorios de aplicación. Si el registro no existe, la API no tiene una respuesta 404 explícita definida en el código actual.
- Los DTO no declaran restricciones de validación y los controladores no usan `@Valid`, aunque el proyecto incluye la dependencia de Validation.
- Product guarda el precio en `Double`. Para dinero y cálculos de factura se debe usar `BigDecimal` en el dominio y un tipo decimal adecuado en la base de datos.
- No se observan restricciones de unicidad para la identificación del cliente ni para el código del producto. Las reglas importantes deben protegerse en más de una capa, incluyendo la base de datos.
- La única prueba actual es `contextLoads()`. No verifica el comportamiento del CRUD ni las reglas de negocio.

Estas observaciones son oportunidades de aprendizaje: antes de ampliar un CRUD, conviene definir qué identifica un recurso, cómo se informa que no existe y qué datos son válidos.

## 3. Diseño REST de update y delete

### 3.1 Identificadores y recursos

Una URL representa un recurso o una colección. Para una API uniforme se recomienda elegir una convención de nombres y conservarla en todos los recursos. Por ejemplo:

| Acción propuesta | Customer | Product |
|---|---|---|
| Listar | `GET /api/customers` | `GET /api/products` |
| Consultar uno | `GET /api/customers/{id}` | `GET /api/products/{id}` |
| Crear | `POST /api/customers` | `POST /api/products` |
| Reemplazar | `PUT /api/customers/{id}` | `PUT /api/products/{id}` |
| Actualizar parcialmente | `PATCH /api/customers/{id}` | `PATCH /api/products/{id}` |
| Eliminar | `DELETE /api/customers/{id}` | `DELETE /api/products/{id}` |

El proyecto usa rutas singulares (`/api/customer` y `/api/product`) y búsquedas por atributos funcionales. Se puede mantener esa convención para no romper consumidores, o migrar a rutas plurales e ID UUID; lo importante en un ejercicio es documentar la decisión y usarla consistentemente. Si se usa un código o una identificación como clave de ruta, hay que decidir si ese dato se puede modificar: cambiarlo puede dificultar localizar el recurso después.

### 3.2 PUT frente a PATCH

- **PUT** expresa el reemplazo del estado editable del recurso. En un diseño simple, el cliente envía todos los campos que puede modificar. Si omite un campo, la API debe definir si se considera ausente, nulo o un valor inválido; no se debe dejar el comportamiento accidental.
- **PATCH** expresa una modificación parcial. Solo los campos presentes cambian; los campos omitidos permanecen iguales. Distinguir “no enviado” de “enviado como null” requiere un formato y una estrategia explícitos.
- Ambos deben identificar el recurso en la ruta y actualizar únicamente el registro que existe. Un update no debe crear silenciosamente otro registro.
- No se debe permitir cambiar desde el request campos controlados por el sistema, como UUID, fecha de creación o totales calculados. La lista de campos editables debe estar en el DTO de actualización.

Para enseñar primero el flujo, suele ser más claro implementar `PUT` con un DTO de actualización completo. `PATCH` puede abordarse después, cuando se explique la semántica de campos opcionales.

### 3.3 Flujo conceptual de actualización

1. Recibir el identificador de ruta y el DTO de actualización.
2. Validar formato y restricciones de entrada.
3. Buscar la entidad existente. Si no está, detener el caso de uso con un resultado “no encontrado”.
4. Aplicar únicamente campos permitidos, preservando el ID y cualquier atributo que no se pueda modificar.
5. Guardar la entidad existente y convertir el resultado a un DTO de respuesta.
6. Responder con `200 OK` y el recurso actualizado, o con `204 No Content` si se decide no devolver cuerpo.

Spring Data JPA expone operaciones de persistencia como `findById`, `save` y `delete`; el servicio debe decidir cuándo se usan y qué reglas deben cumplirse. `save` puede insertar o actualizar según la identidad de la entidad, por lo que la búsqueda previa y el mapeo sobre la entidad existente son esenciales para evitar inserciones accidentales o pérdida de campos.

### 3.4 Flujo conceptual de eliminación

1. Buscar el recurso y comprobar sus dependencias.
2. Si no existe, responder `404 Not Found`.
3. Si existe y su eliminación está permitida, eliminarlo o desactivarlo según la política del negocio.
4. Responder `204 No Content` si la operación tuvo éxito y no se devuelve cuerpo.

Se debe definir una política explícita para cada tipo de recurso:

- **Borrado físico:** la fila desaparece de la base de datos. Es sencillo, pero puede destruir información necesaria para auditoría o historial.
- **Borrado lógico:** se conserva la fila y se marca como inactiva, por ejemplo con un estado o una fecha de baja. Conserva trazabilidad, pero todas las consultas deben filtrar correctamente los registros inactivos.
- **Restricción por referencias:** no permitir borrar un cliente con facturas ni un producto ya facturado. Es adecuado cuando se debe conservar la integridad histórica.

Cuando exista facturación, no se debe elegir una cascada de borrado sin analizar su efecto. Borrar en cascada un cliente o producto podría eliminar facturas o detalles que deben conservarse. Para un sistema académico con historial, es preferible impedir el borrado físico de registros referenciados o enseñar una baja lógica; las facturas históricas deben permanecer consultables.

## 4. Responsabilidades a completar por capa

Para cada recurso, las operaciones nuevas atraviesan la misma arquitectura existente:

1. **DTO:** crear un DTO de actualización separado del de creación si las reglas o los campos editables son distintos. Añadir restricciones declarativas, por ejemplo obligatoriedad, longitud, formato, precio positivo y stock no negativo. La validación del request se activa en el controlador con `@Valid`.
2. **Mapper:** añadir una conversión que aplique el DTO sobre el modelo/entidad existente. Para update, no crear una entidad nueva sin ID y no sobrescribir valores que el cliente no puede modificar.
3. **Interfaz de servicio:** declarar operaciones de actualización y eliminación con parámetros y resultados claros. Las interfaces permiten que el controlador dependa del contrato y no de la implementación concreta.
4. **Servicio:** implementar reglas de existencia, modificaciones permitidas y política de eliminación. Cuando una operación coordina varias escrituras, delimitarla transaccionalmente con `@Transactional`.
5. **Interfaz de repositorio de aplicación:** exponer las operaciones de persistencia requeridas por el servicio con nombres del dominio.
6. **Adaptador de repositorio:** delegar en `JpaRepository`, convirtiendo resultados opcionales y gestionando el acceso a la base de datos.
7. **Controlador:** agregar el mapeo HTTP apropiado, transformar DTO/modelo y devolver el estado correcto.
8. **Manejo de errores:** convertir errores de forma consistente a HTTP mediante excepciones de dominio y un manejador global, por ejemplo con `@RestControllerAdvice`.
9. **Pruebas:** cubrir el comportamiento desde servicio y API, incluyendo escenarios válidos e inválidos.

El servicio es el lugar principal de las reglas del caso de uso. La validación de formato del request puede ocurrir en el borde de la API; las restricciones de integridad también deben reflejarse en la base de datos para protegerse frente a otros clientes o procesos.

## 5. Validación, errores y estados HTTP

Validar no significa confiar únicamente en que el formulario del cliente envíe datos correctos. La API debe validar todo request.

Ejemplos de reglas iniciales:

- Customer: nombre e identificación obligatorios, email con formato válido y longitudes razonables. Identificación única si la regla del negocio lo exige.
- Product: código y nombre obligatorios, código único, precio mayor o igual a cero (o estrictamente mayor que cero si así se define), stock entero no negativo.
- Update: verificar que el recurso exista y que una identificación/código nuevo no esté asignado a otro recurso.
- Factura en el modelo simplificado de este ejemplo: customer existente, lista no vacía de productos únicos, productos existentes y al menos una unidad disponible por producto.

Es útil distinguir **validación sintáctica** (el dato tiene formato permitido) de **validación semántica** (el dato tiene sentido dentro del negocio). Por ejemplo, que una cantidad sea un entero positivo es sintáctico; que exista stock suficiente es semántico y depende del estado actual de la base de datos.

| Situación | Estado HTTP usual |
|---|---|
| Creación exitosa | `201 Created` (idealmente con `Location` y representación) |
| Consulta o actualización exitosa con representación | `200 OK` |
| Eliminación exitosa sin cuerpo | `204 No Content` |
| Request inválido o violación de validación | `400 Bad Request` |
| No autenticado (si se implementa seguridad) | `401 Unauthorized` |
| Sin permiso | `403 Forbidden` |
| Recurso inexistente | `404 Not Found` |
| Conflicto, como código duplicado o transición no permitida | `409 Conflict` |
| Error inesperado del servidor | `500 Internal Server Error` |

Los mensajes de error deben ser comprensibles y no filtrar trazas internas, consultas SQL ni secretos. Una respuesta de error uniforme puede incluir código, mensaje, instante y detalles de validación.

## 6. Diseño del dominio de facturación

### 6.1 Relación directa entre Invoice y Product

En esta versión, una factura pertenece a un cliente y mantiene una colección de productos. Un producto puede aparecer en muchas facturas, por lo que la relación es muchos-a-muchos y se representa con `@ManyToMany` y una tabla de unión. No se crea una entidad `InvoiceItem`.

Esta simplificación implica que cada producto aparece como máximo una vez en cada factura y representa una unidad. La asociación no puede guardar cantidad, precio unitario histórico, descuento ni impuesto por producto. Si el negocio necesita cualquiera de esos datos por línea, se debe volver a una entidad asociativa como `InvoiceItem`; una lista directa de productos no es suficiente.

```mermaid
erDiagram
	CUSTOMER ||--o{ INVOICE : "realiza"
	INVOICE }o--|{ INVOICE_PRODUCT : "incluye"
	PRODUCT ||--o{ INVOICE_PRODUCT : "se asocia"
	CUSTOMER {
		UUID id PK
		string identification UK
		string name
		string email
	}
	INVOICE {
		UUID id PK
		string number UK
		datetime issued_at
		string status
		decimal subtotal
		decimal tax_total
		decimal total
		UUID customer_id FK
	}
	INVOICE_PRODUCT {
		UUID invoice_id PK, FK
		UUID product_id PK, FK
	}
	PRODUCT {
		UUID id PK
		string code UK
		string name
		decimal current_price
		integer stock
	}
```

Lectura de las cardinalidades:

- Un Customer puede tener cero o muchas Invoice; cada Invoice pertenece a exactamente un Customer.
- Una Invoice válida contiene uno o más Product mediante filas en `invoice_products`.
- Un Product puede aparecer en cero o muchas Invoice. Cada par factura-producto debe ser único.

En JPA, Invoice mantiene `List<ProductEntity>` con `@ManyToMany` y una `@JoinTable`; la relación con Customer sigue siendo `@ManyToOne`. No se debe configurar cascada `REMOVE` hacia Product, porque eliminar una factura no debe borrar el producto del catálogo.

### 6.2 Entidades y atributos recomendados

**Invoice** puede contener:

- Identificador interno UUID.
- Número de factura único y legible, si el ejercicio lo requiere.
- Cliente propietario.
- Fecha y hora de emisión.
- Estado del documento (por ejemplo, borrador, emitida, anulada), si el negocio contempla un ciclo de vida.
- Total calculado al momento de crear la factura.
- Una colección de productos asociados. En esta versión simplificada, cada producto cuenta como una unidad.

**Product** conserva su precio y stock actuales. La factura conserva el total calculado al crearla, pero la asociación directa no conserva el precio histórico individual ni el nombre/código que tenía cada producto en ese momento. La lista consultada puede mostrar los datos actuales del catálogo.

### 6.3 Alcance y conservación histórica

El total se guarda como una fotografía del importe al crear la factura; cambiar después el precio del catálogo no modifica ese total guardado. Sin embargo, como no hay una entidad de detalle, no es posible explicar exactamente qué precio se aplicó a cada producto ni reconstruir las líneas históricas. Este modelo sirve para un ejercicio académico acotado, no para una facturación que requiera trazabilidad detallada.

## 7. Reglas de cálculo y tipos monetarios

Los importes no deben representarse con `float` o `double`, porque su representación binaria puede introducir errores de redondeo. En Java se recomienda `BigDecimal`, construido desde una cadena decimal o desde datos decimales bien controlados, con escala y regla de redondeo definidas.

En el modelo directo, cada producto se factura como una unidad. Sin descuentos ni impuestos, el total inicial es la suma del precio vigente de cada producto seleccionado:

$$
T = \sum_{j=1}^{m} p_j
$$

Si se modelan impuestos y descuentos, deben definirse claramente la base de cálculo, la tasa, el orden de aplicación, la precisión intermedia y el momento del redondeo. No se deben inventar esas reglas en la capa del controlador. El cálculo pertenece al dominio o al servicio de facturación, en una política explícita y probada.

Ejemplo conceptual: si se seleccionan productos con precios de 12,50 y 8,25, el total inicial es 20,75. Cada producto representa una unidad; no hay cantidades ni importes por línea en este diseño.

También se deben validar límites: precio no negativo, total dentro de la precisión permitida por la columna decimal y moneda definida. El total se guarda al crear la factura; no se debe recalcular en consultas usando precios actuales del catálogo.

## 8. Caso de uso: crear una factura con varios productos

Una API puede recibir una solicitud similar a esta (estructura ilustrativa):

```json
{
  "customerId": "uuid-del-cliente",
  "productIds": [
	"uuid-del-producto-a",
	"uuid-del-producto-b"
  ]
}
```

El request no debería aceptar como confiables precios ni total enviados por el cliente. El servidor obtiene los productos del catálogo, valida disponibilidad y calcula el total. La factura guarda el total inicial, pero no una fotografía del precio individual de cada producto.

Flujo recomendado del servicio de aplicación:

1. Validar que el request tenga cliente y una lista de productos no vacía.
2. Buscar el cliente. Si no existe, rechazar la operación sin guardar nada.
3. Rechazar UUID de producto repetidos: cada producto solo puede aparecer una vez y cuenta como una unidad.
4. Buscar todos los productos. Si falta alguno, rechazar toda la operación.
5. Comprobar que los precios sean válidos y que cada producto tenga al menos una unidad disponible.
6. Asociar los productos a la factura y calcular el total con `BigDecimal`.
7. Descontar una unidad del stock de cada producto seleccionado.
8. Persistir la factura, las asociaciones y los cambios de stock como una sola unidad de trabajo.
9. Responder `201 Created` con el DTO de factura y los identificadores de los productos.

La anotación `@Transactional` en el servicio expresa que todas las escrituras pertenecen a una transacción: si falla una parte, la base de datos debe revertir la factura, las asociaciones y las modificaciones de stock para no dejar un estado parcial. Una transacción protege la atomicidad, pero no resuelve por sí sola todas las carreras concurrentes.

### Concurrencia de inventario

Dos solicitudes simultáneas podrían leer el mismo stock disponible y vender las mismas unidades. Para un primer ejercicio se puede identificar el riesgo; después se puede enseñar control de concurrencia optimista mediante `@Version`, bloqueo pesimista en la consulta o una actualización condicional de stock. La estrategia debe impedir que el stock quede negativo y producir un conflicto claro cuando otra transacción consumió las unidades primero.

### Cancelación, anulación y borrado de factura

Una factura emitida es un documento histórico. No se recomienda borrarla físicamente como si fuera un registro temporal. Si el alcance incluye cancelaciones, se debe modelar una transición de estado y definir cómo se revierten los movimientos de inventario y los efectos contables, dejando trazabilidad. Esa lógica requiere reglas propias y no debe implementarse como un `DELETE` genérico.

## 9. API sugerida para facturación

Una posible interfaz inicial es:

| Acción | Ruta propuesta | Resultado |
|---|---|---|
| Crear factura | `POST /api/invoices` | `201 Created` con número, fecha, cliente, UUID de productos y total |
| Consultar factura | `GET /api/invoices/{id}` | `200 OK` o `404 Not Found` |
| Listar facturas de cliente | `GET /api/customers/{id}/invoices` | `200 OK` con lista paginada o acotada |

La API debe exponer DTO de request y response propios. El request contiene el identificador del cliente y los UUID de los productos; la respuesta puede incluir identidad del cliente, número, fecha, UUID de productos y total. No se deben devolver entidades JPA directamente: además de acoplar la API al esquema de persistencia, las relaciones pueden provocar ciclos de serialización o consultas inesperadas.

La paginación y el ordenamiento son recomendables para colecciones que pueden crecer. No es necesario cargar todos los productos o todas las facturas de una tienda en memoria para una sola respuesta.

## 10. Integridad referencial y eliminación de Customer/Product

Cuando se agregue facturación, la base de datos tendrá claves foráneas. Esto obliga a definir la política de borrado:

- Un cliente con facturas históricas normalmente no se elimina físicamente; puede desactivarse.
- Un producto asociado a una factura normalmente se conserva o se marca inactivo. La clave foránea de la tabla de unión impide borrar un producto referenciado, salvo que primero se elimine o modifique la asociación conforme a la política elegida.
- Al eliminar una factura se eliminan sus filas de `invoice_products`, no los productos del catálogo.
- Las restricciones `NOT NULL`, `UNIQUE`, `CHECK` y las claves foráneas deben reflejar reglas esenciales del dominio.
- No se debe habilitar cascada `REMOVE` desde Invoice hacia Product. La asociación muchos-a-muchos no tiene una entidad de detalle que se pueda borrar en cascada junto a la factura.

La validación de servicio produce mensajes de negocio claros; la restricción de base de datos mantiene la integridad aun cuando una solicitud o proceso alterno intente saltarse la aplicación.

## 11. Pruebas que deberían acompañar la implementación

Una buena prueba verifica el comportamiento observable, no solo que el contexto de Spring arranque.

### CRUD de Customer y Product

- Crear un recurso válido y comprobar los datos devueltos.
- Actualizar un registro existente y comprobar que el mismo ID se conserva.
- Intentar actualizar un registro inexistente y verificar 404.
- Comprobar que update no crea un registro nuevo cuando el ID no existe.
- Eliminar un recurso existente y comprobar que ya no se consulta, o que queda inactivo si se eligió baja lógica.
- Eliminar un identificador inexistente y verificar el comportamiento documentado.
- Rechazar datos inválidos y claves funcionales duplicadas.
- Confirmar qué sucede al intentar borrar un customer/product usado por facturas.

### Facturación

- Crear una factura con un producto y con varios productos.
- Rechazar lista vacía, UUID de producto repetido, cliente inexistente y producto inexistente.
- Rechazar stock insuficiente y comprobar que no queda factura parcial ni descuento parcial de stock.
- Verificar el total con precios decimales y que se calcula una unidad por producto.
- Cambiar posteriormente el precio del producto y comprobar que el total guardado de la factura no cambia, aunque no se conserva el desglose histórico por producto.
- Probar que los UUID de productos repetidos se rechazan.
- Probar dos compras concurrentes si se incorpora control de concurrencia.

## 12. Implementación educativa del CRUD de facturación

Esta sección convierte el diseño anterior en código organizado con las capas usadas por `tiendavirtual`: DTO, mapper, modelo, servicio, repositorio de aplicación, repositorio Spring Data, entidad y controlador. El código usa los paquetes `com.example.tiendavirtual` y la ruta singular `/api/invoice`, consistente con el controlador actual de Customer.

### 12.1 Alcance y decisiones del ejemplo

- Una factura contiene un cliente y una o más referencias a productos. Cada producto puede aparecer una sola vez en la factura y representa una unidad.
- El cliente solo envía `customerId` y `productIds`. El servidor consulta el precio y el stock; ignora cualquier total que el cliente pudiera intentar enviar.
- Al crear una factura se descuenta una unidad de stock por producto. Al actualizar se devuelve el stock de los productos anteriores y se descuenta el de los nuevos. Al eliminar se restaura una unidad por producto.
- El total se guarda al crear la factura, pero no se conserva el precio histórico individual ni el nombre/código de cada producto. Es una simplificación didáctica, no un diseño apropiado para facturación con trazabilidad por línea.
- Para mantener el ejemplo pequeño, el precio actual de `ProductEntity` sigue siendo `Double`. Se convierte a `BigDecimal` en el momento de facturar. En una aplicación real también se debe migrar el precio del producto a `BigDecimal`.
- El cálculo no aplica el campo `tax` que existe en `ProductEntity`: antes de cobrar impuestos se debe definir si representa una tasa o un importe, su base y la política de redondeo.
- El CRUD físico de factura sirve para el ejercicio. En producción, una factura emitida debe conservarse: se permitiría modificar/eliminar solo borradores y se modelaría la anulación como un cambio de estado con auditoría.
- La transacción hace atómicas las operaciones de factura y stock, pero no evita por sí sola ventas concurrentes. Para eso se requiere después bloqueo o control optimista.

La dependencia de Validation ya está en el `pom.xml` del proyecto; por tanto, no es necesario agregar otra dependencia para las anotaciones `@NotNull`, `@Positive`, `@Valid` y `@NotEmpty`.

### 12.2 Entidades JPA

Crear `InvoiceEntity` en el paquete `entities`. La relación con Customer se guarda como clave foránea. La colección de productos se persiste mediante una tabla de unión `invoice_products`. No se configura cascada de borrado hacia Product.

```java
package com.example.tiendavirtual.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "invoices")
@Getter
@Setter
public class InvoiceEntity {
	@Id
	@GeneratedValue
	private UUID id;

	@Column(nullable = false, unique = true)
	private String number;

	@Column(nullable = false)
	private LocalDateTime issuedAt;

	@Column(nullable = false, precision = 12, scale = 2)
	private BigDecimal total;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "customer_id", nullable = false)
	private CustomerEntity customer;

	@ManyToMany
	@JoinTable(
		name = "invoice_products",
		joinColumns = @JoinColumn(name = "invoice_id"),
		inverseJoinColumns = @JoinColumn(name = "product_id")
	)
	private List<ProductEntity> products = new ArrayList<>();
}
```

La tabla de unión mantiene las claves foráneas entre facturas y productos. Al borrar una factura se eliminan sus asociaciones, pero no se debe propagar el borrado al catálogo. El campo `total` conserva el importe calculado al momento de crearla.

### 12.3 DTO de entrada y salida

El DTO de entrada valida la forma del request. Se usan records de Java para DTOs inmutables y concisos. La lista debe contener al menos un UUID y no admite elementos nulos.

```java
package com.example.tiendavirtual.dtos;

import java.util.List;
import java.util.UUID;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record InvoiceRequestDto(
	@NotNull UUID customerId,
	@NotEmpty List<@NotNull UUID> productIds
) {}
```

El request para crear y actualizar comparte estructura: ambos deben enviar el cliente y la lista completa de productos. El cuerpo no incluye número, fecha ni total porque son datos controlados por el servidor.

```java
package com.example.tiendavirtual.dtos;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public record InvoiceResponseDto(
	UUID id,
	String number,
	LocalDateTime issuedAt,
	UUID customerId,
	BigDecimal total,
	List<UUID> productIds
) {}
```

El DTO de respuesta contiene identificadores de productos y el total guardado, pero no expone las entidades JPA ni sus relaciones internas.

### 12.4 Modelo y mapper

Como Customer ya cuenta con un modelo separado, la factura también usa un modelo de dominio. La colección contiene UUIDs, no entidades JPA.

```java
package com.example.tiendavirtual.models;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import lombok.Data;

@Data
public class Invoice {
	private UUID id;
	private String number;
	private LocalDateTime issuedAt;
	private UUID customerId;
	private BigDecimal total;
	private List<UUID> productIds;
}
```

El mapper traduce explícitamente request → modelo y entidad → modelo → DTO. La creación de entidades se completa en el servicio porque requiere consultar Customer y Product y verificar el stock; esa regla no debe quedar escondida en una conversión automática.

```java
package com.example.tiendavirtual.mappers;

import java.util.List;
import java.util.UUID;

import com.example.tiendavirtual.dtos.InvoiceRequestDto;
import com.example.tiendavirtual.dtos.InvoiceResponseDto;
import com.example.tiendavirtual.entities.InvoiceEntity;
import com.example.tiendavirtual.entities.ProductEntity;
import com.example.tiendavirtual.models.Invoice;

public final class InvoiceMapper {
	private InvoiceMapper() {}

	public static Invoice requestToModel(InvoiceRequestDto dto) {
		Invoice invoice = new Invoice();
		invoice.setCustomerId(dto.customerId());
		invoice.setProductIds(dto.productIds());
		return invoice;
	}

	public static Invoice entityToModel(InvoiceEntity entity) {
		Invoice invoice = new Invoice();
		invoice.setId(entity.getId());
		invoice.setNumber(entity.getNumber());
		invoice.setIssuedAt(entity.getIssuedAt());
		invoice.setCustomerId(entity.getCustomer().getId());
		invoice.setTotal(entity.getTotal());

		List<UUID> productIds = entity.getProducts().stream()
			.map(ProductEntity::getId)
			.toList();
		invoice.setProductIds(productIds);
		return invoice;
	}

	public static InvoiceResponseDto modelToResponseDto(Invoice invoice) {
		return new InvoiceResponseDto(
			invoice.getId(), invoice.getNumber(), invoice.getIssuedAt(),
			invoice.getCustomerId(), invoice.getTotal(), invoice.getProductIds());
	}
}
```

En las entidades se usan `@Getter` y `@Setter` en vez de `@Data` para evitar que `toString`, `equals` y `hashCode` recorran asociaciones JPA o disparen cargas inesperadas.

### 12.5 Repositorios

El repositorio Spring Data se limita a la persistencia JPA:

```java
package com.example.tiendavirtual.repositories;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.tiendavirtual.entities.InvoiceEntity;

public interface IInvoiceJpaRepository extends JpaRepository<InvoiceEntity, UUID> {}
```

El repositorio de aplicación ofrece operaciones del caso de uso y conserva la separación que ya utiliza `CustomerRepository`:

```java
package com.example.tiendavirtual.repositories;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;
import com.example.tiendavirtual.entities.InvoiceEntity;

@Repository
public class InvoiceRepository {
	private final IInvoiceJpaRepository repository;

	public InvoiceRepository(IInvoiceJpaRepository repository) {
		this.repository = repository;
	}

	public List<InvoiceEntity> findAll() {
		return repository.findAll();
	}

	public Optional<InvoiceEntity> findById(UUID id) {
		return repository.findById(id);
	}

	public InvoiceEntity save(InvoiceEntity invoice) {
		return repository.save(invoice);
	}

	public void delete(InvoiceEntity invoice) {
		repository.delete(invoice);
	}
}
```

Para buscar los productos se necesita completar la capa que aún no existe en el proyecto. Crear `IProductJpaRepository`:

```java
package com.example.tiendavirtual.repositories;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.tiendavirtual.entities.ProductEntity;

public interface IProductJpaRepository extends JpaRepository<ProductEntity, UUID> {}
```

Y crear el repositorio de aplicación para Product:

```java
package com.example.tiendavirtual.repositories;

import java.util.UUID;

import org.springframework.stereotype.Repository;
import com.example.tiendavirtual.entities.ProductEntity;
import com.example.tiendavirtual.exceptions.ResourceNotFoundException;

@Repository
public class ProductRepository {
	private final IProductJpaRepository repository;

	public ProductRepository(IProductJpaRepository repository) {
		this.repository = repository;
	}

	public ProductEntity getById(UUID id) {
		return repository.findById(id)
			.orElseThrow(() -> new ResourceNotFoundException("Producto no encontrado: " + id));
	}

	public ProductEntity update(ProductEntity product) {
		return repository.save(product);
	}
}
```

Para que las búsquedas de cliente también produzcan un error de dominio claro, ajustar `CustomerRepository.getById` para reemplazar el `.get()` actual:

```java
public CustomerEntity getById(UUID id) {
	return repository.findById(id)
		.orElseThrow(() -> new ResourceNotFoundException("Cliente no encontrado: " + id));
}
```

`ResourceNotFoundException` y `BusinessConflictException` son excepciones pequeñas del dominio. Crear ambas en un paquete nuevo llamado `exceptions`:

```java
package com.example.tiendavirtual.exceptions;

public class ResourceNotFoundException extends RuntimeException {
	public ResourceNotFoundException(String message) {
		super(message);
	}
}
```

```java
package com.example.tiendavirtual.exceptions;

public class BusinessConflictException extends RuntimeException {
	public BusinessConflictException(String message) {
		super(message);
	}
}
```

En `CustomerRepository` también se debe importar `com.example.tiendavirtual.exceptions.ResourceNotFoundException` para el método `getById` mostrado arriba.

### 12.6 Servicio: reglas, cálculo y transacción

El servicio concentra el caso de uso. `@Transactional` hace que guardar la factura, sus asociaciones y los cambios de stock se confirmen o reviertan juntos. Se rechazan productos repetidos en el mismo request.

```java
package com.example.tiendavirtual.services;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.tiendavirtual.entities.CustomerEntity;
import com.example.tiendavirtual.entities.InvoiceEntity;
import com.example.tiendavirtual.entities.ProductEntity;
import com.example.tiendavirtual.exceptions.BusinessConflictException;
import com.example.tiendavirtual.exceptions.ResourceNotFoundException;
import com.example.tiendavirtual.mappers.InvoiceMapper;
import com.example.tiendavirtual.models.Invoice;
import com.example.tiendavirtual.repositories.CustomerRepository;
import com.example.tiendavirtual.repositories.InvoiceRepository;
import com.example.tiendavirtual.repositories.ProductRepository;

@Service
public class InvoiceService {
	private final InvoiceRepository invoiceRepository;
	private final CustomerRepository customerRepository;
	private final ProductRepository productRepository;

	public InvoiceService(
		InvoiceRepository invoiceRepository,
		CustomerRepository customerRepository,
		ProductRepository productRepository
	) {
		this.invoiceRepository = invoiceRepository;
		this.customerRepository = customerRepository;
		this.productRepository = productRepository;
	}

	@Transactional(readOnly = true)
	public List<Invoice> getAll() {
		return invoiceRepository.findAll().stream()
			.map(InvoiceMapper::entityToModel)
			.toList();
	}

	@Transactional(readOnly = true)
	public Invoice getById(UUID id) {
		InvoiceEntity entity = invoiceRepository.findById(id)
			.orElseThrow(() -> new ResourceNotFoundException("Factura no encontrada: " + id));
		return InvoiceMapper.entityToModel(entity);
	}

	@Transactional
	public Invoice create(Invoice invoice) {
		CustomerEntity customer = customerRepository.getById(invoice.getCustomerId());

		InvoiceEntity entity = new InvoiceEntity();
		entity.setNumber("FAC-" + UUID.randomUUID());
		entity.setIssuedAt(LocalDateTime.now());
		entity.setCustomer(customer);
		entity.setProducts(new ArrayList<>());
		addProductsAndReduceStock(entity, invoice.getProductIds());

		return InvoiceMapper.entityToModel(invoiceRepository.save(entity));
	}

	@Transactional
	public Invoice update(UUID id, Invoice invoice) {
		InvoiceEntity entity = invoiceRepository.findById(id)
			.orElseThrow(() -> new ResourceNotFoundException("Factura no encontrada: " + id));

		// Al reemplazar los productos, primero se revierte el movimiento anterior.
		restoreStock(entity);
		entity.setCustomer(customerRepository.getById(invoice.getCustomerId()));
		entity.getProducts().clear();
		addProductsAndReduceStock(entity, invoice.getProductIds());

		// Se conservan el UUID, número y fecha originales.
		return InvoiceMapper.entityToModel(invoiceRepository.save(entity));
	}

	@Transactional
	public void delete(UUID id) {
		InvoiceEntity entity = invoiceRepository.findById(id)
			.orElseThrow(() -> new ResourceNotFoundException("Factura no encontrada: " + id));
		restoreStock(entity);
		invoiceRepository.delete(entity);
	}

	private void addProductsAndReduceStock(InvoiceEntity invoice, List<UUID> requestedProductIds) {
		if (requestedProductIds == null || requestedProductIds.isEmpty()) {
			throw new IllegalArgumentException("La factura debe tener al menos un producto");
		}

		Set<UUID> uniqueProductIds = new HashSet<>();
		BigDecimal total = BigDecimal.ZERO;

		for (UUID productId : requestedProductIds) {
			if (productId == null) {
				throw new IllegalArgumentException("El identificador del producto es obligatorio");
			}
			if (!uniqueProductIds.add(productId)) {
				throw new IllegalArgumentException("No se permiten productos repetidos en la factura");
			}

			ProductEntity product = productRepository.getById(productId);
			if (product.getPrice() == null || product.getPrice() < 0
				|| product.getStock() == null || product.getStock() < 0) {
				throw new IllegalArgumentException("El producto tiene precio o stock inválido");
			}
			if (product.getStock() < 1) {
				throw new BusinessConflictException("Stock insuficiente para el producto " + product.getCode());
			}

			BigDecimal price = BigDecimal.valueOf(product.getPrice())
				.setScale(2, RoundingMode.HALF_UP);
			invoice.getProducts().add(product);
			product.setStock(product.getStock() - 1);
			productRepository.update(product);
			total = total.add(price);
		}

		invoice.setTotal(total.setScale(2, RoundingMode.HALF_UP));
	}

	private void restoreStock(InvoiceEntity invoice) {
		for (ProductEntity associatedProduct : invoice.getProducts()) {
			ProductEntity product = productRepository.getById(associatedProduct.getId());
			if (product.getStock() == null) {
				throw new IllegalArgumentException("El stock del producto no puede ser nulo");
			}
			product.setStock(product.getStock() + 1);
			productRepository.update(product);
		}
	}
}
```

Aspectos importantes del servicio:

- `create` y `update` consultan los registros relacionados antes de persistir; un UUID inválido no crea una factura incompleta.
- `addProductsAndReduceStock` suma con `BigDecimal` el precio vigente de cada producto y descuenta una unidad. El cliente no controla los importes.
- Si un producto falla después de haber procesado otro, la excepción de ejecución hace rollback de la transacción y no deja un descuento parcial.
- `update` mantiene el identificador, número y fecha de la factura; reemplaza cliente/productos y ajusta el stock según la nueva selección.
- `update` recalcula el total con los precios vigentes y, por eso, solo es apropiado para facturas editables/borradores, no para documentos históricos emitidos.
- `delete` es borrado físico de este ejemplo y restaura el inventario. En un flujo real de documentos emitidos se sustituiría por una anulación auditable.

### 12.7 Controlador REST

El controlador conserva la responsabilidad que se ve en `CustomerController`: recibe DTO, solicita la operación al servicio, convierte la respuesta y elige el estado HTTP. No consulta repositorios ni calcula precios.

```java
package com.example.tiendavirtual.controllers;

import java.net.URI;
import java.util.List;
import java.util.UUID;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.tiendavirtual.dtos.InvoiceRequestDto;
import com.example.tiendavirtual.dtos.InvoiceResponseDto;
import com.example.tiendavirtual.mappers.InvoiceMapper;
import com.example.tiendavirtual.models.Invoice;
import com.example.tiendavirtual.services.InvoiceService;

@RestController
@RequestMapping("/api/invoice")
public class InvoiceController {
	private final InvoiceService invoiceService;

	public InvoiceController(InvoiceService invoiceService) {
		this.invoiceService = invoiceService;
	}

	@GetMapping
	public ResponseEntity<List<InvoiceResponseDto>> getAll() {
		List<InvoiceResponseDto> response = invoiceService.getAll().stream()
			.map(InvoiceMapper::modelToResponseDto)
			.toList();
		return ResponseEntity.ok(response);
	}

	@GetMapping("/{id}")
	public ResponseEntity<InvoiceResponseDto> getById(@PathVariable UUID id) {
		Invoice invoice = invoiceService.getById(id);
		return ResponseEntity.ok(InvoiceMapper.modelToResponseDto(invoice));
	}

	@PostMapping
	public ResponseEntity<InvoiceResponseDto> create(@Valid @RequestBody InvoiceRequestDto request) {
		Invoice invoice = InvoiceMapper.requestToModel(request);
		Invoice created = invoiceService.create(invoice);
		URI location = URI.create("/api/invoice/" + created.getId());
		return ResponseEntity.created(location)
			.body(InvoiceMapper.modelToResponseDto(created));
	}

	@PutMapping("/{id}")
	public ResponseEntity<InvoiceResponseDto> update(
		@PathVariable UUID id,
		@Valid @RequestBody InvoiceRequestDto request
	) {
		Invoice invoice = InvoiceMapper.requestToModel(request);
		Invoice updated = invoiceService.update(id, invoice);
		return ResponseEntity.ok(InvoiceMapper.modelToResponseDto(updated));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable UUID id) {
		invoiceService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
```

El API resultante es `GET /api/invoice`, `GET /api/invoice/{id}`, `POST /api/invoice`, `PUT /api/invoice/{id}` y `DELETE /api/invoice/{id}`. El `POST` devuelve `201 Created` y `Location`; el `DELETE` devuelve `204 No Content`.

### 12.8 Traducción de errores a HTTP

Sin un manejador, las excepciones pueden terminar en respuestas poco claras. Este advice convierte errores de existencia en `404`, conflictos de stock en `409` y reglas de entrada de negocio en `400`. Las violaciones de `@Valid` también deben responder `400`.

```java
package com.example.tiendavirtual.controllers;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.tiendavirtual.exceptions.BusinessConflictException;
import com.example.tiendavirtual.exceptions.ResourceNotFoundException;

@RestControllerAdvice
public class ApiExceptionHandler {
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<Map<String, String>> handleNotFound(ResourceNotFoundException exception) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
			.body(Map.of("message", exception.getMessage()));
	}

	@ExceptionHandler(BusinessConflictException.class)
	public ResponseEntity<Map<String, String>> handleConflict(BusinessConflictException exception) {
		return ResponseEntity.status(HttpStatus.CONFLICT)
			.body(Map.of("message", exception.getMessage()));
	}

	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<Map<String, String>> handleBadRequest(IllegalArgumentException exception) {
		return ResponseEntity.badRequest()
			.body(Map.of("message", exception.getMessage()));
	}
}
```

### 12.9 Ejemplo de request y ciclo CRUD

Request para crear una factura de dos productos:

```json
{
  "customerId": "uuid-del-cliente",
  "productIds": [
	"uuid-del-producto-a",
	"uuid-del-producto-b"
	]
}
```

El mismo formato completo se envía al hacer `PUT`. La respuesta incluirá el ID y número de factura, fecha, cliente, UUID de los productos y total calculado. El recorrido queda así: el controlador valida y mapea el DTO; el servicio verifica cliente/productos/stock y calcula; los repositorios delegan en JPA; la entidad persiste la factura y la tabla de unión mantiene las asociaciones; y el mapper prepara el DTO de respuesta.

Antes de considerar terminada la implementación, probar creación con stock suficiente e insuficiente, lectura de ID existente e inexistente, actualización que conserva el UUID, borrado que restaura el stock, UUID de producto duplicado, producto inexistente y que un cambio posterior del precio no modifique el total previamente guardado. También se debe comprobar que una falla en un producto no persista descuentos ni factura parcial.
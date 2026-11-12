# Examen A

### 1. Flujo de creación de un cliente
En el `POST /api/customer` existente, ¿qué recorrido respeta la separación de responsabilidades entre las capas?
A. El controlador recibe una entidad JPA y la guarda directamente; el servicio serializa el resultado.  
B. El controlador recibe el DTO y lo convierte a modelo; el servicio coordina el alta y el acceso al repositorio; el controlador transforma el resultado en DTO de respuesta.  
C. El repositorio recibe el JSON y lo transforma en DTO; el servicio construye la respuesta HTTP.  
D. El DTO ejecuta la consulta de persistencia y el controlador devuelve el repositorio.

### 2. Repositorio
`CustomerRepository` delega operaciones a `CustomerJpaRepository`. ¿Cuál es la valoración más precisa de esta capa en su implementación actual?
A. Es obligatoria porque Spring Data JPA no admite métodos como `findByIdentification`.  
B. Puede aislar al servicio de Spring Data y concentrar lógica de acceso, aunque su beneficio es limitado si solo delega operaciones.  
C. Reemplaza automáticamente las transacciones y evita que JPA gestione entidades.  
D. Convierte todas las consultas en independientes del motor de base de datos.

### 3. Consulta
¿Qué expresa el método `findByIdentification(String identification)` declarado en `CustomerJpaRepository`?
A. Una consulta que Spring Data puede derivar para buscar clientes por el campo `identification`.  
B. Una operación que crea un cliente cuando no lo encuentra.  
C. Una ruta HTTP que devuelve un DTO al consumidor.  
D. Una conversión automática de `CustomerCreateDto` a `CustomerEntity`.

### 4. DTO de respuesta
En el mapeador actual, `modelToDto` asigna nombre, identificación y dirección. ¿Qué ocurre con el correo electrónico al responder una consulta?
A. Se incluye siempre porque la entidad tiene un campo `email`.  
B. Se incluye solo cuando PostgreSQL genera el UUID.  
C. No se asigna a `CustomerResponseDto`, por lo que no forma parte del DTO de respuesta actual.  
D. Lo agrega automáticamente `ResponseEntity` durante la serialización.

### 5. Identificador de la entidad
En `CustomerEntity`, ¿cuál es el propósito de combinar `@Id`, `@GeneratedValue` y el campo `UUID id`?
A. Definir el identificador de persistencia y delegar su generación al proveedor JPA según su configuración.  
B. Recibir el identificador desde la ruta HTTP y convertirlo en una clave primaria automáticamente.  
C. Garantizar que Jackson genere un UUID cada vez que serializa el DTO.  
D. Evitar que la entidad se guarde mediante `JpaRepository`.

### 6. Anotación y firma del endpoint de creación
Escriba el método de `CustomerController` que atienda `POST /api/customer` y reciba un `CustomerCreateDto` en el cuerpo.
```java
@RequestMapping("/api/customer")
@PostMapping
public ResponseEntity<CustomerResponseDto> ______
```

### 7. Conversión de entrada
Escriba las dos instrucciones que convierten `customerCreateDto` en un modelo `Customer` usando `CustomerMapper` y luego envían ese modelo al servicio para crear el cliente. Suponga que `customerService` está disponible.
```java
Customer customer = CustomerMapper.______
```

### 8. Método de búsqueda por identificación
Escriba el método que se declara en `CustomerJpaRepository` para buscar una `CustomerEntity` por su identificación.
```java
public interface CustomerJpaRepository ...
```

### 9. Mapeo de modelo a entidad

Escriba las asignaciones necesarias para copiar `email` y `address` desde un objeto `Customer` llamado `customer` a una `CustomerEntity` llamada `customerEntity`.
```java
customerEntity.set______
```

### 10. Guardado y retorno al modelo

Escriba el fragmento que convierte `customer` a entidad, la guarda mediante `customerRepository.create(...)` y convierte la entidad guardada de vuelta a `Customer`. Suponga que las variables necesarias están declaradas.
```java
CustomerEntity entity = CustomerMapper.______
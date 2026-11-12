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
```

---

# Examen B

### 1. Flujo de listado de clientes
En `GET /api/customer`, ¿cómo se distribuyen las responsabilidades en la implementación actual?
A. El repositorio crea los DTO y serializa JSON; el servicio se limita a abrir la conexión.  
B. El controlador llama al servicio; el servicio obtiene entidades a través del repositorio y las transforma a modelos; el controlador mapea los modelos a DTO de respuesta.  
C. El controlador consulta directamente `CustomerJpaRepository` y el servicio convierte el resultado en código HTTP.  
D. El mapeador consulta todas las filas y devuelve la respuesta HTTP.

### 2. Separación de DTO, modelo y entidad
¿Cuál es una ventaja principal de mantener separados `CustomerCreateDto`, `Customer` y `CustomerEntity`?
A. Hace posible cambiar el contrato HTTP, el modelo de la aplicación y la persistencia con menor acoplamiento, aunque requiere mantener conversiones.  
B. Evita la necesidad de probar las conversiones y de validar las entradas.  
C. Elimina las consultas a la base de datos porque cada tipo representa la misma instancia.  
D. Obliga a que el controlador ejecute la lógica de persistencia.

### 3. servicio
¿Por qué `CustomerService` devuelve un `Customer` y no un `ResponseEntity<CustomerResponseDto>` en el diseño actual?
A. Porque el servicio coordina el caso de uso sin asumir la traducción al protocolo HTTP, que corresponde a la capa web.  
B. Porque Spring no permite que un servicio devuelva DTO.  
C. Porque `ResponseEntity` solo puede utilizarse desde una entidad JPA.  
D. Porque el repositorio debe serializar directamente el modelo.

### 4. Módulo de productos
`ProductController` contiene únicamente la ruta base y comentarios de operaciones, mientras que existe `ProductEntity`. ¿Qué enfoque es más coherente para completar el módulo?
A. Implementar toda la lógica en el controlador y devolver `ProductEntity` directamente como contrato público.  
B. Añadir endpoints y capas acordes al módulo —DTO, servicio, repositorio y mapeo—, manteniendo las reglas del caso de uso fuera del controlador.  
C. Guardar productos en una lista estática y dejar que JPA la sincronice automáticamente.  
D. Esperar que Spring genere por convención las reglas de negocio y todos los endpoints.

### 5. Recorrido de una búsqueda
En `GET /api/customer/{identification}`, ¿qué secuencia corresponde al flujo implementado?
A. El controlador recibe el parámetro, llama al servicio; el servicio busca a través del repositorio y convierte la entidad a modelo; el controlador mapea el resultado a DTO.  
B. La entidad recibe la petición HTTP y decide qué respuesta JSON enviar.  
C. El repositorio transforma el parámetro de ruta en `ResponseEntity` y evita al servicio.  
D. Jackson consulta directamente la base de datos y genera el modelo de dominio.

### 6. Endpoint de consulta por identificación
Escriba la anotación de Spring MVC y la firma de un método de `CustomerController` que atienda `GET /api/customer/{identification}` y reciba el parámetro de ruta como `String`.
```java
@GetMapping("/{identification}")
public ResponseEntity<CustomerResponseDto> ______
```

### 7. Conversión de una lista
Escriba la instrucción Java que transforma una lista `customersEntity` de entidades `CustomerEntity` en una lista `customers` de modelos `Customer`, usando `CustomerMapper.entityToModel`.
```java
List<Customer> customers = customersEntity.stream()
```

### 8. Construcción del DTO de respuesta
Escriba tres asignaciones que copien `name`, `identification` y `address` desde `customer` (`Customer`) hacia `dto` (`CustomerResponseDto`).
```java
dto.set...
```

### 9. Campo identificador JPA
Escriba las tres líneas que declaran el identificador UUID generado de `CustomerEntity`, incluyendo las anotaciones correspondientes.
```java
@Id
```

### 10. mapper del guardado
Escriba el método de `CustomerRepository` que recibe una `CustomerEntity`, la guarda mediante `CustomerJpaRepository` (referenciado por el campo `repository`) y devuelve la entidad guardada.
```java
public CustomerEntity create...
```

## Respuestas

### Examen A

1. **B.** El controlador convierte el DTO a modelo, el servicio coordina el caso de uso y el acceso al repositorio, y el controlador convierte el resultado al DTO de respuesta.
2. **B.** La capa puede aislar al servicio de Spring Data y concentrar el acceso a datos; en esta implementación su aporte es acotado porque principalmente delega operaciones.
3. **A.** Spring Data puede derivar la consulta a partir del nombre del método para buscar por el campo `identification`.
4. **C.** El correo no se asigna a `CustomerResponseDto`, por lo tanto no está presente en la respuesta actual.
5. **A.** `@Id` marca la clave primaria y `@GeneratedValue` delega la generación al proveedor JPA conforme a su configuración.
6. ```java
   public ResponseEntity<CustomerResponseDto> createCustomer(
	   @RequestBody CustomerCreateDto customerCreateDto
   ) {
	   Customer customer = CustomerMapper.dtoToModel(customerCreateDto);
	   Customer createdCustomer = customerService.create(customer);
	   CustomerResponseDto responseDto = CustomerMapper.modelToDto(createdCustomer);
	   return ResponseEntity.ok(responseDto);
   }
   ```
7. ```java
   Customer customer = CustomerMapper.dtoToModel(customerCreateDto);
   Customer customerCreate = customerService.create(customer);
   ```
8. ```java
   public interface CustomerJpaRepository extends JpaRepository<CustomerEntity, UUID> {
	   CustomerEntity findByIdentification(String identification);
   }
   ```
   Se requieren los imports de `JpaRepository`, `CustomerEntity` y `UUID`.
9. ```java
   customerEntity.setEmail(customer.getEmail());
   customerEntity.setAddress(customer.getAddress());
   ```
10. ```java
	CustomerEntity entity = CustomerMapper.modelToEntity(customer);
	CustomerEntity savedEntity = customerRepository.create(entity);
	Customer result = CustomerMapper.entityToModel(savedEntity);
	```

### Examen B

1. **B.** El controlador llama al servicio; el servicio obtiene entidades por medio del repositorio y las transforma a modelos; finalmente, el controlador mapea los modelos a DTO de respuesta.
2. **A.** Mantener tipos separados permite evolucionar con menor acoplamiento el contrato HTTP, el modelo de aplicación y la persistencia, aunque exige mantener las conversiones.
3. **A.** El servicio coordina el caso de uso sin asumir la traducción al protocolo HTTP, que corresponde a la capa web.
4. **B.** Completar el módulo con endpoints y capas como DTO, servicio, repositorio y mapeo, manteniendo las reglas del caso de uso fuera del controlador.
5. **A.** El controlador recibe el parámetro y llama al servicio; el servicio consulta mediante el repositorio y convierte la entidad a modelo; el controlador mapea el resultado a DTO.
6. ```java
   @GetMapping("/{identification}")
   public ResponseEntity<CustomerResponseDto> getByIdentification(
	   @PathVariable("identification") String identification
   )
   ```
7. ```java
   List<Customer> customers = customersEntity.stream()
	   .map(CustomerMapper::entityToModel)
	   .toList();
   ```
8. ```java
   dto.setName(customer.getName());
   dto.setIdentification(customer.getIdentification());
   dto.setAddress(customer.getAddress());
   ```
9. ```java
   @Id
   @GeneratedValue
   private UUID id;
   ```
   Se requiere `import java.util.UUID;`.
10. ```java
	public CustomerEntity create(CustomerEntity customerEntity) {
		CustomerEntity customerCreate = repository.save(customerEntity);
		return customerCreate;
	}
	```

# Exámenes técnicos — Tienda Virtual
## Examen A
1. **Escritura de código — Controlador:** complete el método del controlador para crear un cliente. Debe convertir el DTO de entrada a modelo, llamar al servicio, convertir el resultado a DTO de respuesta y devolver `200 OK`.
	```java
	public ResponseEntity<CustomerResponseDto> create(@RequestBody CustomerCreateDto customerCreateDto) {
	    // Escriba aquí el cuerpo del método.
	}
	```
2. En la creación de un cliente, los mappers de entrada no asignan `id`, mientras que `CustomerEntity.id` está anotado con `@Id` y `@GeneratedValue`. ¿Qué comportamiento describe correctamente ese diseño?
	A. El UUID se calcula a partir de `identification` antes de llegar al repositorio.
	B. La generación del identificador queda a cargo de la persistencia conforme a la configuración del proveedor; no se deriva de los campos del DTO en los mappers.
	C. Spring convierte automáticamente el nombre del cliente en un UUID determinista.
	D. El endpoint exige que el cliente envíe el UUID aunque el DTO no lo tenga.

3. **Escritura de código — Servicio:** implemente `update`. El método debe buscar el cliente existente mediante el UUID, reemplazar nombre, identificación, correo y dirección, guardar la entidad actualizada y devolver el modelo resultante. No sobrescriba el UUID existente con el modelo recibido.
	```java
	public Customer update(UUID id, Customer customer) {
	    // Escriba aquí el cuerpo del método.
	}
	```
4. Si `POST /api/customer` recibe datos válidos y la operación de persistencia tiene éxito, ¿qué afirmación sobre la respuesta es correcta?
	A. El mapper de respuesta copia nombre, identificación y dirección; omite UUID y correo porque son datos sensibles.
	B. Incluye el correo, pero omite identificación y dirección.
	C. Incluye el UUID generado y el correo, porque ambos existen en la entidad.
	D. Devuelve directamente `CustomerEntity` serializado por Jackson.
5. **Escritura de código — Repositorio JPA:** escriba la declaración de `ICustomerJpaRepository`, incluyendo su supertipo y tipos genéricos, y declare el método de consulta derivada que permite buscar un cliente por identificación.
6. En la ruta `GET /api/customer/{identification}` y `PUT /api/customer/{id}`, ¿qué tipo recibe el parámetro y cómo se distingue de la ruta de actualización?
	A. Ambas reciben `UUID`; la búsqueda se diferencia solo por el nombre del parámetro.
	B. Ambas reciben `String`, y el repositorio convierte automáticamente el valor a UUID.
	C. La búsqueda recibe `Long` y la actualización recibe `String`.
	D. La búsqueda recibe `String` y la actualización recibe `UUID`; Java convierte el segmento de la ruta de actualización al tipo declarado.
7. **Escritura de código — Servicio:** implemente `getByIdentification`. Use el repositorio de aplicación para obtener la entidad y conviértala a modelo antes de devolverla.
	```java
	public Customer getByIdentification(String identification) {
	    // Escriba aquí el cuerpo del método.
	}
	```
8. ¿Qué estado HTTP devuelve el controlador al terminar con éxito el endpoint de eliminación?
	A. `204 No Content`, porque el tipo de retorno es `ResponseEntity<Void>`.
	B. `202 Accepted`, porque el borrado se delega al servicio.
	C. `200 OK` con cuerpo vacío, por la llamada a `ResponseEntity.ok().build()`.
	D. `201 Created`, porque la operación modifica la base de datos.
9. ¿Cuál es una implicación directa de `application.properties` en la configuración del proyecto?
	A. JPA y JPQL elimina y recrea todas las tablas en cada arranque.
	B. La propiedad solo afecta las consultas `SELECT` y no al esquema.
	C. La aplicación desactiva por completo la generación de esquema.
	D. Se puede configurar la conexion a la base de datos con host, puerto, esquema, usuario y contraseña.
10. **Escritura de código — Mapper:** implemente `entityToModel(CustomerEntity customerEntity)`. El método debe crear un `Customer` y copiar el UUID, nombre, identificación, correo y dirección desde la entidad.
	```java
	public static Customer entityToModel(CustomerEntity customerEntity) {
	    // Escriba aquí el cuerpo del método.
	}
	```

## Examen B
1. **Escritura de código — Controlador:** implemente `getAllCustomers`. Llame al servicio, convierta cada `Customer` recibido a `CustomerResponseDto` mediante `CustomerMapper.modelToDto` y devuelva la lista con `200 OK`.
	```java
	public ResponseEntity<List<CustomerResponseDto>> getAllCustomers() {
	    // Escriba aquí el cuerpo del método.
	}
	```
2. Si se llama `PUT /api/customer/{uuid}` con un UUID que no existe, ¿qué comportamiento está más directamente respaldado por la implementación?
	A. `getById` usa `findById(id).get()`; si el `Optional` está vacío, no hay manejo explícito y puede lanzarse una excepción antes de guardar.
	B. El servicio crea un registro nuevo, ya que `save` inserta cuando no encuentra el ID.
	C. El controlador devuelve siempre `404`, gracias a `ResponseEntity`.
	D. La actualización se convierte automáticamente en `PATCH` y no altera la base de datos.
3. `CustomerCreateDto` y `CustomerUpdateDto` son clases distintas, pero declaran los mismos cuatro campos y no tienen restricciones visibles. ¿Qué conclusión se desprende de esa decisión?
	A. Hay dos contratos de tipo distintos para las operaciones, ya que son dos funcionalidades distintas.
	B. Spring infiere que el DTO de actualización permite campos parciales por tener otro nombre.
	C. El DTO de creación se valida automáticamente y el de actualización no.
	D. El DTO de actualización incluye el UUID aunque no lo declare.
4. **Escritura de código — Servicio:** implemente `create(Customer customer)`. Convierta el modelo a `CustomerEntity`, guárdelo mediante `CustomerRepository`, convierta la entidad guardada de nuevo a modelo y devuelva el resultado.
	```java
	public Customer create(Customer customer) {
	    // Escriba aquí el cuerpo del método.
	}
	```
5. **Escritura de código — DTO y mapper:** el consumidor ahora necesita que la respuesta JSON incluya también UUID y correo. Escriba los campos que debe agregar a `CustomerResponseDto` y las asignaciones que debe añadir a `CustomerMapper.modelToDto`. No elimine los campos que ya se devuelven.
6. ¿Qué consecuencia tiene que `CustomerRepository` esté anotado con `@Primary` y además inyecte `ICustomerJpaRepository`?
	A. Fuerza a Spring Data a crear dos tablas de clientes.
	B. Desactiva el escaneo de repositorios de Spring Data.
	C. Marca `CustomerRepository` como candidato preferido ante ambigüedad de repositorios de su tipo; su dependencia es el repositorio JPA que delega las operaciones de persistencia.
	D. Hace que el repositorio de aplicación reemplace la implementación de `JpaRepository` en tiempo de compilación.
7. **Escritura de código — Repositorio de aplicación:** implemente `getByIdentification` en `CustomerRepository`. Delegue la consulta en `ICustomerJpaRepository` y devuelva la entidad obtenida.
	```java
	public CustomerEntity getByIdentification(String identification) {
	    // Escriba aquí el cuerpo del método.
	}
	```
8. **Escritura de código — Servicio:** implemente `delete(UUID id)`. Obtenga la entidad por UUID mediante `CustomerRepository` y delegue el borrado en ese repositorio.
	```java
	public void delete(UUID id) {
	    // Escriba aquí el cuerpo del método.
	}
	```
9. ¿Qué ventaja de diseño ofrece el DTO de respuesta actual y qué limitación concreta mantiene?
	A. Impide que el servicio acceda al email y al UUID del cliente porque son datos sensibles.
	B. El correo deja de persistirse porque no se incluye en el DTO de respuesta.
	C. Evita exponer directamente toda la entidad, pero también deja fuera UUID y email, lo cual puede limitar al consumidor de la API.
	D. Garantiza que el correo no se almacene en la base de datos.
10. `CustomerEntity` usa Lombok `@Data`. ¿Qué efecto relevante hay en el proyecto?
	A. Lombok genera los gets y los setters necesarios.
	B. Lombok genera ambos métodos usando exclusivamente el UUID, aunque no haya configuración al respecto.
	C. `@Data` desactiva `equals()` y `hashCode()` para clases anotadas con `@Entity`.
	D. La implementación de igualdad se delega siempre a PostgreSQL.

## Respuestas

### Examen A

1. ```java
	Customer customer = CustomerMapper.customerCreateDtoToModel(customerCreateDto);
	Customer createdCustomer = customerService.create(customer);
	CustomerResponseDto responseDto = CustomerMapper.modelToDto(createdCustomer);
	return ResponseEntity.ok(responseDto);
	```
2. **B.** La generación del identificador queda a cargo de la persistencia según la configuración del proveedor; los mappers de entrada no lo derivan de los campos del DTO.
3. ```java
	CustomerEntity existingEntity = customerRepository.getById(id);
	Customer existingCustomer = CustomerMapper.entityToModel(existingEntity);
	existingCustomer.setName(customer.getName());
	existingCustomer.setIdentification(customer.getIdentification());
	existingCustomer.setEmail(customer.getEmail());
	existingCustomer.setAddress(customer.getAddress());

	CustomerEntity updatedEntity = customerRepository.update(
		 CustomerMapper.modelToEntity(existingCustomer)
	);
	return CustomerMapper.entityToModel(updatedEntity);
	```
4. **A, con una precisión.** La respuesta actual incluye nombre, identificación y dirección, y omite UUID y correo porque `CustomerMapper.modelToDto` no los asigna. El código no indica que la omisión se deba a que sean datos sensibles.
5. ```java
	public interface ICustomerJpaRepository extends JpaRepository<CustomerEntity, UUID> {
		 CustomerEntity findByIdentification(String identification);
	}
	```
6. **D.** La búsqueda recibe `String` y la actualización `UUID`; Spring convierte el segmento de la ruta al tipo declarado para el parámetro.
7. ```java
	CustomerEntity customerEntity = customerRepository.getByIdentification(identification);
	return CustomerMapper.entityToModel(customerEntity);
	```
8. **C.** Devuelve `200 OK` con cuerpo vacío mediante `ResponseEntity.ok().build()`.
9. **D.** En `application.properties` se configura la conexión a la base de datos con host, puerto, esquema/base de datos, usuario y contraseña.
10. ```java
	 Customer customer = new Customer();
	 customer.setId(customerEntity.getId());
	 customer.setName(customerEntity.getName());
	 customer.setIdentification(customerEntity.getIdentification());
	 customer.setEmail(customerEntity.getEmail());
	 customer.setAddress(customerEntity.getAddress());
	 return customer;
	 ```

### Examen B

1. ```java
	List<Customer> customers = customerService.getAllCustomers();
	List<CustomerResponseDto> responseDtos = customers.stream()
		 .map(CustomerMapper::modelToDto)
		 .toList();
	return ResponseEntity.ok(responseDtos);
	```
2. **A.** `getById` usa `findById(id).get()`; si no existe el UUID, no hay manejo explícito del `Optional` y puede lanzarse una excepción antes de guardar.
3. **A.** Son contratos de tipos distintos para operaciones distintas. Que tengan los mismos campos no hace que el DTO de actualización admita cambios parciales automáticamente.
4. ```java
	CustomerEntity customerEntity = CustomerMapper.modelToEntity(customer);
	CustomerEntity savedEntity = customerRepository.create(customerEntity);
	return CustomerMapper.entityToModel(savedEntity);
	```
5. Agregar a `CustomerResponseDto`:
	```java
	private UUID id;
	private String email;
	```
	Agregar a `CustomerMapper.modelToDto`:
	```java
	customerResponseDto.setId(customer.getId());
	customerResponseDto.setEmail(customer.getEmail());
	```
	También se necesita `import java.util.UUID;` en `CustomerResponseDto`.
6. **C.** `@Primary` marca `CustomerRepository` como candidato preferido ante ambigüedad de su tipo; este delega las operaciones de persistencia en `ICustomerJpaRepository`.
7. ```java
	return repository.findByIdentification(identification);
	```
8. ```java
	CustomerEntity customerEntity = customerRepository.getById(id);
	customerRepository.delete(customerEntity);
	```
9. **C.** El DTO evita exponer directamente toda la entidad, pero actualmente omite UUID y correo, lo que puede limitar al consumidor de la API.
10. **A.** Lombok genera getters y setters, entre otros métodos incluidos por `@Data`.

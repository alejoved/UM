## Examen A

### 1. Actor del sistema

En el diagrama de casos de uso aparece el actor **Usuario**, conectado con las funciones del sistema. ¿Qué representa ese actor?

A. Una clase de Java que contiene los datos de cada cliente.  
B. Un rol externo que interactúa con el sistema para solicitar funciones.  
C. Una operación que calcula el total de una factura.  
D. Una tabla donde se guardan los productos.

### 2. Crear un cliente

En `ClienteOperacion.registrarCliente(...)`, suponga que ya existen el objeto `cliente`, la lista `clientes` y las variables `nombre` e `identificacion`. Escriba las instrucciones para asignar esos dos datos al objeto y agregarlo a la lista.

### 3. Encapsulamiento en `Cliente`

En el diagrama de clases y en `Cliente.java`, atributos como `nombre` e `identificacion` son privados, mientras los getters y setters son públicos. ¿Cuál es la razón principal de ese diseño?

A. Impedir que otras clases consulten los datos del cliente en cualquier circunstancia.  
B. Mantener los datos dentro del objeto y ofrecer métodos definidos para consultarlos o modificarlos.  
C. Hacer que los atributos se compartan automáticamente entre todos los objetos `Cliente`.  
D. Evitar la necesidad de crear objetos `Cliente`.

### 4. Buscar un cliente

En el método `buscarCliente(int identificacion)`, dentro del ciclo que recorre `clientes`, escriba las dos líneas que verifican si el cliente actual tiene esa identificación y, si coincide, lo devuelven.

### 5. Responsabilidad de `ClienteOperacion`

Según el diagrama de clases, `ClienteOperacion` tiene una lista de clientes y operaciones para registrar, buscar y listar. ¿Qué responsabilidad refleja mejor esta clase?

A. Representar los datos individuales de un cliente, como correo y dirección.  
B. Coordinar operaciones sobre el conjunto de clientes, como agregarlos o buscarlos.  
C. Mostrar exclusivamente el diagrama de casos de uso en pantalla.  
D. Calcular el impuesto de cada producto.

### 6. Asociar un cliente a una factura

En `FacturaOperacion.agregarCliente(...)`, dentro del `if` que ya encontró la factura con el consecutivo indicado, escriba la instrucción que asigna el objeto `cliente` recibido a esa factura. **Una línea de Java.**

### 7. Lectura de un caso de uso

La especificación de **Registrar Cliente** indica que el usuario ingresa nombre, identificación, correo y dirección antes de que el sistema confirme el registro. ¿Cuál secuencia corresponde al flujo principal descrito?

A. El sistema elimina un cliente, consulta los productos y muestra el menú.  
B. El usuario elige registrar, ingresa los datos solicitados y el sistema confirma el registro.  
C. El sistema calcula el impuesto antes de conocer los datos del cliente.  
D. El usuario actualiza una factura y luego crea un producto.

### 8. Calcular el impuesto de un producto

En `FacturaOperacion.calcularImpuesto(...)`, dentro del ciclo que recorre los productos de la factura, escriba la instrucción que calcula el 19 % del precio del producto ubicado en el índice `x` y lo guarda en `double impuestoProducto`.

### 9. Conexiones del diagrama de casos de uso

En el diagrama, el actor Usuario está conectado con casos como **Registrar Cliente** y **Registrar Producto**. ¿Qué representan esas conexiones?

A. Las líneas indican interacción o asociación del actor con esos casos.  
B. Cada línea indica que una clase hereda de la clase situada al otro extremo.  
C. Las líneas indican el orden obligatorio en que deben ejecutarse los casos.  
D. Las líneas significan que registrar cliente y registrar producto son el mismo caso de uso.

### 10. Agregar un producto a una factura

En `FacturaOperacion.agregarProducto(...)`, dentro del `if` que ya encontró la factura con el consecutivo indicado, escriba la instrucción que agrega el objeto `producto` recibido a la lista de productos de esa factura. 

---

## Examen B

### 1. Inicializar un producto

En `ProductoOperacion.registrarProducto(...)`, después de crear el objeto `producto`, escriba las instrucciones para asignarle `codigo`, `precio` y `stock` usando sus métodos públicos.

### 2. Significado de `private` y `public`

En `Producto`, los atributos son privados y métodos como `getPrecio()` son públicos. ¿Qué puede hacer otra clase que tenga una referencia a un objeto `Producto`?

A. Leer el atributo privado directamente desde cualquier lugar y modificarlo sin reglas.  
B. Usar el método público `getPrecio()` para consultar el precio, en lugar de acceder directamente al atributo privado.  
C. Convertir automáticamente el producto en una factura.  
D. Acceder a los atributos solo porque están dibujados en el diagrama.

### 3. Delegar el registro de un producto

En una clase que tiene una referencia `productoOperacion`, están disponibles `codigo`, `nombre`, `precio` y `stock`. Escriba la instrucción que delega en ese objeto el registro del producto. **Una línea de Java.**

### 4. Asociación y herencia

En `Factura`, `cliente` es de tipo `Cliente` y `productos` es una lista de `Producto`. ¿Cuál afirmación es correcta?

A. La factura hereda de cliente y producto porque los menciona como tipos.  
B. La factura se relaciona con objetos de esas clases; declarar esos atributos no significa que haya herencia.  
C. Cliente y producto heredan de factura porque aparecen dentro de ella.  
D. No hay relación posible entre clases cuando se usan atributos.

### 5. Buscar un producto

En el método `buscarProducto(String codigo)`, dentro del ciclo que recorre `productos`, escriba las dos líneas que comparan el código del producto actual con el recibido y devuelven el producto si coincide.

### 6. Precondición y postcondición

La especificación de **Registrar Cliente** establece como precondición que el sistema está ejecutándose y muestra el menú, y como postcondición que el cliente quedó registrado. ¿Cuál opción diferencia correctamente ambos conceptos?

A. La precondición describe una condición previa para iniciar el caso; la postcondición describe el resultado esperado al completarlo.  
B. La precondición es un atributo de `Cliente`; la postcondición es un método de `Producto`.  
C. Ambas describen exclusivamente el color de la interfaz.  
D. La precondición ocurre después del registro y la postcondición antes de que el usuario elija la opción.

### 7. Prioridades del catálogo

El catálogo asigna prioridad alta a **Registrar Cliente**, **Registrar Producto** y **Registrar Factura**, y prioridad media a búsquedas y actualizaciones. ¿Qué expresa principalmente esa prioridad?

A. El orden en que deben aparecer los atributos dentro de las clases.  
B. La importancia relativa de implementar o atender cada caso de uso según las necesidades del proyecto.  
C. La cantidad de objetos que se crearán en Java.  
D. El nivel de acceso (`private` o `public`) que debe tener cada método.

### 8. Acumular el subtotal

En `FacturaOperacion.calcularSubtotal(...)`, dentro del ciclo que recorre los productos de una factura, se dispone de la variable `subtotal` y del índice `x`. Escriba la instrucción que acumula en `subtotal` el precio del producto actual.

### 9. Tipo de retorno en una búsqueda

En el diagrama de clases, la operación `buscarProducto(codigo): Producto` pertenece a `ProductoOperacion`. ¿Qué indica `Producto` al final de la firma?

A. Que la operación devuelve un objeto de tipo `Producto` como resultado de la búsqueda.  
B. Que la operación crea una nueva clase llamada `Producto`.  
C. Que `Producto` es el nombre del parámetro recibido.  
D. Que la operación solo puede devolver el número de productos del catálogo.

### 10. Calcular el total de una factura

En `FacturaOperacion.calcularTotal(...)`, ya se tienen las variables `subtotal` e `impuesto` de una factura. Escriba las instrucciones para calcular `total` como la suma de ambas y guardar el resultado en la factura. **Máximo dos líneas de Java.**

---

## Respuestas

### Examen A

1. **B.** Un rol externo que interactúa con el sistema para solicitar funciones.
2. ```java
	cliente.setNombre(nombre);
	cliente.setIdentificacion(identificacion);
	clientes.add(cliente);
	```
3. **B.** Los datos se mantienen dentro del objeto y se ofrecen métodos definidos para consultarlos o modificarlos.
4. ```java
	if (clientes.get(i).getIdentificacion() == identificacion) {
		 return clientes.get(i);
	}
	```
5. **B.** Coordinar operaciones sobre el conjunto de clientes, como agregarlos o buscarlos.
6. ```java
	facturas.get(i).setCliente(cliente);
	```
7. **B.** El usuario elige registrar, ingresa los datos solicitados y el sistema confirma el registro.
8. ```java
	double impuestoProducto = facturas.get(i).getProductos().get(x).getPrecio() * 19 / 100;
	```
9. **A.** Las líneas indican interacción o asociación del actor con esos casos de uso.
10. ```java
	 facturas.get(i).getProductos().add(producto); 
	 ```

### Examen B

1. ```java
	producto.setCodigo(codigo);
	producto.setPrecio(precio);
	producto.setStock(stock);
	```
2. **B.** Puede usar el método público `getPrecio()` para consultar el precio, en lugar de acceder directamente al atributo privado.
3. ```java
	productoOperacion.registrarProducto(codigo, nombre, precio, stock);
	```
4. **B.** La factura se relaciona con objetos de esas clases; declarar esos atributos no significa que haya herencia.
5. ```java
	if (productos.get(i).getCodigo().equals(codigo)) {
		 return productos.get(i);
	}
	```
6. **A.** La precondición es una condición previa para iniciar el caso; la postcondición describe el resultado esperado al completarlo.
7. **B.** Expresa la importancia relativa de implementar o atender cada caso de uso según las necesidades del proyecto.
8. ```java
	subtotal = subtotal + facturas.get(i).getProductos().get(x).getPrecio();
	```
9. **A.** La operación devuelve un objeto de tipo `Producto` como resultado de la búsqueda.
10. ```java
	 double total = subtotal + impuesto;
	 facturas.get(i).setTotal(total);
	 ```
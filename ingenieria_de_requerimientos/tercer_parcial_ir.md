# Tercer Parcial: Ingeniería de Requerimientos

**Tema:** Análisis del código del `sistema-facturacion-software` y diagramas de secuencia
**Valor:** 10 preguntas (Parte A: 5 técnicas, Parte B: 5 diagramas de secuencia), cada una con valor de 0,5 sobre 5,0

---

## Código de referencia

El sistema es una aplicación de consola en Java. `App` crea un `Menu`; el `Menu` pide datos por teclado y delega en las clases `*Operacion`, que guardan los objetos en listas en memoria.

```java
public class App {
    public static void main(String[] args) throws Exception {
        Menu menu = new Menu();
        menu.mostrarMenu();
    }
}
```

```java
public class Cliente {
    private String nombre;
    private int identificacion;
    private String correo;
    private String direccion;
    // getNombre(), getIdentificacion(), getCorreo(), getDireccion()
    // setNombre(...), setIdentificacion(...), setCorreo(...), setDireccion(...)
}

public class Producto {
    private String codigo;
    private String nombre;
    private double precio;
    private int stock;
    // getCodigo(), getNombre(), getPrecio(), getStock()
    // setCodigo(...), setNombre(...), setPrecio(...), setStock(...)
}
```

```java
public class Factura {
    private int consecutivo;
    private LocalDate fecha;
    private double impuesto;
    private double subtotal;
    private double total;
    private List<Producto> productos;
    private Cliente cliente;
    // getters y setters de cada atributo
}
```

```java
public class ClienteOperacion {
    private List<Cliente> clientes = new ArrayList<>();

    public void registrarCliente(String nombre, int identificacion, String correo, String direccion){
        Cliente cliente = new Cliente();
        cliente.setNombre(nombre);
        cliente.setIdentificacion(identificacion);
        cliente.setCorreo(correo);
        cliente.setDireccion(direccion);
        clientes.add(cliente);
    }

    public Cliente buscarCliente(int identificacion){
        for (int i = 0; i<clientes.size(); i++){
            if(clientes.get(i).getIdentificacion() == identificacion){
                return clientes.get(i);
            }
        }
        return null;
    }

    public List<Cliente> listarClientes(){
        return clientes;
    }
}
```

```java
public class ProductoOperacion {
    private List<Producto> productos = new ArrayList<>();

    public void registrarProducto(String codigo, String nombre, double precio, int stock) {
        Producto producto = new Producto();
        producto.setCodigo(codigo);
        producto.setNombre(nombre);
        producto.setPrecio(precio);
        producto.setStock(stock);
        productos.add(producto);
    }

    public Producto buscarProducto(String codigo){
        for (int i = 0; i<productos.size(); i++){
            if(productos.get(i).getCodigo().equals(codigo)){
                return productos.get(i);
            }
        }
        return null;
    }

    public List<Producto> listarProductos() {
        return productos;
    }
}
```

```java
public class FacturaOperacion {
    List<Factura> facturas = new ArrayList<>();

    public void registrarFactura(int consecutivo, LocalDate fecha, double impuesto, double subtotal,
                                 double total, List<Producto> productos, Cliente cliente){
        Factura factura = new Factura();
        factura.setConsecutivo(consecutivo);
        factura.setFecha(fecha);
        factura.setImpuesto(impuesto);
        factura.setSubtotal(subtotal);
        factura.setTotal(total);
        factura.setProductos(productos);
        factura.setCliente(cliente);
        facturas.add(factura);
    }

    public void agregarCliente(int consecutivo, Cliente cliente){
        for (int i = 0; i<facturas.size(); i++){
            if(facturas.get(i).getConsecutivo() == consecutivo){
                facturas.get(i).setCliente(cliente);
            }
        }
    }

    public Factura buscarFactura(int consecutivo){
        for(int i = 0; i<facturas.size(); i++){
            if(facturas.get(i).getConsecutivo()== consecutivo){
                return facturas.get(i);
            }
        }
        return null;
    }

    public void calcularImpuesto(int consecutivo){
        for(int i =0; i<facturas.size(); i++){
            if(facturas.get(i).getConsecutivo() == consecutivo){
                double impuesto = 0;
                for (int x = 0; x< facturas.get(i).getProductos().size(); x++){
                    double impuestoProducto = facturas.get(i).getProductos().get(x).getPrecio() * 19 / 100;
                    impuesto = impuesto + impuestoProducto;
                }
                facturas.get(i).setImpuesto(impuesto);
            }
        }
    }
    // agregarProducto, calcularSubtotal y calcularTotal siguen el mismo patrón de búsqueda por consecutivo
}
```

```java
public class Menu {
    private ClienteOperacion clienteOperacion = new ClienteOperacion();
    private ProductoOperacion productoOperacion = new ProductoOperacion();
    private FacturaOperacion facturaOperacion = new FacturaOperacion();

    public void mostrarMenu(){
        int opcion = 0;
        while(opcion != 15){
            // imprime el menú de opciones
            Scanner scanner = new Scanner(System.in);
            opcion = scanner.nextInt();
            switch (opcion){
                case 1 -> registrarCliente();
                case 2 -> buscarCliente();
                case 3 -> listarClientes();
                case 4 -> registrarProducto();
                case 5 -> buscarProducto();
                case 6 -> listarProductos();
                case 7 -> registrarFactura();
                case 8 -> agregarCliente();
            }
        }
    }
}
```

---

Para cada pregunta, observe cómo colaboran `Cliente`, `Producto`, `Factura`, `ClienteOperacion`, `ProductoOperacion`, `FacturaOperacion` y `Menu`. Marque **una sola** opción (A, B, C, D o E).

**Pregunta 1.** El usuario elige la opción 1 (Registrar Cliente) en el menú. ¿Cuál describe correctamente cómo colaboran las clases?

A. `Menu` crea el objeto `Cliente`, le asigna sus datos y lo agrega directamente a la lista `clientes` de `ClienteOperacion`.
B. `ClienteOperacion` lee los datos del teclado con `Scanner` y luego llama a `Menu.registrarCliente()` para guardarlos.
C. `Menu` lee los datos del teclado y llama a `clienteOperacion.registrarCliente(...)`; `ClienteOperacion` crea el `Cliente`, le asigna los datos con sus `set...` y lo agrega a su lista `clientes`.
D. `Cliente` se agrega a sí mismo a la lista de `ClienteOperacion` al ejecutarse su constructor.
E. `Menu` llama a `FacturaOperacion.registrarFactura(...)`, que a su vez crea el `Cliente`.

**Pregunta 2.** Para registrar una factura, `Menu` pide la identificación de un cliente y el código de un producto. ¿Cómo obtiene `Menu` los objetos que necesita para llamar a `facturaOperacion.registrarFactura(...)`?

A. Llama a `clienteOperacion.buscarCliente(identificacion)` y a `productoOperacion.buscarProducto(codigo)`, que devuelven el `Cliente` y el `Producto` ya registrados, y los pasa como parámetros a `FacturaOperacion`.
B. Crea con `new` un `Cliente` y un `Producto` nuevos con los datos digitados y los pasa a `FacturaOperacion`.
C. Llama a `facturaOperacion.buscarFactura(...)`, que consulta internamente a `ClienteOperacion` y `ProductoOperacion`.
D. Lee las listas `clientes` y `productos` directamente, porque son atributos públicos de `Menu`.
E. `FacturaOperacion` busca el cliente y el producto por sí misma, porque tiene atributos de tipo `ClienteOperacion` y `ProductoOperacion`.

**Pregunta 3.** La clase `Factura` tiene los atributos `private Cliente cliente;` y `private List<Producto> productos;`. Cuando `FacturaOperacion.registrarFactura(...)` ejecuta `factura.setCliente(cliente)` y `factura.setProductos(productos)`, ¿qué guarda la `Factura`?

A. Una copia independiente de cada objeto, por lo que `Cliente` y `Producto` dejan de existir en `ClienteOperacion` y `ProductoOperacion`.
B. Sólo la identificación del cliente y los códigos de los productos, como valores de texto.
C. Un nuevo `Cliente` y una nueva lista de `Producto` creados dentro de `Factura`.
D. Referencias a los mismos objetos `Cliente` y `Producto` que ya están almacenados en `ClienteOperacion` y `ProductoOperacion`; `Factura` los usa pero no los crea ni los guarda en una lista propia de entidades.
E. Referencias a `ClienteOperacion` y `ProductoOperacion`, a través de las cuales consulta los datos cada vez que los necesita.

**Pregunta 4.** Según los atributos de las clases del sistema, ¿cuál afirmación sobre la relacion entre los objetos es correcta?

A. Una `Factura` tiene exactamente un `Producto` y muchos `Cliente`.
B. Una `Factura` se asocia con un (1) `Cliente` y con una lista de varios (0..*) `Producto`; el mismo `Cliente` puede aparecer en varias facturas.
C. Un `Cliente` tiene una lista de `Factura` y cada `Factura` tiene una lista de `Cliente`.
D. Una `ClienteOperacion` tiene exactamente un `Cliente`, porque su método `registrarCliente` crea uno por llamada.
E. Un `Producto` almacena la `Factura` en la que fue vendido, por lo que sólo puede estar en una factura.

**Pregunta 5.** ¿Qué clase crea cada objeto del sistema (con `new`) y dónde se almacena?

A. `Menu` crea los objetos `Cliente`, `Producto` y `Factura`, y las clases `*Operacion` sólo los leen.
B. `App` crea las tres clases `*Operacion`, y cada una crea su propio `Menu`.
C. `Factura` crea los objetos `Cliente` y `Producto` que necesita y los guarda en sus atributos.
D. Cada entidad (`Cliente`, `Producto`, `Factura`) crea la clase `*Operacion` que la administra.
E. `App` crea el `Menu`; `Menu` crea una instancia de cada clase `*Operacion` como atributo; y cada `*Operacion` crea su entidad en el método `registrar...` y la guarda en su propia lista.

En todos los diagramas, el actor es el **Usuario** y el primer mensaje es la opción que invoca el método del `Menu` (puede partir desde `mostrarMenu()`). Indique los parámetros de cada mensaje y los retornos.

**Pregunta 6. Diagrama de secuencia: `registrarCliente`.**
Construya el diagrama del flujo `Menu.registrarCliente()` → `ClienteOperacion.registrarCliente(...)`. Debe mostrar la creación del objeto `Cliente`.

**Pregunta 7. Diagrama de secuencia: `buscarCliente`.**
Construya el diagrama de `Menu.buscarCliente()`. Debe incluir el ciclo (`loop`) de búsqueda en `ClienteOperacion.buscarCliente(identificacion)` y el fragmento `alt` para el caso encontrado (se muestran nombre, correo y dirección) y no encontrado (mensaje "CLIENTE NO FUE ENCONTRADO").

**Pregunta 8. Diagrama de secuencia: `registrarProducto`.**
Construya el diagrama de `Menu.registrarProducto()` → `ProductoOperacion.registrarProducto(...)`. Debe mostrar la solicitud de los cuatro datos (código, nombre, precio, stock), la creación del `Producto` y su almacenamiento.

**Pregunta 9. Diagrama de secuencia: `buscarProducto`.**
Construya el diagrama de `Menu.buscarProducto()`. Debe incluir el ciclo de búsqueda por código en `ProductoOperacion.buscarProducto(codigo)` y el fragmento condicional (`alt`) para el caso en que se encuentra el producto.
Adicionalmente, anote en el diagrama qué ocurre en el caso no encontrado.

**Pregunta 10. Diagrama de secuencia: `registrarFactura`.**
Construya el diagrama de `Menu.registrarFactura()`. Debe mostrar:
- La búsqueda del cliente (`ClienteOperacion.buscarCliente`) y la búsqueda del producto (`ProductoOperacion.buscarProducto`), cada una con su fragmento `alt` (encontrado / no encontrado).
- La solicitud de cantidad, consecutivo y fecha, dentro del `Menu`.
- La creación de la lista `productosFactura` y la llamada a `FacturaOperacion.registrarFactura(...)`, con la creación de `Factura`.

---
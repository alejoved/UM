import java.util.List;
import java.util.Scanner;

public class Menu {
    private ClienteOperacion clienteOperacion = new ClienteOperacion();
    private ProductoOperacion productoOperacion = new ProductoOperacion();
    private FacturaOperacion facturaOperacion = new FacturaOperacion();

    public void mostrarMenu(){
        int opcion = 0;
        while(opcion != 15){
            System.out.println("""
                ---SISTEMA DE FACTURACION---
                1. Registrar Cliente
                2. Buscar Cliente
                3. Listar Clientes

                4. Registrar Producto
                5. Buscar Producto
                6. Listar Productos

                7. Registrar Factura
                8. Agregar Cliente a Factura
                9. Agregar Producto a Factura
                10. Calcular Impuesto a Factura
                11. Calcular Subtotal a Factura
                12. Calcular Total a Factura
                13. Buscar Factura
                14. Listar Facturas

                15. Salir del Menu
                """);
            Scanner scanner = new Scanner(System.in);
            opcion = scanner.nextInt();
            switch (opcion){
                case 1 -> registrarCliente();
                case 2 -> buscarCliente();
                case 3 -> listarClientes();
                case 4 -> registrarProducto();
                case 5 -> buscarProducto();
                case 6 -> listarProductos();
                //case 7 -> registrarFactura();
                //case 8 -> agregarCliente();
                //case 9 -> agregarProducto();
                //case 10 -> calcularImpuesto();
                //case 11 -> calcularSubtotal();
                //case 12 -> calcularTotal();
                //case 13 -> buscarFactura();
                //case 14 -> listarFacturas();
            }
        }
    }

    public void registrarCliente(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("REGISTRAR CLIENTE");
        System.out.println("Ingrese el nombre");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese la identificacion");
        int identificacion = Integer.parseInt(scanner.nextLine());
        System.out.println("Ingrese el correo");
        String correo = scanner.nextLine();
        System.out.println("Ingrese la direccion"); 
        String direccion = scanner.nextLine();
        clienteOperacion.registrarCliente(nombre, identificacion, correo, direccion);
    }

    public void buscarCliente(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("BUSCAR CLIENTE");
        System.out.println("Ingrese la identificacion");
        int identificacion = Integer.parseInt(scanner.nextLine());
        Cliente cliente = clienteOperacion.buscarCliente(identificacion);
        if(cliente != null){
            System.out.println("Nombre: "+cliente.getNombre());
            System.out.println("Correo: "+cliente.getCorreo());
            System.out.println("Direccion: "+cliente.getDireccion());
        } else {
            System.out.println("CLIENTE NO FUE ENCONTRADO");
        }
    }

    public void listarClientes(){
        List<Cliente> clientes = clienteOperacion.listarClientes();
        for (int i = 0; i< clientes.size(); i++){
            System.out.println("Cliente Numero: " + (i+1));
            System.out.println("Nombre: "+clientes.get(i).getNombre());
            System.out.println("Correo: "+clientes.get(i).getCorreo());
            System.out.println("Direccion: "+clientes.get(i).getDireccion());
        }
    }

    public void registrarProducto(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("REGISTRAR PRODUCTO");
        System.out.println("Ingrese un codigo del producto");
        String codigo = scanner.nextLine();
        System.out.println("Ingrese el nombre del producto");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese el precio del producto");
        double precio = Double.parseDouble(scanner.nextLine());
        System.out.println("Ingrese el stock del producto");
        int stock = Integer.parseInt(scanner.nextLine());
        productoOperacion.registrarProducto(codigo, nombre, precio, stock);
    }

    public void buscarProducto(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("BUSCAR PRODUCTO");
        System.out.println("Ingrese el codigo del producto");
        String codigo = scanner.nextLine();
        Producto producto = productoOperacion.buscarProducto(codigo);
        if (producto != null){
            System.out.println("Nombre: "+producto.getNombre());
            System.out.println("Precio: "+producto.getPrecio());
            System.out.println("Stock: "+producto.getStock());
        }
    }

    public void listarProductos(){
        List<Producto> productos = productoOperacion.listarProductos();
        for(int i =0; i<productos.size(); i++){
            System.out.println("Producto Numero: " + (i+1));
            System.out.println("Nombre: " + productos.get(i).getNombre());
            System.out.println("Precio: " + productos.get(i).getPrecio());
            System.out.println("Stock: " + productos.get(i).getStock());
        }
    }
}

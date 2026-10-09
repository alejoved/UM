import java.util.List;
import java.util.ArrayList;

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

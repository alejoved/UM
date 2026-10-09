import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FacturaOperacion {
    List<Factura> facturas = new ArrayList<>();

    public void registrarFactura(int consecutivo, LocalDate fecha, double impuesto, double subtotal, double total, List<Producto> productos, Cliente cliente){
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

    public void agregarProducto(int consecutivo, Producto producto){
        for(int i =0; i<facturas.size(); i++){
            if(facturas.get(i).getConsecutivo() == consecutivo){
                facturas.get(i).getProductos().add(producto);
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

    public void calcularSubtotal(int consecutivo){
        for(int i =0; i<facturas.size(); i++){
            if(facturas.get(i).getConsecutivo() == consecutivo){
                double subtotal = 0;
                for(int x = 0; x < facturas.get(i).getProductos().size(); x++){
                    subtotal= subtotal + facturas.get(i).getProductos().get(x).getPrecio();
                }
                facturas.get(i).setSubtotal(subtotal);
            }
        }
    }

    public void calcularTotal(int consecutivo){
        for(int i =0; i<facturas.size(); i++){
            if(facturas.get(i).getConsecutivo() == consecutivo){
                double subtotal = facturas.get(i).getSubtotal();
                double impuesto = facturas.get(i).getImpuesto();
                double total = subtotal + impuesto;
                facturas.get(i).setTotal(total);
            }
        }
    }


}

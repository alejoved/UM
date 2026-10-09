import java.util.ArrayList;
import java.util.List;

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
}

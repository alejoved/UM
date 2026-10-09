public class Cliente {
    private String nombre;
    private int identificacion;
    private String correo;
    private String direccion;
    
    public String getNombre(){
        return nombre;
    }

    public int getIdentificacion(){
        return identificacion;
    }

    public String getCorreo(){
        return correo;
    }

    public String getDireccion(){
        return direccion;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public void setIdentificacion(int identificacion){
        this.identificacion = identificacion;
    }

    public void setCorreo(String correo){
        this.correo = correo;
    }

    public void setDireccion(String direccion){
        this.direccion = direccion;
    }
}

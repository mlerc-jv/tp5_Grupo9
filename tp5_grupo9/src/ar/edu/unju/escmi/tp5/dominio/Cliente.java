package ar.edu.unju.escmi.tp5.dominio;

public abstract class Cliente {

    private String apellido;
    private String nombre;
    private String direccion;

    public Cliente(String apellido, String nombre, String direccion) {
        this.apellido = apellido;
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Apellido: " + apellido
                + ", Nombre: " + nombre
                + ", Direccion: " + direccion;
    }
}
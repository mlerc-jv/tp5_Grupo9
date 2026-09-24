package ar.edu.unju.escmi.tp5.dominio;

public abstract class Cliente {

    private String apellido;
    private String nombre;
    private String telefono;

    public Cliente(String apellido, String nombre, String telefono) {
        this.apellido = apellido;
        this.nombre = nombre;
        this.telefono = telefono;
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Apellido: " + apellido
                + ", Nombre: " + nombre
                + ", Telefono: " + telefono;
    }
}
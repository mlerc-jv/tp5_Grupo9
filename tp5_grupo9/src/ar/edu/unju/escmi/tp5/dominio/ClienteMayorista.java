package ar.edu.unju.escmi.tp5.dominio;

public class ClienteMayorista extends Cliente {

    private Integer codigo;

    public ClienteMayorista(String apellido, String nombre, String telefono, Integer codigo) {
        super(apellido, nombre, telefono);
        this.codigo = codigo;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return super.toString()
                + ", Codigo de cliente: " + codigo;
    }
}
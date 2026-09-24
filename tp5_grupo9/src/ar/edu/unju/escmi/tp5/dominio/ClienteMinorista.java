package ar.edu.unju.escmi.tp5.dominio;

public class ClienteMinorista extends Cliente {

    private Integer dni;
    private String obraSocial;

    public ClienteMinorista(String apellido, String nombre, String telefono, Integer dni, String obraSocial) {
        super(apellido, nombre, telefono);
        this.dni = dni;
        this.obraSocial = obraSocial;
    }

    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
    }

    public String getObraSocial() {
        return obraSocial;
    }

    public void setObraSocial(String obraSocial) {
        this.obraSocial = obraSocial;
    }

    @Override
    public String toString() {
        return super.toString()
                + ", DNI: " + dni
                + ", Obra social: " + obraSocial;
    }
}
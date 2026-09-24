package ar.edu.unju.escmi.tp5.dominio;

public class Empleado {
	private int legajo;
	private String nombre;
	private String apellido;
public Empleado (int legajo, String nombre, String apellido) {
	this.legajo=legajo;
	this.nombre=nombre;
	this.apellido=apellido;
}
public int getLegajo() {
	return legajo;
}
public void setLegajo(int legajo) {
	this.legajo = legajo;
}
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public String getApellido() {
	return apellido;
}
public void setApellido(String apellido) {
	this.apellido = apellido;
}

}


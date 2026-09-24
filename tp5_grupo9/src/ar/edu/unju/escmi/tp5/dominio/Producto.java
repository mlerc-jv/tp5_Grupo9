package ar.edu.unju.escmi.tp5.dominio;

public class Producto {

	private int codigoProducto;
	private String descripcion;
	private double precioUnitario;
	private int descuento;

	public Producto(int codigoProducto, String descripcion, double precioUnitario, int descuento) {
		super();
		this.codigoProducto = codigoProducto;
		this.descripcion = descripcion;
		this.precioUnitario = precioUnitario;
		this.descuento = descuento;
	}

	public int getCodigoProducto() {
		return codigoProducto;
	}

	public void setCodigoProducto(int codigoProducto) {
		this.codigoProducto = codigoProducto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	public int getDescuento() {
		return descuento;
	}

	public void setDescuento(int descuento) {
		this.descuento = descuento;
	}
	
	@Override
	public String toString() {
		return "Producto [codigoProducto=" + codigoProducto + ", descripcion=" + descripcion + ", precioUnitario="
				+ precioUnitario + ", descuento=" + descuento + "]";
	}
}


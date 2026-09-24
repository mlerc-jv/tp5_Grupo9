package ar.edu.unju.escmi.tp5.dominio;

public class DetalleFactura {
	private int cantidad;
	private Producto producto;
	private double precioUnitario;
	private double importe;
public DetalleFactura(int cantidad, Producto producto, double precioUnitario, double importe) {
	this.cantidad=cantidad;
	this.producto=producto;
	this.precioUnitario=precioUnitario;
	this.importe=importe;
}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	public double getPrecioUnitario() {
		return precioUnitario;
	}
	public void setPrecioUnitario(double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}
	public double getImporte() {
		return importe;
	}
	public void setImporte(double importe) {
		this.importe = importe;
	}
	
}

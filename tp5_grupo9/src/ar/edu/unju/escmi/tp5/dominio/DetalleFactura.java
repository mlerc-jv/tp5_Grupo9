package ar.edu.unju.escmi.tp5.dominio;
public class DetalleFactura {
	private int cantidad;
	private Producto producto;
	private double precioUnitario;
	private double importe;
 public DetalleFactura(int cantidad, Producto producto) {
	this.cantidad=cantidad;
	this.producto=producto;
	this.precioUnitario=calcularPrecioUnitario();
	this.importe=calcularImporte();
}
	public double calcularPrecioUnitario() {
		return producto.getPrecioUnitario() * (1 - producto.getDescuento() / 100.0);
	}
	public double calcularImporte() {
		return cantidad * precioUnitario;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
		this.importe = calcularImporte();
	}
	public Producto getProducto() {
		return producto;
	}
	public double getPrecioUnitario() {
		return precioUnitario;
	}
	public double getImporte() {
		return importe;
	}
	@Override
	public String toString() {
		return String.format("%-6d %-25s $%10.2f $%10.2f", cantidad, producto.getDescripcion(), precioUnitario, importe);
	}
	
}

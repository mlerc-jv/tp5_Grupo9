package ar.edu.unju.escmi.tp5.dominio;

public class Stock {
	
	private Producto producto;
	private int cantidad;
	
	public Stock(Producto producto, int cantidad) {
		super();
		this.producto = producto;
		this.cantidad = cantidad;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	public void actualizarStock(int cantidad) {
		this.cantidad = cantidad;
	}

	@Override
	public String toString() {
		return "Stock [producto=" + producto + ", cantidad=" + cantidad + "]";
	}
	
}

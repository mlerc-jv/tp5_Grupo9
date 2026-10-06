package ar.edu.unju.escmi.tp5.dominio;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
public class Factura {
	private int numeroFactura;
	private Cliente cliente;
	private LocalDate fecha;
	private double total;
	private ArrayList<DetalleFactura> detalles;
public Factura(int numeroFactura, Cliente cliente, LocalDate fecha) {
	this.numeroFactura=numeroFactura;
	this.cliente=cliente;
	this.fecha=fecha;
	this.total=0;
	this.detalles=new ArrayList<>();
}
	public void agregarDetalle(DetalleFactura detalle) {
		detalles.add(detalle);
		calcularTotal();
	}
	public double calcularSubtotal() {
		double subtotal = 0;
		for (DetalleFactura detalle : detalles) {
			subtotal += detalle.getImporte();
		}
		return subtotal;
	}
	public double calcularDescuento() {
		return calcularSubtotal() * cliente.getDescuento();
	}
	public double calcularTotal() {
		total = calcularSubtotal() - calcularDescuento();
		return total;
	}
	public int getNumeroFactura() {
		return numeroFactura;
	}
	public void setNumeroFactura(int numeroFactura) {
		this.numeroFactura = numeroFactura;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public double getTotal() {
		return total;
	}
	public ArrayList<DetalleFactura> getDetalles() {
		return detalles;
	}
	@Override
	public String toString() {
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String texto = "===== FACTURA N° " + numeroFactura + " =====\n"
				+ "Fecha: " + fecha.format(formato) + "\n"
				+ "Cliente: " + cliente.getApellido() + ", " + cliente.getNombre() + "\n"
				+ "Dirección: " + cliente.getDireccion() + "\n"
				+ String.format("%-6s %-25s %11s %11s%n", "Cant.", "Producto", "P. Unit.", "Importe");
		for (DetalleFactura detalle : detalles) {
			texto += detalle + "\n";
		}
		texto += String.format("Subtotal:  $%.2f%n", calcularSubtotal())
				+ String.format("Descuento: $%.2f%n", calcularDescuento())
				+ String.format("TOTAL:     $%.2f", total);
		return texto;
	}
}

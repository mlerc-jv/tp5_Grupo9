package ar.edu.unju.escmi.tp5.dominio;
import java.time.LocalDate;
import java.util.ArrayList;
public class Factura {
	private int numeroFactura;
	private Cliente cliente;
	private LocalDate fecha;
	private double total;
	private ArrayList<DetalleFactura> detalles;
public Factura(int numeroFactura, Cliente cliente, LocalDate fecha, double total, ArrayList<DetalleFactura>detalles) {
	this.numeroFactura=numeroFactura;
	this.cliente=cliente;
	this.fecha=fecha;
	this.total=total;
	this.detalles=detalles;
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
	public void setTotal(double total) {
		this.total = total;
	}
	public ArrayList<DetalleFactura> getDetalles() {
		return detalles;
	}
	public void setDetalles(ArrayList<DetalleFactura> detalles) {
		this.detalles = detalles;
	}
	
}

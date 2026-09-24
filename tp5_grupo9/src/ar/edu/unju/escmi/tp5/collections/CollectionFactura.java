package ar.edu.unju.escmi.tp5.collections;
import java.util.ArrayList;
import ar.edu.unju.escmi.tp5.dominio.Factura;
public class CollectionFactura {
	public static ArrayList<Factura> facturas = new ArrayList<>();
	public static void agregarFactura(Factura factura) {
		facturas.add(factura);
	}
	public static Factura buscarFactura(int numeroFactura) {
		for (Factura factura : facturas) {
			if(factura.getNumeroFactura()==numeroFactura) {
				return factura;
			}
		}
		return null;
	}
		
}

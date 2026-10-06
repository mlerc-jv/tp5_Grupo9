package ar.edu.unju.escmi.tp5.collections;

import java.util.ArrayList;

import ar.edu.unju.escmi.tp5.dominio.Producto;

public class CollectionProducto {
	
	public static ArrayList<Producto> collection = new ArrayList<>();

	public static Producto buscarProducto(int codigoProducto) {
		for (Producto producto : collection) {
			if (producto.getCodigoProducto() == codigoProducto) {
				return producto;
			}
		}
		return null;
	}
	
	public static boolean agregarProducto(Producto producto) {
		if (buscarProducto(producto.getCodigoProducto()) == null) {
			collection.add(producto);
			return true;
		}
		return false;
	}
	public static void precargarProductos() {

	    Producto producto1 = new Producto(1001, "Aceite legitimo girasol 1,5lt", 4899.0, 30);
	    Producto producto2 = new Producto(1002, "Arroz Primor 1kg", 1099.0, 25);
	    Producto producto3 = new Producto(1003, "Mayonesa Hellmans 237gr", 1699.39, 0);
	    Producto producto4 = new Producto(1004, "Sal fina Celusal 500gr", 1262.0, 25);
	    Producto producto5 = new Producto(1005, "Te La Virginia 20 saq", 2079.0, 0);

	    agregarProducto(producto1);
	    agregarProducto(producto2);
	    agregarProducto(producto3);
	    agregarProducto(producto4);
	    agregarProducto(producto5);
	}
	
}

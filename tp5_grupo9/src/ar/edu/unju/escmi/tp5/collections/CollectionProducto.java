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
	
}

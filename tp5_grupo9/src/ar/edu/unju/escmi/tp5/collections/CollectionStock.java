package ar.edu.unju.escmi.tp5.collections;

import java.util.ArrayList;

import ar.edu.unju.escmi.tp5.dominio.Stock;

public class CollectionStock {
	
	public static ArrayList<Stock> collection = new ArrayList<>();

	public static Stock buscarStock(int codigoProducto) {
		for (Stock stock : collection) {
			if (stock.getProducto().getCodigoProducto() == codigoProducto) {
				return stock;
			}
		}
		return null;
	}
	
	public static boolean agregarStock(Stock stock) {
		if (buscarStock(stock.getProducto().getCodigoProducto()) == null) {
			collection.add(stock);
			return true;
		}
		return false;
	}
	
	public static boolean actualizarStock(int codigoProducto, int cantidad) {
		Stock stock = buscarStock(codigoProducto);
		if (stock != null) {
			stock.actualizarStock(cantidad);
			return true;
		}
		return false;
	}
	
}

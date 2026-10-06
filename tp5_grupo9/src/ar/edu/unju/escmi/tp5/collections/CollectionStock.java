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
	public static void precargarStock() {

	    Stock stock1 = new Stock(CollectionProducto.buscarProducto(1001), 4000);
	    Stock stock2 = new Stock(CollectionProducto.buscarProducto(1002), 3000);
	    Stock stock3 = new Stock(CollectionProducto.buscarProducto(1003), 3500);
	    Stock stock4 = new Stock(CollectionProducto.buscarProducto(1004), 5000);
	    Stock stock5 = new Stock(CollectionProducto.buscarProducto(1005), 2500);

	    agregarStock(stock1);
	    agregarStock(stock2);
	    agregarStock(stock3);
	    agregarStock(stock4);
	    agregarStock(stock5);
	}
}

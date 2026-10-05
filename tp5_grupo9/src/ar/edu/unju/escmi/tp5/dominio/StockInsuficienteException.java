package ar.edu.unju.escmi.tp5.dominio;

/** Se lanza cuando se intenta vender más unidades de las que hay en stock. */
public class StockInsuficienteException extends Exception {

    public StockInsuficienteException(Producto producto, int pedido, int disponible) {
        super("Stock insuficiente de '" + producto.getNombre() + "': se pidieron "
                + pedido + " y hay " + disponible);
    }
}
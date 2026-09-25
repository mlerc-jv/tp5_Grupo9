package ar.edu.unju.escmi.tp5.dominio;

/**
 * Una línea de la venta: qué producto, cuántas unidades y a qué precio.
 * El precio se guarda al momento de la venta, así si después cambia
 * el precio del producto, las ventas viejas no se modifican.
 */
public record ItemVenta(Producto producto, int cantidad, double precioUnitario) {

    public ItemVenta {
        if (producto == null) throw new IllegalArgumentException("El producto no puede ser nulo");
        if (cantidad <= 0) throw new IllegalArgumentException("La cantidad debe ser mayor a 0");
        if (precioUnitario < 0) throw new IllegalArgumentException("El precio no puede ser negativo");
    }

    public double subtotal() {
        return precioUnitario * cantidad;
    }

    @Override
    public String toString() {
        return String.format("  %-20s x%3d  $%10.2f  = $%10.2f",
                producto.getNombre(), cantidad, precioUnitario, subtotal());
    }
}
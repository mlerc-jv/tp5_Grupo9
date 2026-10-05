package ar.edu.unju.escmi.tp5.dominio;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Venta {

    private static int contador = 1;
    private static final DateTimeFormatter FORMATO = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    private int numero; // se asigna al confirmar, así las ventas fallidas no "gastan" números
    private final Cliente cliente;
    private final LocalDateTime fecha;
    private final List<ItemVenta> items = new ArrayList<>();
    private boolean confirmada = false;

    public Venta(Cliente cliente) {
        if (cliente == null) throw new IllegalArgumentException("La venta necesita un cliente");
        this.cliente = cliente;
        this.fecha = LocalDateTime.now();
    }

    /** Agrega un producto. Si ya estaba en la venta, suma la cantidad. */
    public void agregarItem(Producto producto, int cantidad) {
        if (confirmada) throw new IllegalStateException("No se puede modificar una venta ya realizada");

        for (int i = 0; i < items.size(); i++) {
            ItemVenta item = items.get(i);
            if (item.producto().getCodigo() == producto.getCodigo()) {
                items.set(i, new ItemVenta(producto, item.cantidad() + cantidad, item.precioUnitario()));
                return;
            }
        }
        items.add(new ItemVenta(producto, cantidad, producto.getPrecio()));
    }

    public double calcularSubtotal() {
        return items.stream().mapToDouble(ItemVenta::subtotal).sum();
    }

    /** El porcentaje lo decide cada tipo de cliente (polimorfismo): mayorista o minorista. */
    public double calcularDescuento() {
        return calcularSubtotal() * cliente.getDescuento();
    }

    public double calcularTotal() {
        return calcularSubtotal() - calcularDescuento();
    }

    /** La llama CollectionVenta cuando la venta se registra con éxito. No llamarla a mano. */
    public void confirmar() {
        this.numero = contador++;
        this.confirmada = true;
    }

    public int getNumero()              { return numero; }
    public Cliente getCliente()         { return cliente; }
    public LocalDateTime getFecha()     { return fecha; }
    public boolean isConfirmada()       { return confirmada; }
    public List<ItemVenta> getItems()   { return Collections.unmodifiableList(items); }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Venta N° ").append(numero)
          .append(" | ").append(fecha.format(FORMATO))
          .append(" | Cliente: ").append(cliente.getNombre())
          .append(" (").append(cliente.getTipo()).append(")\n");
        items.forEach(item -> sb.append(item).append('\n'));
        sb.append(String.format("  Subtotal:  $%10.2f%n", calcularSubtotal()));
        sb.append(String.format("  Descuento: $%10.2f (%.0f%%)%n", calcularDescuento(), cliente.getDescuento() * 100));
        sb.append(String.format("  TOTAL:     $%10.2f", calcularTotal()));
        return sb.toString();
    }
}
package ar.edu.unju.escmi.tp5.collections;

import ar.edu.unju.escmi.tp5.dominio.Cliente;
import ar.edu.unju.escmi.tp5.dominio.ItemVenta;
import ar.edu.unju.escmi.tp5.dominio.StockInsuficienteException;
import ar.edu.unju.escmi.tp5.dominio.Venta;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class CollectionVenta {

    private final List<Venta> ventas = new ArrayList<>();
    private final CollectionStock stock;

    public CollectionVenta(CollectionStock stock) {
        this.stock = stock;
    }

    /**
     * Realiza la venta: primero verifica el stock de TODOS los productos
     * y recién después descuenta. Así, si falta un producto, no queda
     * el stock descontado a medias.
     */
    public Venta realizarVenta(Venta venta) throws StockInsuficienteException {
        if (venta.isConfirmada()) throw new IllegalStateException("La venta ya fue realizada");
        if (venta.getItems().isEmpty()) throw new IllegalArgumentException("La venta no tiene productos");

        // 1) Verificar
        for (ItemVenta item : venta.getItems()) {
            if (!stock.hayStock(item.producto(), item.cantidad())) {
                throw new StockInsuficienteException(item.producto(), item.cantidad(),
                        stock.consultarStock(item.producto()));
            }
        }
        // 2) Descontar (actualización automática del stock)
        for (ItemVenta item : venta.getItems()) {
            stock.descontar(item.producto(), item.cantidad());
        }

        venta.confirmar();
        ventas.add(venta);
        return venta;
    }

    public void mostrarVentas() {
        if (ventas.isEmpty()) {
            System.out.println("No hay ventas registradas.");
            return;
        }
        ventas.forEach(v -> System.out.println(v + "\n"));
    }

    public double calcularTotalVentas() {
        return ventas.stream().mapToDouble(Venta::calcularTotal).sum();
    }

    public Optional<Venta> buscarPorNumero(int numero) {
        return ventas.stream().filter(v -> v.getNumero() == numero).findFirst();
    }

    public List<Venta> ventasDeCliente(Cliente cliente) {
        return ventas.stream().filter(v -> v.getCliente().getId() == cliente.getId()).toList();
    }

    public List<Venta> getVentas() {
        return Collections.unmodifiableList(ventas);
    }
}
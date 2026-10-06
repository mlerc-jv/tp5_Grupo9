package ar.edu.unju.escmi.tp5.dominio;

import java.util.Scanner;
import ar.edu.unju.escmi.tp5.collections.CollectionProducto;
import ar.edu.unju.escmi.tp5.collections.CollectionFactura;
import ar.edu.unju.escmi.tp5.collections.CollectionCliente;
import ar.edu.unju.escmi.tp5.collections.CollectionStock;
public class AgenteAdministrativo extends Empleado {
public AgenteAdministrativo (int legajo, String nombre, String apellido) {
	super (legajo, nombre, apellido);
}
public static boolean altaProducto(Producto producto) {
    return CollectionProducto.agregarProducto(producto);
}
public static Cliente identificarCliente(int tipoCliente, int identificador) {
	for (Cliente cliente : CollectionCliente.clientes) {
		if (tipoCliente == 1 && cliente instanceof ClienteMayorista) {
			ClienteMayorista clienteMayorista =
                    (ClienteMayorista) cliente;
			if (clienteMayorista.getCodigo() == identificador) {
                return cliente;
            }
        }
		if (tipoCliente == 2 && cliente instanceof ClienteMinorista) {
			ClienteMinorista clienteMinorista = (ClienteMinorista) cliente;
			if (clienteMinorista.getDni() == identificador) {
                return cliente;
            }
        }
    }
	return null;
}
public static Factura realizarVenta(Scanner sc, Cliente cliente) {

    int numeroFactura = CollectionFactura.facturas.size() + 1;

    Factura factura = new Factura(
            numeroFactura,
            cliente,
            java.time.LocalDate.now()
    );

    boolean seguirComprando = true;
    boolean hayDetalles = false;

    while (seguirComprando) {

        System.out.println("Ingrese el codigo del producto: ");
        int codigoProducto = sc.nextInt();

        Producto producto =
                CollectionProducto.buscarProducto(codigoProducto);

        if (producto == null) {
            System.out.println("Producto no encontrado");
            continue;
        }

        Stock stock =
                CollectionStock.buscarStock(codigoProducto);

        if (stock == null) {
            System.out.println("El producto no tiene stock registrado");
            continue;
        }

        System.out.println("Producto: " + producto.getDescripcion());
        System.out.println("Stock disponible: " + stock.getCantidad());

        int cantidad;

        if (cliente instanceof ClienteMayorista) {
            System.out.println("Ingrese la cantidad de bultos:");
        } else {
            System.out.println("Ingrese la cantidad de unidades:");
        }

        cantidad = sc.nextInt();

        if (cantidad <= 0) {
            System.out.println("La cantidad debe ser mayor a 0.");
            continue;
        }

        int cantidadReal = cantidad;

        if (cliente instanceof ClienteMayorista) {
            cantidadReal = cantidad * 10;
        }

        try {

            if (stock.getCantidad() < cantidadReal) {

                throw new StockInsuficienteException(producto,cantidadReal,stock.getCantidad());
            }

            DetalleFactura detalle =
                    new DetalleFactura(cantidadReal, producto);

            factura.agregarDetalle(detalle);

            int nuevoStock =
                    stock.getCantidad() - cantidadReal;

            CollectionStock.actualizarStock(
                    codigoProducto,
                    nuevoStock
            );

            hayDetalles = true;

            System.out.println("Producto agregado correctamente");
            System.out.println("Importe: $" + detalle.getImporte());

            System.out.println("¿Desea agregar otro producto? (s/n)");
            String respuesta = sc.next();

            seguirComprando =
                    respuesta.equalsIgnoreCase("s");

        } catch (StockInsuficienteException e) {

            System.out.println(e.getMessage());

            System.out.println(
                    "¿Desea intentar con otro producto? (s/n)"
            );

            String respuesta = sc.next();

            seguirComprando =
                    respuesta.equalsIgnoreCase("s");
        }
    }

    if (hayDetalles) {

        factura.calcularTotal();
        CollectionFactura.agregarFactura(factura);

        return factura;
    }

    return null;
}
}

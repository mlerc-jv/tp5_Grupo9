package ar.edu.unju.escmi.tp5.principal;
import ar.edu.unju.escmi.tp5.collections.CollectionCliente;
import ar.edu.unju.escmi.tp5.collections.CollectionEmpleado;

import ar.edu.unju.escmi.tp5.collections.CollectionFactura;
import ar.edu.unju.escmi.tp5.collections.CollectionStock;

import ar.edu.unju.escmi.tp5.dominio.Factura;
import ar.edu.unju.escmi.tp5.dominio.Stock;

import ar.edu.unju.escmi.tp5.dominio.DetalleFactura;

import ar.edu.unju.escmi.tp5.dominio.AgenteAdministrativo;
import ar.edu.unju.escmi.tp5.collections.CollectionProducto;
import ar.edu.unju.escmi.tp5.dominio.Producto;

import ar.edu.unju.escmi.tp5.dominio.Cliente;

import java.util.Scanner;
public class Principal {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CollectionCliente.precargarClientes();																																																								
		CollectionEmpleado.precargarEmpleados();
		CollectionProducto.precargarProductos();
		CollectionStock.precargarStock();
		
	Scanner sc = new Scanner (System.in);
	int opcion;
	do {
		System.out.println("MENU PRINCIPAL");
		System.out.println("1. Encargado de ventas");
		System.out.println("2. Cliente");
		System.out.println("3. Agente administrativo");
		System.out.println("0. Salir");
		System.out.println("Seleccione una opcion: ");
		opcion = sc.nextInt();
		switch(opcion) {
		case 1:{
			int opcionEncargado;
			do {
				System.out.println("MENU ENCARGADO DE VENTAS");
				System.out.println("1. Mostrar ventas");
				System.out.println("2. Mostrar total de ventas");
				System.out.println("3. Consultar stock por codigo");
				System.out.println("0. Volver");
				System.out.println("Selecciona una opcion: ");
				opcionEncargado=sc.nextInt();
				switch(opcionEncargado){
				case 1: 
					System.out.println("VENTAS REALIZADAS");
					if(CollectionFactura.facturas.isEmpty()) {
					System.out.println("No hay ventas registradas");
					}else {
					for (Factura factura:CollectionFactura.facturas) {
						System.out.println("Numero de factura: " + factura.getNumeroFactura());
						System.out.println("Cliente: " + factura.getCliente().getApellido()+", "+factura.getCliente().getNombre());
						System.out.println("Fecha: " + factura.getFecha());
						System.out.println("Total: $ " + factura.getTotal());
						System.out.println("------------------------------------------");
						}
					}
					break;
					case 2: 
						double totalVentas=0;
						for(Factura factura : CollectionFactura.facturas) {
							totalVentas += factura.getTotal();
							}
						System.out.println("Total de todas las ventas: $ "+totalVentas);
						break;
					case 3:
						System.out.println("Ingrese codigo del producto: ");
						int codigoProducto = sc.nextInt();
						Stock stock = CollectionStock.buscarStock(codigoProducto);
						if (stock != null) {
							System.out.println("Producto: "+ stock.getProducto().getDescripcion());
							System.out.println("Cantidad disponible: "+ stock.getCantidad());
							}else {
								System.out.println("No se encontro stock para ese producto");
								}
						break;
					case 0:
						System.out.println("Volviendo al menu principal...");
						break;
					default:
						System.out.println("opcion invalida");
				}
			}while(opcionEncargado !=0 );
			break;
		}
		case 2:{
			int numeroFactura;
			System.out.println("MENU CLIENTE");
			System.out.println("Ingrese el numero de factura: ");
			numeroFactura = sc.nextInt();
			Factura factura = CollectionFactura.buscarFactura(numeroFactura);
			if (factura != null) {
				System.out.println("FACTURA");
				System.out.println("Numero de factura: " + factura.getNumeroFactura());
				System.out.println("Cliente: " + factura.getCliente().getApellido()+", "+factura.getCliente().getNombre());
				System.out.println("Direccion: "+ factura.getCliente().getDireccion());
				System.out.println("Fecha: "+ factura.getFecha());
				System.out.println("DETALLE");
				for(DetalleFactura detalle : factura.getDetalles()) {
					System.out.println("Producto: "+ detalle.getProducto().getDescripcion());
					System.out.println("Cantidad: "+ detalle.getCantidad());
					System.out.println("Precio unitario: "+detalle.getPrecioUnitario());
					System.out.println("Importe: $" + detalle.getImporte());
					System.out.println("---------------------------");
				}
				System.out.println("TOTAL: $" + factura.getTotal());
			}else {
				System.out.println("No se encontro una factura con ese numero");
			}
			break;
		}
        case 3:{
        	int opcionAdministrativo;
        	do {
        		System.out.println("MENU AGENTE ADMINISTRATIVO");
        		System.out.println("1. Agregar producto");
        		System.out.println("2. Realizar venta");
        		System.out.println("0. volver");
        		System.out.println("Seleccione una opcion: ");
        		opcionAdministrativo = sc.nextInt();
        		switch (opcionAdministrativo) {
        		case 1:{
        			System.out.println("ALTA DE PRODUCTO");
        			System.out.println("Ingrese el codigo del producto: ");
        		    int codigoProducto = sc.nextInt();
        		    if (CollectionProducto.buscarProducto(codigoProducto) != null) {
        		    	System.out.println("Ya existe un producto con ese codigo.");
        		    	} else {
        		    		System.out.println("Ingrese la descripcion: ");
        		    		sc.nextLine();
        		    		String descripcion = sc.nextLine();
        		    		System.out.println("Ingrese el precio unitario: ");
        		    		double precioUnitario = sc.nextDouble();
        		    		if (precioUnitario <= 0) {
        		    			System.out.println("El precio debe ser mayor a 0.");
        		    		} else {
        		    			int descuento;
        		    		do {
        		                System.out.println("Ingrese descuento (0, 25 o 30): ");
        		                descuento = sc.nextInt();
        		                if (descuento != 0 && descuento != 25 && descuento != 30) {
        		                    System.out.println("Valor invalido. Solo se permite 0, 25 o 30.");
        		                }
        		             } while (descuento != 0 && descuento != 25 && descuento != 30);
        		    		System.out.println("Ingrese stock inicial: ");
        		            int stockInicial = sc.nextInt();
        		            if (stockInicial <= 0) {
        		            	System.out.println("El stock debe ser mayor a 0.");
        		            } else {
        		            	Producto productoNuevo = new Producto(codigoProducto,descripcion,precioUnitario,descuento);
        		            	boolean productoAgregado =
        		                        AgenteAdministrativo.altaProducto(productoNuevo);
        		            	if (productoAgregado) {Stock stockNuevo = new Stock(productoNuevo,stockInicial);
        		            	   CollectionStock.agregarStock(stockNuevo);
        		            	   System.out.println("Producto dado de alta correctamente.");
        		            	} else {
        		            		System.out.println("No se pudo agregar el producto.");
        		                }
        		            }
        		        }
        		    }
        		    break;
        		}
        		case 2:{
        			System.out.println("REALIZAR VENTA");
        			System.out.println("Seleccione el tipo de cliente:");
        		    System.out.println("1. Mayorista");
        		    System.out.println("2. Minorista");
        		    System.out.print("Opcion: ");
        		    int tipoCliente = sc.nextInt();

        		    if (tipoCliente != 1 && tipoCliente != 2) {
        		        System.out.println("Tipo de cliente invalido");
        		        break;
        		    }

        		    if (tipoCliente == 1) {
        		        System.out.print("Ingrese el codigo del cliente: ");
        		    } else {
        		        System.out.print("Ingrese el DNI del cliente: ");
        		    }

        		    int identificador = sc.nextInt();

        		    Cliente cliente =
        		            AgenteAdministrativo.identificarCliente(tipoCliente,identificador);

        		    if (cliente == null) {
        		        System.out.println("Cliente no encontrado");
        		        break;
        		    }

        		    Factura factura =
        		            AgenteAdministrativo.realizarVenta(sc, cliente);

        		    if (factura != null) {
        		        System.out.println(factura);
        		    } else {
        		        System.out.println("No se genero la factura porque no hay productos");
        		    }
        		    break;
        		}
        		case 0:
        			System.out.println("Volviendo al menu principal...");
        			break;
        		default:
        			System.out.println("Opcion invalida");
        		}
        		} while (opcionAdministrativo != 0);
        	break;
        }
        case 0:
        	System.out.println("Programa finalizado");
        	break;

        default:
        	System.out.println("Opcion invalida");
    }

} while (opcion != 0);
sc.close();
}
}
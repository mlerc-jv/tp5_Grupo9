package ar.edu.unju.escmi.tp5.collections;

import java.util.ArrayList;

import ar.edu.unju.escmi.tp5.dominio.Cliente;
import ar.edu.unju.escmi.tp5.dominio.ClienteMayorista;
import ar.edu.unju.escmi.tp5.dominio.ClienteMinorista;

public class CollectionCliente {

    public static ArrayList<Cliente> clientes = new ArrayList<>();

    public static void agregarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public static void precargarClientes() {

        ClienteMayorista cliente1 = new ClienteMayorista(
                "Gomez",
                "Juan",
                "3884000000",
                1001
        );

        ClienteMayorista cliente2 = new ClienteMayorista(
                "Lopez",
                "Carlos",
                "3884111111",
                1002
        );

        ClienteMinorista cliente3 = new ClienteMinorista(
                "Maidana",
                "Ana",
                "3884222222",
                30123456,
                "PAMI"
        );

        ClienteMinorista cliente4 = new ClienteMinorista(
                "Perez",
                "Maria",
                "3884333333",
                31234567,
                "OSDE"
        );

        clientes.add(cliente1);
        clientes.add(cliente2);
        clientes.add(cliente3);
        clientes.add(cliente4);
    }
}
package ar.edu.unju.escmi.tp5.collections;
import java.util.ArrayList;
import ar.edu.unju.escmi.tp5.dominio.Empleado;
import ar.edu.unju.escmi.tp5.dominio.EncargadoVentas;
import ar.edu.unju.escmi.tp5.dominio.AgenteAdministrativo;
public class CollectionEmpleado {
	public static ArrayList<Empleado> empleados = new ArrayList<>();
	public static void precargarEmpleados() {
		EncargadoVentas empleado1=new EncargadoVentas(101, "Aidan", "Gallardo");
		AgenteAdministrativo empleado2=new AgenteAdministrativo(102,"Lili", "Reinoso");
		empleados.add(empleado1);
		empleados.add(empleado2);
}
}

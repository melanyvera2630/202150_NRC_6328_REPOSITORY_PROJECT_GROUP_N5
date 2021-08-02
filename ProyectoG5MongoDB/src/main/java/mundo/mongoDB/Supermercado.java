package mundo.mongoDB;

import java.util.List;

public class Supermercado {

	//Atributos
	private int idSupermercado;
	private String nombreSupermercado;

	//Asociaciones
	private List<Cliente> clientes;
	private List<Producto> productos;
	private List<Empleado> empleados;


	//Constructor

	public Supermercado (int id, String nombre) {
		this.idSupermercado = id;
		this.nombreSupermercado = nombre;
	}

	//Getters and Setters

	public int getId() {
		return idSupermercado;
	}

	public void setId(int id) {
		this.idSupermercado = id;
	}

	public String getNombre() {
		return nombreSupermercado;
	}

	public void setNombre(String nombre) {
		this.nombreSupermercado = nombre;
	}

	public String toString() {
		return "Supermercado: " + nombreSupermercado + "ID: " + idSupermercado;
	}
}

package mundo.mongoDB;

import com.mongodb.BasicDBObject;

import modelo.Interface.Productos;

public class Empleado implements Productos {

	//Atributos
	private String nombreEmpleado;
	private int idEmpleado;
	private SeccionEmpleado seccionEmpleado;

	//Constructores

	public Empleado( String pNombre, int pId, SeccionEmpleado seccionEmpleado) {
		nombreEmpleado = pNombre;
		idEmpleado = pId;
		this.seccionEmpleado  = seccionEmpleado;
	}
	
	public Empleado() {
		nombreEmpleado = "";
		idEmpleado = 0;
	}

	// Transformo un objecto que me da MongoDB a un Objecto Java
	public Empleado(BasicDBObject dBObjectEmpleado) {
		this.nombreEmpleado = dBObjectEmpleado.getString(" nombreEmpleado");
		this.idEmpleado = dBObjectEmpleado.getInt(" idEmpleado");
	}

	public BasicDBObject todBObjectEmpleado() {
		// Creamos una instancia BasicDBObject
		BasicDBObject dBObjectEmpleado = new BasicDBObject();
		dBObjectEmpleado.append(" nombreEmpleado ", this.getNombreEmpleado());
		dBObjectEmpleado.append(" idEmpleado ", this.getIdEmpleado());

		return dBObjectEmpleado;
	}
	//Metodos analizadores
	public String getNombreEmpleado() {
		return nombreEmpleado;
	}

	public void setNombreEmpleado(String nombreEmpleado) {
		this.nombreEmpleado = nombreEmpleado;
	}

	public int getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(int idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public String toString() {
		return "Empleado: " + nombreEmpleado + "ID del empleado: " + idEmpleado + "Seccion del empleado: ";
	}

	public void desplegarEmpleado() {
		System.out.println("Nombre: " + getNombreEmpleado());
		System.out.println("ID: " + getIdEmpleado());
		System.out.println("Seccion donde se encuentra ubicado: " + seccionEmpleado);
	}

	public void accionProducto() {

		System.out.println("Registro de producto");
	}

}

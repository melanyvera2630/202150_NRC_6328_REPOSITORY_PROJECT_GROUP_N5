package mundo.mongoDB;

import java.util.ArrayList;
import java.util.List;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;

import modelo.Interface.Productos;


public class Cliente implements Productos{

	//Atributos
	private String nombreCliente;
	private int idCliente;
	private String numCedulaCliente;
	private String direccionCliente;

	//Asociacion
	private List<Producto> CompraProductos;

	//Constructores
	public Cliente( String pNombre,int pId,String pNumCedula, String pDireccion) {

		nombreCliente = pNombre;
		idCliente = pId;
		numCedulaCliente = pNumCedula;
		direccionCliente = pDireccion;
	}

	public Cliente() {
		nombreCliente = "";
		idCliente = 0;
		numCedulaCliente = "";
		direccionCliente = "";
		
	}
	
	// Transformo un objecto que me da MongoDB a un Objecto Java
	public Cliente(BasicDBObject dBObjectCliente) {
		this.nombreCliente= dBObjectCliente.getString(" nombreCliente");
		this.idCliente= dBObjectCliente.getInt(" idCliente");
		this.numCedulaCliente = dBObjectCliente.getString(" numCedulaCliente");
		this.direccionCliente = dBObjectCliente.getString(" direccionCliente");
	}
	
	public BasicDBObject todBObjectCliente() {
		// Creamos una instancia BasicDBObject
		BasicDBObject dBObjectCliente = new BasicDBObject();
		dBObjectCliente.append(" nombreCliente ", this.getNombreCliente());
		dBObjectCliente.append(" idCliente ", this.getIdCliente());
		dBObjectCliente.append(" numCedulaCliente ", this.getNumCedulaCliente());
		dBObjectCliente.append(" direccionCliente ", this.getDireccionCliente());
		
		return dBObjectCliente;
	}
	
	//Metodos analizadores
	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getNumCedulaCliente() {
		return numCedulaCliente;
	}

	public void setNumCedulaCliente(String numCedulaCliente) {
		this.numCedulaCliente = numCedulaCliente;
	}

	public String getDireccionCliente() {
		return direccionCliente;
	}

	public void setDireccionCliente(String direccionCliente) {
		this.direccionCliente = direccionCliente;
	}

	public String toString() {
		return "Nombre del cliente: " + nombreCliente + "ID del cliente: " + idCliente + 
				"Numero de cedula: " + numCedulaCliente + "Direccion" + direccionCliente;
	}

	public void accionProducto() {
		System.out.println("Consulta de producto");
	}

	public void comprarProducto() {
		System.out.println("El cliente compra el producto");
	}
}

package mundo.mongoDB;

import java.util.ArrayList;
import java.util.List;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;

import modelo.Interface.Productos;

public class Proveedor implements Productos{

	//Atributos
	private String nombreEmpresa;
	private String nombreProveedor;
	private String idProveedor;
	public ArrayList<String> proveedores;

	//Asociacion 
	private List<Producto> productoList;

	//Constructores
	public Proveedor (String pNombreEmpresa, String pNombreProveedor,String pIdProveedor, ArrayList<String> pProveedores) {

		nombreEmpresa      = pNombreEmpresa;
		nombreProveedor = pNombreProveedor;
		idProveedor     = pIdProveedor;
		proveedores =  pProveedores;
	}

	public Proveedor () {

		nombreEmpresa   = "";
		nombreProveedor = "";
		idProveedor     = "";
		proveedores = null;

	}
	
	// Transformo un objecto que me da MongoDB a un Objecto Java
	public Proveedor(BasicDBObject dBObjectProveedor) {
		this.nombreEmpresa = dBObjectProveedor.getString(" nombreEmpresa");
		this.nombreProveedor = dBObjectProveedor.getString(" nombreProveedor");
		this.idProveedor = dBObjectProveedor.getString(" idProveedor");
		this.proveedores = new ArrayList<String>();

		// Cuidado cuando trabajamos con Arrays o Listas
		BasicDBList listProveedores = (BasicDBList) dBObjectProveedor.get(" proveedores");	
		for(Object prove: listProveedores) {
			this.proveedores.add(prove.toString());
		}
	}
	
	public BasicDBObject toDBObjectProveedor() {

		// Creamos una instancia BasicDBObject
		BasicDBObject dBObjectProveedor = new BasicDBObject();
		dBObjectProveedor.append(" nombreEmpresa", this.getNombreEmpresa());
		dBObjectProveedor.append(" nombreProveedor", this.getNombreProveedor());
		dBObjectProveedor.append(" idProveedor", this.getIdProveedor());
		dBObjectProveedor.append(" proveedores", this.getProveedores());


		return dBObjectProveedor;
	}
	//Metodos analizadores
	public String getNombreEmpresa() {
		return nombreEmpresa;
	}

	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}

	public String getNombreProveedor() {
		return nombreProveedor;
	}

	public void setNombreProveedor(String nombreProveedor) {
		this.nombreProveedor = nombreProveedor;
	}

	public String getIdProveedor() {
		return idProveedor;
	}

	public void setIdProveedor(String idProveedor) {
		this.idProveedor = idProveedor;
	}
	
	public ArrayList<String> getProveedores() {
		return proveedores;
	}
	
	public void setProveedores(ArrayList<String> pProveedores) {
		this.proveedores = pProveedores;
	}

	public String toString() {
		return "Empresa: " + nombreEmpresa + " Encargado: " + nombreProveedor + " ID Proveedor: " + idProveedor + " Proveedor: " + proveedores;
	}

	public void accionProducto() {

		System.out.println("Entrega de producto");

	}
}

package mundo.mongoDB;

import java.util.List;

import com.mongodb.BasicDBObject;

public class Producto {

	//Atributos
	private String nombreProducto;
	private int idProducto;
	private double precioProducto;
	private int    cantidadProducto;
	private SeccionProducto seccionProducto;

	//Asociacion 
	private List<Cliente> CompradoClientes;
	private List<Proveedor> proveedorList;

	//Constructores
	public Producto(String nombreProducto, int idProducto, double precioProducto, int cantidadProducto,SeccionProducto seccionProducto) {

		this.nombreProducto = nombreProducto;
		this.idProducto = idProducto;
		this.precioProducto = precioProducto;
		this.cantidadProducto = cantidadProducto;
		this.seccionProducto  = seccionProducto;
	}

	public Producto() {
		nombreProducto = "";
		idProducto = 0;
		precioProducto = 0;
		cantidadProducto = 0;
	}
	
	// Transformo un objecto que me da MongoDB a un Objecto Java
	public Producto(BasicDBObject dBObjectProducto) {
		this.nombreProducto= dBObjectProducto.getString(" nombreProducto");
		this.idProducto= dBObjectProducto.getInt(" idProducto");
		this.precioProducto = dBObjectProducto.getDouble(" precioProducto");
		this.cantidadProducto = dBObjectProducto.getInt(" cantidadProducto");
	}
		
	public BasicDBObject todBObjectProducto() {
		// Creamos una instancia BasicDBObject
		BasicDBObject dBObjectProducto = new BasicDBObject();
		dBObjectProducto.append(" nombreProducto ", this.getNombreProducto());
		dBObjectProducto.append(" idProducto ", this.getIdProducto());
		dBObjectProducto.append(" precioProducto ", this.getPrecioProducto());
		dBObjectProducto.append(" cantidadProducto", this.getCantidadProducto());
		
		return dBObjectProducto;
	}
	//Metodos analizadores
	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public int getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public double getPrecioProducto() {
		return precioProducto;
	}

	public void setPrecioProducto(double precioProducto) {
		this.precioProducto = precioProducto;
	}

	public int getCantidadProducto() {
		return cantidadProducto;
	}

	public void setCantidadProducto(int cantidadProducto) {
		this.cantidadProducto = cantidadProducto;
	}

	public String toString() {
		return "Producto: " + nombreProducto + "ID Producto: " + idProducto + "Precio del producto: " + precioProducto + 
				"Cantidad en stock: " + cantidadProducto + "Seccion del producto: " + seccionProducto;
	}

	public void desplegarProducto() {
		System.out.println("Datos del producto");
		System.out.println("Nombre: " + getNombreProducto());
		System.out.println("ID: " + getIdProducto());
		System.out.println("Precio: " + getPrecioProducto());
		System.out.println("Cantidad disponible: " + getCantidadProducto());
		System.out.println("Seccion donde se encuentra ubicado: " + seccionProducto+"\n");

	}

	public void productoVendido () {

	}

}

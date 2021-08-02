package mundo.mongoDB;

import java.util.ArrayList;
import java.util.Arrays;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

public class Principal {

	public static void main(String[] args) {

		Producto producto1 = new Producto("Salsa de tomate",001,5.25,25,SeccionProducto.aceites);
		producto1.desplegarProducto();

		Producto producto2 = new Producto("Mayonesa",002,5.25,25,SeccionProducto.aceites);
		producto2.desplegarProducto();

		Empleado empleado1 = new Empleado("Eduardo Rivas",300,SeccionEmpleado.bodega);
		empleado1.desplegarEmpleado();
		
		//Base de datos MongoDB
		ArrayList<Cliente> clientes= new ArrayList<Cliente>();
		clientes.add(new Cliente ("Alex Mendoza",400,"2369874120","Coop. Las Palmas"));
		clientes.add(new Cliente ("Jimena Mendoza",401,"2374859632","Coop. Los Rosales"));
		clientes.add(new Cliente ("Rosa Rivadeneira",402,"2332589641","Coop. Ciudad Nueva"));
		
		ArrayList<Producto> productos= new ArrayList<Producto>();
		productos.add(new Producto("Salsa de tomate",001,5.25,25,SeccionProducto.aceites));
		productos.add(new Producto("Mayonesa",002,6.30,15,SeccionProducto.aceites));
		productos.add(new Producto("Mostaza",003,4.80,5,SeccionProducto.aceites));
		
		ArrayList<Proveedor> proveedores= new ArrayList<Proveedor>();
		proveedores.add(new Proveedor("Los Andes","Marcos Merizalde","2563",new ArrayList<String>(Arrays.asList("Proveedor 1"))));
		proveedores.add(new Proveedor("Gustadina","Anthonio Sotomayor","2630",new ArrayList<String>(Arrays.asList("Proveedor 2"))));
		
		ArrayList<Empleado> empleados= new ArrayList<Empleado>();
		empleados.add(new Empleado("Eduardo Rivas",300,SeccionEmpleado.bodega));
		
		try {
			// PASO 1: Conexión al Server de MongoDB Pasandole el host y el puerto
		    MongoClient mongoclient = new MongoClient ("localhost", 27017);
		    
		    // PASO 2: Conexión a la base de datos
		    DB db = mongoclient.getDB("Supermercado");
		    
		    // PASO 3: Obtenemos una coleccion para trabajar con ella
		    DBCollection collectionC = db.getCollection("Clientes");
		    DBCollection collectionP = db.getCollection("Productos");
		    DBCollection collectionPr = db.getCollection("Proveedores");
		    DBCollection collectionE = db.getCollection("Empleados");
		    
		    // PASO 4: CRUD (Create-Read-Update-Delete)
		    // PASO 4.1: "CREATE" -> Metemos los objetos futbolistas (o documentos en Mongo) en la coleccion Futbolista
		    createDB(clientes,collectionC);
		    createDB2(productos,collectionP);
		    createDB3(proveedores,collectionPr);
		    createDB4(empleados,collectionE);
		    DBCursor cursor;
		    
		    // PASO 4.2.1: "READ" -> Leemos todos los documentos de la base de datos
		    readDB(collectionC);
		    readDB2(collectionP);
		    readDB3(collectionPr);
		    readDB4(collectionE);
		    
		    /*// PASO 4.2.2: "READ" -> Hacemos una Query con condiciones y lo pasamos a un objeto Java
		    System.out.println("\nClientes con el nombre Alex Mendoza");
		    readDBQuery(collectionC);*/
		    
		    // PASO 4.3: "UPDATE" -> Actualizamos el id de los clientes.
		    updateDB(collectionC);
		    readDB(collectionC);
		    
		    // PASO 4.4: "DELETE" -> Borramos 
		    deleteDB(collectionC);
		    readDB(collectionC);
		    
		    // PASO FINAL: Cerrar la conexion mv
		      mongoclient.close();
		      
		}catch (Exception ex){
			System.out.println("Exception al conectar al server de Mongo ");
		}

	}

	// PASO 4.1: "CREATE" -> Metemos los objetos clientes (o documentos en Mongo) en la coleccion Cliente
	public static void createDB(ArrayList<Cliente>clientes, DBCollection collectionC) {
		for(Cliente clien:clientes) {
			collectionC.insert(clien.todBObjectCliente()); }
	}	

	public static void createDB2(ArrayList<Producto>productos, DBCollection collectionP) {
		for(Producto produc:productos) {
			collectionP.insert(produc.todBObjectProducto()); }
	}
	
	public static void createDB3(ArrayList<Proveedor>proveedores, DBCollection collectionPr) {
		for(Proveedor prove: proveedores) {
			collectionPr.insert(prove.toDBObjectProveedor()); }
	}

	public static void createDB4(ArrayList<Empleado>empleados, DBCollection collectionE) {
		for(Empleado emple: empleados) {
			collectionE.insert(emple.todBObjectEmpleado()); }
	}
	
	// PASO 4.2.1: "READ" -> Leemos todos los documentos de la base de datos
	public static void readDB (DBCollection collectionC) {	
		int numDocumentos = (int) collectionC.getCount();
		System.out.println("");
		System.out.println("Numero de documentos en la coleccion Clientes: " + numDocumentos + "\n"); 
		DBCursor cursor = collectionC.find();
		try {
			while(cursor.hasNext()) {
				System.out.println(cursor.next().toString()); }   	
		}catch(Exception e) {
			System.out.println("Error al recorrer la coleccion ");
		}finally {
			cursor.close();
		}
	}
	
	public static void readDB2 (DBCollection collectionP) {	
		int numDocumentos2 = (int) collectionP.getCount();
		System.out.println("");
		System.out.println("Numero de documentos en la coleccion Productos: " + numDocumentos2 + "\n"); 
		DBCursor cursor2 = collectionP.find();
		try {
			while(cursor2.hasNext()) {
				System.out.println(cursor2.next().toString()); }   	
		}catch(Exception e) {
			System.out.println("Error al recorrer la coleccion ");
		}finally {
			cursor2.close();
		}
	}

	public static void readDB3 (DBCollection collectionPr) {	
		int numDocumentos3 = (int) collectionPr.getCount();
		System.out.println("");
		System.out.println("Numero de documentos en la coleccion Proveedores: " + numDocumentos3 + "\n"); 
		DBCursor cursor3 = collectionPr.find();
		try {
			while(cursor3.hasNext()) {
				System.out.println(cursor3.next().toString()); }   	
		}catch(Exception e) {
			System.out.println("Error al recorrer la coleccion ");
		}finally {
			cursor3.close();
		}
	}
	
	public static void readDB4 (DBCollection collectionE) {	
		int numDocumentos4 = (int) collectionE.getCount();
		System.out.println("");
		System.out.println("Numero de documentos en la coleccion Empleados: " + numDocumentos4 + "\n"); 
		DBCursor cursor4 = collectionE.find();
		try {
			while(cursor4.hasNext()) {
				System.out.println(cursor4.next().toString()); }   	
		}catch(Exception e) {
			System.out.println("Error al recorrer la coleccion ");
		}finally {
			cursor4.close();
		}
	}
	/*// PASO 4.2.2: "READ" -> Hacemos una Query con condiciones y lo pasamos a un objeto Java
	public static void readDBQuery(DBCollection collectionC) {
		DBObject query = new BasicDBObject("nombreCliente", new BasicDBObject("$regex", "Alex Mendoza"));
		DBCursor cursor = collectionC.find(query);
		try {
			while(cursor.hasNext()) {
				Cliente cliente = new Cliente((BasicDBObject)cursor.next());
				System.out.println(cliente.toString()); }
		}catch(Exception e) {
			System.out.println("Error al recorrer la coleccion ");
		}finally {
			cursor.close();
		}
	}*/

	// PASO 4.3: "UPDATE" -> Actualizamos el id de los clientes.
	public static void updateDB(DBCollection collectionC) {
		DBObject find = new BasicDBObject(" idCliente ", new BasicDBObject("$gt", 400)); 
		DBObject updated = new BasicDBObject().append("$inc", new BasicDBObject().append(" idCliente ", 100));
		collectionC.update(find, updated, false, true);
	}	

	// PASO 4.4: "DELETE" -> Borramos al cliente con ID 401
	public static void deleteDB(DBCollection collectionC) {
		DBObject findDoc = new BasicDBObject(" idCliente ", 400);
		collectionC.remove(findDoc);
	}
}

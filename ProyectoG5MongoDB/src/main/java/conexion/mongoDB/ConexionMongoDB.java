package conexion.mongoDB;

import java.util.ArrayList;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

import mundo.mongoDB.Cliente;


public class ConexionMongoDB {

	// PASO 4.1: "CREATE" -> Metemos los objetos futbolistas (o documentos en Mongo) en la coleccion Futbolista
	public static void createDB(ArrayList<Cliente>clientes, DBCollection collection) {
		for(Cliente clien:clientes) {
			collection.insert(clien.todBObjectCliente()); }
	}	
	
	// PASO 4.2.1: "READ" -> Leemos todos los documentos de la base de datos
	public static void readDB (DBCollection collection) {	
		int numDocumentos = (int) collection.getCount();
		System.out.println("Numero de documentos en la coleccion Clientes: " + numDocumentos + "\n"); 
		// Busco todos los documentos de la colección y los imprimo
		DBCursor cursor = collection.find();
		try {
			while(cursor.hasNext()) {
				System.out.println(cursor.next().toString()); }   	
		}catch(Exception e) {
			System.out.println("Error al recorrer la coleccion ");
		}finally {
			cursor.close();
		}
	}
	
	// PASO 4.2.2: "READ" -> Hacemos una Query con condiciones y lo pasamos a un objeto Java
	public static void readDBQuery(DBCollection collection) {
		DBObject query = new BasicDBObject("nombreCliente", new BasicDBObject("$regex", "Mendoza"));
		DBCursor cursor = collection.find(query);
		try {
			while(cursor.hasNext()) {
				Cliente cliente = new Cliente((BasicDBObject)cursor.next());
				System.out.println(cliente.toString()); }
		}catch(Exception e) {
			System.out.println("Error al recorrer la coleccion demarcacion ");
		}finally {
			cursor.close();
		}
	}
	
	// PASO 4.3: "UPDATE" -> Actualizamos el id de los clientes.
	public static void updateDB(DBCollection collection) {
		DBObject find = new BasicDBObject("idCliente", new BasicDBObject("$gt", 400)); 
		DBObject updated = new BasicDBObject().append("$inc", new BasicDBObject().append("idCliente", 500));
		collection.update(find, updated, false, true);
	}	
	
	// PASO 4.4: "DELETE" -> Borramos todos los futbolistas que sean internacionales (internacional = true)
	public static void deleteDB(DBCollection collection) {
		DBObject findDoc = new BasicDBObject("id", 500);
		collection.remove(findDoc);
	}
}

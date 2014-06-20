package test;

import java.net.UnknownHostException;
import java.util.Set;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;

public class TestCreateUser {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//crée quelques utilisateurs pour voir ce qui se passe
		try{
			MongoClient client = new MongoClient("192.168.56.101");
			
			DB db = client.getDB( "mydb" );
			
			Set<String> colls = db.getCollectionNames();
			
			for (String s : colls){
				System.out.println(s);
			}
			
			DBCollection collection = db.getCollection("users");
			
			if (collection != null)
				System.out.println(" nb colleections "+collection.count());
			else
				System.out.println("aucune collection ");
			
			BasicDBObject doc = new BasicDBObject("nom", "sibot").append("prenom", "romain").append("login", "romain").append("password", "romain");
			collection.insert(doc);
			
//			BasicDBObject searchQuery = new BasicDBObject();
//			searchQuery.put("prenom", "mourad");		// Find documents with Joe Smith in name field
//
//			DBCursor cursor = collection.find(searchQuery);
//			System.out.println(" curseur : "+cursor.count());

//			while (cursor.hasNext())
//			{
//				System.out.println(cursor.next());
//			}
		}catch (UnknownHostException e){
			e.printStackTrace();
		}
	}

}

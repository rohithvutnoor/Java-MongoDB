import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import com.mongodb.WriteConcern;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.DBCursor;

import com.mongodb.ServerAddress;
import java.util.Arrays;

public class MongoDBJDBC {

	public static void main(String args[]) {

		String username = "rohithvutnoor";
		String password = "Google";
		try {

			// To connect to mongodb server
			MongoClient mongoClient = new MongoClient("localhost", 27017);

			// Now connect to your databases
			DB db = mongoClient.getDB("CBIT");
			System.out.println("Connect to database successfully");
			// boolean auth = db.authenticate(username, '2');
			// System.out.println("Authentication: "+auth);
			// DBCollection coll = db.createCollection("mycol", null);
			// System.out.println("Collection created successfully");
			DBCollection coll = db.getCollection("studentData");
			System.out.println("Collection mycol selected successfully");

			BasicDBObject doc = new BasicDBObject("roll", 99).append("name", "ashwin").append("department", "CSE");

			coll.insert(doc);
			System.out.println("Document inserted successfully");

			DBCursor cursor = coll.find();//doc
			int i = 1;

			while (cursor.hasNext()) {
				System.out.println("Document: " + i);
				
				//DBObject updateDocument = cursor.next();
	            //updateDocument.put("roll","100");
	            //coll.update(updateDocument, doc);
				
				System.out.println(cursor.next());
				i++;
			}
			DBObject myDoc = coll.findOne();
			System.out.println("\n\n"+myDoc);
	         //coll.remove(myDoc);
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		}
	}
}

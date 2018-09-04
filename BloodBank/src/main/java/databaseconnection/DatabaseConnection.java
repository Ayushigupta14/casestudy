package databaseconnection;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class DatabaseConnection {
	
	private static final String DATABASE="BloodBank";
	private static final String DONORCOLLECTION="donors";
	private static final String PATIENTCOLLECTION="patients";
	private static final String REQUESTCOLLECTION="requests";
	private static final String ACTIVEDONORCOLLECTION="activeDonors";
	
	private static MongoCollection<Document> donorCollection;
	private static MongoCollection<Document> patientCollection;
	private static MongoCollection<Document> requestCollection;
	private static MongoCollection<Document> activeDonorCollection;
	
	static
	{
		MongoClient mongo=new MongoClient("localhost",27017);
		MongoDatabase database=mongo.getDatabase(DATABASE);
		 donorCollection=database.getCollection(DONORCOLLECTION);
		 patientCollection=database.getCollection(PATIENTCOLLECTION);
		 requestCollection=database.getCollection(REQUESTCOLLECTION);
		 activeDonorCollection=database.getCollection(ACTIVEDONORCOLLECTION);
	}
	public static MongoCollection<Document>  getDonorCollection()
		{
			   return donorCollection;
		}
	public static MongoCollection<Document>  getPatientCollection()
	{
		   return patientCollection;
	}
	public static MongoCollection<Document>  getRequestCollection()
	{
		   return requestCollection;
	}
	public static MongoCollection<Document>  getActiveDonorCollection()
	{
		   return activeDonorCollection;
	}
	
}

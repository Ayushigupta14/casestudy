package patientservices;

import java.util.ArrayList;
import java.util.Iterator;

import org.bson.Document;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.UpdateResult;

import databaseconnection.DatabaseConnection;
import patientservices.PatientAdapter;
import patientservices.PatientAdapter;
import model.Patient;
import model.Patient;
import model.Patient;

public class PatientDatabase {
	
	static MongoCollection<Document> pCollection;
	static {
		pCollection=DatabaseConnection.getPatientCollection();
	}
	
	public static void add(Patient patient)
	{
		Document toAdd=PatientAdapter.toDocument(patient);
		pCollection.insertOne(toAdd);
	}
	

	
	public static Patient viewProfile(String mobile)
	{
		Patient patient=new Patient();
		System.out.println(mobile);
		FindIterable<Document> fit=pCollection.find(Filters.eq("mobile", mobile));
		patient=PatientAdapter.toPatient(fit.first());	
		return patient;
	}
	
	
	
	public static  Boolean updatePassword(String oldPass,String newPass)
	{
		Document password=new Document("password",oldPass);
		Document set = new Document("$set", new Document("password", newPass));
		UpdateResult result= pCollection.updateOne(password, set);
		return result.wasAcknowledged();
		
	}
	
	
	public static Patient updateProfile(Patient object)
	{
		Document password=new Document("password",object.getPassword());
		Document result= pCollection.findOneAndReplace(password, PatientAdapter.toDocument(object));
		return PatientAdapter.toPatient(result);
		
	}
	

}

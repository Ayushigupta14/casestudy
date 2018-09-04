package bloodrequestservices;

import java.util.ArrayList;
import java.util.Iterator;

import org.bson.Document;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.DeleteResult;

import databaseconnection.DatabaseConnection;

import model.BloodRequest;
import bloodrequestservices.BloodRequestAdapter;

public class BloodRequestDatabase {
	
	
	static MongoCollection<Document> requestCollection;
	static {
		requestCollection=DatabaseConnection.getRequestCollection();
	}
	
	public static void add(BloodRequest BloodRequest)
	{
		Document toAdd=BloodRequestAdapter.toDocument(BloodRequest);
		requestCollection.insertOne(toAdd);
	}
	
	
	public static ArrayList<BloodRequest> find(String city,String state, String bloodGroup) 
	{
		ArrayList<BloodRequest> requests=new ArrayList<BloodRequest>();
		FindIterable<Document> fit=requestCollection.find(Filters.and(Filters.eq("city", city),
				Filters.eq("blood group", bloodGroup),Filters.eq("state", state)));
		Iterator<Document> it=fit.iterator();
		while(it.hasNext())
		{
			requests.add(BloodRequestAdapter.toBloodRequest(it.next()));
		}
		return requests;
	}

	
	public static Boolean delete(String mobile)
	{
		System.out.println(mobile);
		DeleteResult result=requestCollection.deleteOne(Filters.eq("mobile", mobile));
		return result.wasAcknowledged();
		
	}
	
	
	
}

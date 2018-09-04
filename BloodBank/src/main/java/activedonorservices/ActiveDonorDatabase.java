package activedonorservices;

import java.util.ArrayList;
import java.util.Iterator;

import org.bson.Document;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.DeleteResult;

import activedonorservices.ActiveDonorAdapter;
import databaseconnection.DatabaseConnection;
import model.ActiveDonor;


public class ActiveDonorDatabase {

	static MongoCollection<Document> activeDonorCollection;
	static {
		activeDonorCollection=DatabaseConnection.getActiveDonorCollection();
	}
	
	public static void activate(Document donorDoc)
	{
		ActiveDonor activeDonorObj=ActiveDonorAdapter.toActiveDonor(donorDoc);
		Document toAdd=ActiveDonorAdapter.toDocument(activeDonorObj);
		activeDonorCollection.insertOne(toAdd);
	}
	
	
	public static ArrayList<ActiveDonor> find(String city,String state, String bloodGroup) 
	{
		ArrayList<ActiveDonor> requests=new ArrayList<ActiveDonor>();
		FindIterable<Document> fit=activeDonorCollection.find(Filters.and(Filters.eq("city", city),
				Filters.eq("blood group", bloodGroup),Filters.eq("state", state)));
		Iterator<Document> it=fit.iterator();
		while(it.hasNext())
		{
			requests.add(ActiveDonorAdapter.toActiveDonor(it.next()));
		}
		return requests;
	}

	
	public static Boolean deactivate(String mobile)
	{
		System.out.println(mobile);
		DeleteResult result=activeDonorCollection.deleteOne(Filters.eq("mobile", mobile));
		return result.wasAcknowledged();
		
	}
}

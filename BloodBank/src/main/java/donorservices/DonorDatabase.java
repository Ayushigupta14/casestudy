package donorservices;


import org.bson.Document;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.UpdateResult;

import databaseconnection.DatabaseConnection;

import model.Donor;


public class DonorDatabase {
	
	static MongoCollection<Document> dCollection;
	static {
		dCollection=DatabaseConnection.getDonorCollection();
	}
	
	public static void add(Donor donor)
	{
		Document toAdd=DonorAdapter.toDocument(donor);
		dCollection.insertOne(toAdd);
	}
	
	
	public static Donor getProfile(String mobile)
	{
		FindIterable<Document> fit=dCollection.find(Filters.eq("mobile", mobile));
		Donor donor=DonorAdapter.toDonor(fit.first());	
		return donor;
	}
	
	public static  Donor updateProfile(Donor object)
	{
		Document password=new Document("password",object.getPassword());
		Document doc= dCollection.findOneAndReplace(password, DonorAdapter.toDocument(object));
		return DonorAdapter.toDonor(doc);	
	}
	
	
	public static  Boolean updatePassword(String oldPass,String newPass)
	{
		Document password=new Document("password",oldPass);
		Document set = new Document("$set", new Document("password", newPass));
		UpdateResult result= dCollection.updateOne(password, set);
		return result.wasAcknowledged();
	}
	
	

}

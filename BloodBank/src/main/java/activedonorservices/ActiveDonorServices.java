package activedonorservices;

import java.util.ArrayList;

import org.bson.Document;

import activedonorservices.ActiveDonorDatabase;
import donorservices.DonorAdapter;
import donorservices.DonorServices;
import model.ActiveDonor;


public class ActiveDonorServices {
	
	public static void activate(Document doc)
	{
		Document donorDoc=DonorAdapter.toDocument(DonorServices.getProfile(doc));
		ActiveDonorDatabase.activate(donorDoc);
		
	}
	
	
	public static ArrayList<ActiveDonor> find(Document doc) 
	{
		String bloodGroup=doc.getString("blood group");
		String city=doc.getString("city");
		String state=doc.getString("state");
		
		return ActiveDonorDatabase.find(city, state, bloodGroup);
	}

	
	public static Boolean deactivate(Document doc)
	{
		String mobile=doc.getString("mobile");
		return ActiveDonorDatabase.deactivate(mobile);
		
	}

}

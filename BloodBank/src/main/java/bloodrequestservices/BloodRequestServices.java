package bloodrequestservices;

import java.util.ArrayList;

import org.bson.Document;

import model.BloodRequest;

public class BloodRequestServices {
	
	public static void add(BloodRequest request)
	{
		BloodRequestDatabase.add(request);
	}
	
	
	public static ArrayList<BloodRequest> find(Document doc) 
	{
		String bloodGroup=doc.getString("blood group");
		String city=doc.getString("city");
		String state=doc.getString("state");
		
		return BloodRequestDatabase.find(city, state, bloodGroup);
	}

	
	public static Boolean delete(Document doc)
	{
		String mobile=doc.getString("mobile");
		return BloodRequestDatabase.delete(mobile);
		
	}

}

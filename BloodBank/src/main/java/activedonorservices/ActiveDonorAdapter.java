package activedonorservices;

import org.bson.Document;

import model.ActiveDonor;


public class ActiveDonorAdapter {

	
	public static Document toDocument(ActiveDonor object)
	{
		Document doc=new Document();
		doc.append("name", object.getName());
		doc.append("mobile", object.getMobile());
		doc.append("age", object.getAge());
		doc.append("gender", object.getGender());
		doc.append("blood group", object.getBloodGroup());
		doc.append("city", object.getCity());
		doc.append("state", object.getState());
		return doc;
		
	}
	
	public static ActiveDonor toActiveDonor(Document doc)
	{
		ActiveDonor object = new ActiveDonor();
		object.setName(doc.getString("name"));
		object.setMobile(doc.getString("mobile"));
		object.setAge(doc.getDouble("age"));
		object.setGender(doc.getString("gender"));
		object.setBloodGroup(doc.getString("blood group"));
		object.setCity(doc.getString("city"));
		object.setState(doc.getString("state"));
		return object;		
	}
	
}

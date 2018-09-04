package bloodrequestservices;

import org.bson.Document;

import model.BloodRequest;

public class BloodRequestAdapter {
	
	public static BloodRequest toBloodRequest(Document doc)
	{
		BloodRequest object=new BloodRequest();
		object.setName(doc.getString("name"));
		object.setMobile(doc.getString("mobile"));
		object.setBloodGroup(doc.getString("bloodGroup"));
		object.setCity(doc.getString("city"));
		object.setState(doc.getString("state"));
		return object;
	}
	
	public static Document toDocument(BloodRequest object)
	{
		Document doc=new Document();
		doc.append("name", object.getName());
		doc.append("mobile", object.getMobile());
		doc.append("blood group", object.getBloodGroup());
		doc.append("city", object.getCity());
		doc.append("state", object.getState());
		return doc;
		
	}

}

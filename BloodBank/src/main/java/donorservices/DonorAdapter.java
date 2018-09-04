package donorservices;

import org.bson.Document;

import model.Donor;

public class DonorAdapter {
	
	public static Document toDocument(Donor object)
	{
		Document doc=new Document();
		doc.append("name", object.getName());
		doc.append("email", object.getEmail());
		doc.append("mobile", object.getMobile());
		doc.append("password", object.getPassword());
		doc.append("age", object.getAge());
		doc.append("gender", object.getGender());
		doc.append("blood group", object.getBloodGroup());
		doc.append("city", object.getCity());
		doc.append("state", object.getState());
		return doc;
		
	}
	
	public static Donor toDonor(Document doc)
	{
		Donor object = new Donor();
		object.setName(doc.getString("name"));
		object.setEmail(doc.getString("email"));
		object.setMobile(doc.getString("mobile"));
		object.setPassword(doc.getString("password"));
		object.setAge(doc.getDouble("age"));
		object.setGender(doc.getString("gender"));
		object.setBloodGroup(doc.getString("blood group"));
		object.setCity(doc.getString("city"));
		object.setState(doc.getString("state"));
		
		
		return object;		
	}
	
	
	
}

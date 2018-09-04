package patientservices;

import org.bson.Document;

import model.Patient;

public class PatientAdapter {

	public static Patient toPatient(Document doc)
	{
		Patient object=new Patient();
		object.setName(doc.getString("name"));
		object.setMobile(doc.getString("mobile"));
		object.setPassword(doc.getString("password"));
		object.setCity(doc.getString("city"));
		object.setState(doc.getString("state"));
		return object;
	}
	
	public static Document toDocument(Patient object)
	{
		Document doc=new Document();
		doc.append("name", object.getName());
		doc.append("mobile", object.getMobile());
		doc.append("password", object.getPassword());
		doc.append("city", object.getCity());
		doc.append("state", object.getState());
		return doc;
		
	}
}

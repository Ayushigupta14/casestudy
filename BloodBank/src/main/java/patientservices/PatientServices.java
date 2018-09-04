package patientservices;



import org.bson.Document;


import patientservices.PatientDatabase;
import model.Patient;

public class PatientServices {
	
	public static void addPatient(Patient obj)
	{
			PatientDatabase.add(obj);
	}
	
	
	public static Patient getProfile(Document doc){
		String mobile=doc.getString("mobile");
		return PatientDatabase.viewProfile(mobile);
	} 

	public static Patient updateProfile(Patient obj)
	{
		return PatientDatabase.updateProfile(obj);
	}
	
	public static Boolean updatePassword(Document doc){
		String oldPass=doc.getString("old password");
		String newPass=doc.getString("new password");
		return PatientDatabase.updatePassword(oldPass,newPass);
	} 

	
//	{
//        "name": "Pratibha",
//        "mobile": "9189678906",
//        "city": "Warangal",
//        "state": "Telangana",
//		"password": "pratibhaa"
//        
//    }
}

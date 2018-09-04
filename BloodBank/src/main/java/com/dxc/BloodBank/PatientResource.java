package com.dxc.BloodBank;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.bson.Document;

import model.Patient;
import patientservices.PatientServices;

@Path("patient")
public class PatientResource {
	
	
	@GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
    	
        return "Got it!";
    }
    
	@POST
	@Path("add")
	//@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void addPatient(Patient object) //object
	{
		PatientServices.addPatient(object);
	}
	

	@Path("getprofile")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Patient getProfile(Document doc) //mobile
	{
		return PatientServices.getProfile(doc);
	}
	
	@POST
	@Path("update")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Patient updateProfile(Patient obj) //object
	{
		Patient updated=PatientServices.updateProfile(obj);
			return updated;
	}
	
	@POST
	@Path("changepass")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String updatePassword(Document doc) //old password,new password
	{
		if(PatientServices.updatePassword(doc))
			return "Done";
		else
			return "Not updated";
	}
}

package com.dxc.BloodBank;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.bson.Document;

import donorservices.DonorServices;
import model.Donor;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class DonorResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
    	
        return "Got it!";
    }
    
   
    
    @POST
    @Path("getprofile")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Donor getProfile(Document doc) //mobile
    {
    	
        return DonorServices.getProfile(doc);
    }
  
    @POST
    @Path("changepass")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String  updateDonor(Document doc) //old password,new password
    {
    	
       boolean state=DonorServices.updatePassword(doc);
       if(state)
       return "ok";
       else
    	   return "not updated.. try again";
    }
    
    @POST
    @Path("add") 
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public String addDonor(Donor obj) //object
    {
    	DonorServices.addDonor(obj);
        return "Got it!";
    }

    @POST
    @Path("update")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Donor update(Donor obj) //object
    {
    	Donor old=DonorServices.updateProfile(obj);
        return old;
    }
}

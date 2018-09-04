package com.dxc.BloodBank;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.bson.Document;


import bloodrequestservices.BloodRequestServices;
import model.BloodRequest;

@Path("request")
public class BloodRequestResource {
	
	@POST
	@Path("add")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public static void add(BloodRequest request) //object
	{
		BloodRequestServices.add(request);
	}
	
	@POST
	@Path("find")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public static ArrayList<BloodRequest> find(Document doc) //city,state, blood group
	{
		return BloodRequestServices.find(doc);
	}

	@POST
	@Path("delete")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public static Boolean delete(Document doc) //mobile no
	{
		return BloodRequestServices.delete(doc);
		
	}

}

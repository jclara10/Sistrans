package rest;

import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import tm.FestivAndesTransactionManager;

import javax.servlet.ServletContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;

import javax.ws.rs.core.*;
import vos.Espectaculo;

@Path("espectaculos")
public class EspectaculoResource 
{

	@Context
	private ServletContext context;

	private String getPath() {
		return context.getRealPath("WEB-INF/ConnectionData");
	}
	
	private String doErrorMessage(Exception e)
	{
		return "{ \"ERROR\": \""+ e.getMessage() + "\"}" ;
	}
	
	//GET SERVICES:
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getEspectaculos()
	{
		return null;
		
	}
	
	//POST SERVICES:
	
	@POST
	@Path("/espectaculos")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response registrarEspectaculo(Espectaculo espectaculo)
	{
		FestivAndesTransactionManager tm = new FestivAndesTransactionManager(getPath());
		try 
		{
			tm.addEspectaculo(espectaculo);
		} 
		catch (Exception e) 
		{
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(espectaculo).build();
	}
}

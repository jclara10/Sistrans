package rest;

import javax.servlet.ServletContext;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import tm.FestivAndesTransactionManager;
import vos.CompaniaDeTeatro;
import vos.Espectaculo;

@Path("companias")
public class CompaniaDeTeatroResource 
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
	
	@POST
	@Path("/companias")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response registrarCompania(CompaniaDeTeatro compania)
	{
		FestivAndesTransactionManager tm = new FestivAndesTransactionManager(getPath());
		try 
		{
			tm.addCompaniaDeTeatro(compania);
		} 
		catch (Exception e) 
		{
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(compania).build();
	}

}

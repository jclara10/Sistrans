package rest;


import javax.servlet.ServletContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;

import tm.FestivAndesTransactionManager;

import javax.ws.rs.core.*;
import vos.Escenario;

@Path("/escenarios")
public class EscenarioResource 
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
	@Path("/GetEscenariosGET")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getEscenario()
	{
		return null;
		//DEBE PODERSE AGRUPAR Y ORDENAR EL RESULTADO SEGUN CRITERIO VER ENUNCIADO
	}
	
	
	
	//POST SERVICES:
	
	@POST
	@Path("/escenarios")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response registrarEscenario(Escenario escenario)
	{
		FestivAndesTransactionManager tm = new FestivAndesTransactionManager(getPath());
		try 
		{
			tm.addEscenario(escenario);
		} 
		catch (Exception e) 
		{
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(escenario).build();
	}

}

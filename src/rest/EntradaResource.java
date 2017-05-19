package rest;

import javax.servlet.ServletContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import tm.FestivAndesTransactionManager;
import vos.Cliente;
import vos.Entrada;

@Path("/entradas")
public class EntradaResource 
{

	@Context
	private ServletContext context;

	private String getPath() 
	{
		return context.getRealPath("WEB-INF/ConnectionData");
	}
	
	private String doErrorMessage(Exception e)
	{
		return "{ \"ERROR\": \""+ e.getMessage() + "\"}" ;
	}
	
	@DELETE
	@Path("{Id: \\d+}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response devolverBoleta(@javax.ws.rs.PathParam("Id") int id)
	{
		FestivAndesTransactionManager tm = new FestivAndesTransactionManager(getPath());
		try
		{
			tm.devolverEntrada(id);
		}
		catch (Exception e)
		{
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(id).build();
	}
	
	@DELETE
	@Path("devolverAbono/idCliente/idAbono")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response devolverAbono(@PathParam ("idCliente") int idCliente, @PathParam ("idAbono") int idAbono)
	{
		FestivAndesTransactionManager tm = new FestivAndesTransactionManager(getPath());
		try
		{
			tm.devolverAbono(idCliente, idAbono);
		}
		catch (Exception e)
		{
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(idAbono).build();
	}
	
	@GET
	@Path("asistencia/idCliente/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response ConsultarAsistencia(@PathParam ("idCliente") int idCliente)
	{
		FestivAndesTransactionManager tm = new FestivAndesTransactionManager(getPath());
		try
		{
			tm.darAsistencias(idCliente);
		}
		catch (Exception e)
		{
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(idCliente).build();
	}
	@GET
	@Path("noAsistencia/idCliente/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response ConsultarNoAsistencia(@PathParam ("idCliente") int idCliente)
	{
		FestivAndesTransactionManager tm = new FestivAndesTransactionManager(getPath());
		try
		{
			tm.darNoAsistencias(idCliente);
		}
		catch (Exception e)
		{
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(idCliente).build();
	}
}

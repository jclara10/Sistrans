package rest;

import javax.servlet.ServletContext;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import tm.FestivAndesTransactionManager;
import vos.Abono;
import vos.Cliente;
import vos.Escenario;

@Path("/clientes")
public class ClienteResource 
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
	@Path("/cliente")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response registrarCliente(Cliente cliente)
	{
		FestivAndesTransactionManager tm = new FestivAndesTransactionManager(getPath());
		try 
		{
			tm.addCliente(cliente);
		} 
		catch (Exception e) 
		{
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(cliente).build();
	}
	
	@PUT
	@Path("/cliente")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateCliente(Cliente cliente) 
	{
		FestivAndesTransactionManager tm = new FestivAndesTransactionManager(getPath());
		try 
		{
			tm.updateCliente(cliente);
		} 
		catch (Exception e) 
		{
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(cliente).build();
	}
	
	@PUT
	@Path("/cliente/abono")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response abonarCliente(Abono abono) 
	{
		FestivAndesTransactionManager tm = new FestivAndesTransactionManager(getPath());
		try 
		{
			tm.abonarCliente(abono);
		} 
		catch (Exception e) 
		{
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(abono).build();
	}
	
	@GET
	@Path("{Id: \\d+}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response darCantidadAsistencias(@javax.ws.rs.PathParam("Id") int id) 
	{
		FestivAndesTransactionManager tm = new FestivAndesTransactionManager(getPath());
		int respuesta;
		try 
		{
			if(id < 0)
			{
				throw new Exception("Nombre del video no valido");
			}
			respuesta = tm.darAsistencias(id);
		} 
		catch (Exception e) 
		{
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(respuesta).build();
	}

}

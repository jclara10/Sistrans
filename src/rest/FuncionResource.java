package rest;

import javax.servlet.ServletContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;

import tm.FestivAndesTransactionManager;

import javax.ws.rs.core.*;

import vos.Entrada;
import vos.Espectaculo;
import vos.Funcion;
import vos.ListaEntradas;

@Path("funciones")
public class FuncionResource
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
	
	//POST SERVICES:
	
		@POST
		@Path("/funciones")
		@Consumes(MediaType.APPLICATION_JSON)
		@Produces(MediaType.APPLICATION_JSON)
		public Response registrarFuncion(Funcion funcion)
		{
			FestivAndesTransactionManager tm = new FestivAndesTransactionManager(getPath());
			try 
			{
				tm.addFuncion(funcion);
			} 
			catch (Exception e) 
			{
				return Response.status(500).entity(doErrorMessage(e)).build();
			}
			return Response.status(200).entity(funcion).build();
		}
		
		@PUT
		@Path("/funcion/entrada")
		@Consumes(MediaType.APPLICATION_JSON)
		@Produces(MediaType.APPLICATION_JSON)
		public Response comprarEntrada(Entrada entrada)
		{
			FestivAndesTransactionManager tm = new FestivAndesTransactionManager(getPath());
			try 
			{
				tm.updateFuncion(entrada.getCodigoFuncion());
				tm.addEntrada(entrada);
			} 
			catch (Exception e) 
			{
				return Response.status(500).entity(doErrorMessage(e)).build();
			}
			return Response.status(200).entity(entrada).build();
		}
		
		@PUT
		@Path("/funcion/entradas")
		@Consumes(MediaType.APPLICATION_JSON)
		@Produces(MediaType.APPLICATION_JSON)
		public Response comprarEntradas(ListaEntradas entradas)
		{
			FestivAndesTransactionManager tm = new FestivAndesTransactionManager(getPath());
			try 
			{
				tm.updateFunciones(entradas);
				tm.addEntradas(entradas);
			} 
			catch (Exception e) 
			{
				return Response.status(500).entity(doErrorMessage(e)).build();
			}
			return Response.status(200).entity(entradas).build();
		}
		
		@PUT
		@Path("/funcion")
		@Consumes(MediaType.APPLICATION_JSON)
		@Produces(MediaType.APPLICATION_JSON)
		public Response registrarRealizacionDeUnaFuncion(Funcion funcion)
		{
			FestivAndesTransactionManager tm = new FestivAndesTransactionManager(getPath());
			try 
			{
				tm.updateFuncion(funcion);
			} 
			catch (Exception e) 
			{
				return Response.status(500).entity(doErrorMessage(e)).build();
			}
			return Response.status(200).entity(funcion).build();
		}
		
		@DELETE
		@Path("{Id: \\d+}")
		@Consumes(MediaType.APPLICATION_JSON)
		@Produces(MediaType.APPLICATION_JSON)
		public Response cancelarFuncion(@javax.ws.rs.PathParam("Id") int id)
		{
			FestivAndesTransactionManager tm = new FestivAndesTransactionManager(getPath());
			try 
			{
				tm.deleteFuncion(id);
			} 
			catch (Exception e) 
			{
				return Response.status(500).entity(doErrorMessage(e)).build();
			}
			return Response.status(200).entity(id).build();
		}
	
}

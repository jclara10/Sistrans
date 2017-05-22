package rest;

import javax.servlet.ServletContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import tm.FestivAndesTransactionManager;
import vos.Abono;
import vos.Cliente;
import vos.CompaniaDeTeatro;
import vos.Entrada;
import vos.Escenario;
import vos.Espectaculo;
import vos.Funcion;
import vos.ListaEntradas;

@Path("/festivAndes")
public class FestivAndesServices 
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
	
	
	// GET SERVICES
	
	@GET
	@Path("/cliente/{Id: \\d+}/asistencias")
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
	
	/**TOCA ARREGLAR ESTO PORQUE EL PARAMETRO ESTÁ MAL
	 * 
	 * 
	@GET
	@Path("/asistencia/idCliente/")
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
	}*/
	
	
	// POST SERVICES
	
	@POST
	@Path("/clientes")
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
	
	// PUT SERVICES
	
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
	
	@PUT
	@Path("/cliente")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response actualizarInfoCliente(Cliente cliente) 
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
	@Path("/cliente/abonamiento")
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
	
	// DELETE SERVICES
	
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
	
	/** TOCA ARREGLARLO PORQUE LOS PARAMETROS ESTAN MAL
	@DELETE
	@Path("/devolverAbono/idCliente/idAbono")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response devolverAbonamiento(@PathParam ("idCliente") int idCliente, @PathParam ("idAbono") int idAbono)
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
	}*/
	
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

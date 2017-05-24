package tm;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import dao.DAOClientes;
import dao.DAOCompaniasDeTeatro;
import dao.DAOEntradas;
import dao.DAOEscenarios;
import dao.DAOEspectaculos;
import dao.DAOFunciones;
import dao.DAORentabilidad;
import dtm.IncompleteReplyException;
import dtm.JMSFunciones;
import dtm.JMSRentabilidad;
import dtm.NonReplyException;
import vos.Abono;
import vos.Cliente;
import vos.CompaniaDeTeatro;
import vos.Entrada;
import vos.Escenario;
import vos.Espectaculo;
import vos.Funcion;
import vos.ListaEntradas;
import vos.ListaFunciones;
import vos.ListaRentabilidades;
import vos.RentabilidadCompania;

public class FestivAndesTransactionManager {

	public static final String CONNECTION_DATA_FILE_NAME_REMOTE = "/conexion.properties";

	private static String connectionDataPath;

	private String user;

	private String password;

	private String url;

	private String driver;

	private Connection conn1;

	private Connection conn2;
	
	private Connection conn3;

	private String myQueue;


	private int numberApps;

	private String topicAllFunciones;
	
	private String nombreCompaniasMachete;

	public FestivAndesTransactionManager(String contextPathP) 
	{
		connectionDataPath = contextPathP + CONNECTION_DATA_FILE_NAME_REMOTE;
		initConnectionData();
	}

	private void initConnectionData() 
	{
		try 
		{
			File arch = new File(this.connectionDataPath);
			Properties prop = new Properties();
			FileInputStream in = new FileInputStream(arch);
			prop.load(in);
			in.close();
			this.url = prop.getProperty("url");
			this.user = prop.getProperty("usuario");
			this.password = prop.getProperty("clave");
			this.driver = prop.getProperty("driver");
			Class.forName(driver);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

	private Connection darConexion() throws SQLException 
	{
		System.out.println("Connecting to: " + url + " With user: " + user);
		return DriverManager.getConnection(url, user, password);
	}

	////////////////////////////////////////
	///////Transacciones////////////////////
	////////////////////////////////////////

	public void addCliente(Cliente cliente) throws Exception
	{
		DAOClientes daoClientes = new DAOClientes();
		try 
		{
			//////Transaccion
			this.conn1 = darConexion();
			daoClientes.setConn(conn1);
			daoClientes.addCliente(cliente);
			conn1.commit();

		} 
		catch (SQLException e) 
		{
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		}
		catch (Exception e) 
		{
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		}
		finally 
		{
			try 
			{
				daoClientes.cerrarRecursos();
				if(this.conn1!=null)
					this.conn1.close();
			}
			catch (SQLException exception) 
			{
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}

	public void updateCliente(Cliente cliente) throws Exception 
	{
		DAOClientes daoClientes = new DAOClientes();
		try 
		{
			//////Transacci贸n
			this.conn1 = darConexion();
			daoClientes.setConn(conn1);
			daoClientes.updateCliente(cliente);

		} 
		catch (SQLException e) 
		{
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} 
		catch (Exception e) 
		{
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		}
		finally 
		{
			try 
			{
				daoClientes.cerrarRecursos();
				if(this.conn1!=null)
					this.conn1.close();
			}
			catch (SQLException exception) 
			{
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}

	public void addCompaniaDeTeatro(CompaniaDeTeatro compania) throws Exception
	{
		DAOCompaniasDeTeatro daoCompaniasDeTeatro = new DAOCompaniasDeTeatro();
		try 
		{
			//////Transaccion
			this.conn1 = darConexion();
			daoCompaniasDeTeatro.setConn(conn1);
			daoCompaniasDeTeatro.addCompaniaDeTeatro(compania);
			conn1.commit();

		} 
		catch (SQLException e) 
		{
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		}
		catch (Exception e) 
		{
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		}
		finally 
		{
			try 
			{
				daoCompaniasDeTeatro.cerrarRecursos();
				if(this.conn1!=null)
					this.conn1.close();
			}
			catch (SQLException exception) 
			{
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}

	public void addEntrada(Entrada entrada) throws Exception 
	{
		DAOEntradas daoEntradas = new DAOEntradas();
		try 
		{
			//////Transaccion
			this.conn1 = darConexion();
			daoEntradas.setConn(conn1);
			daoEntradas.addEntrada(entrada);
			conn1.commit();

		} 
		catch (SQLException e) 
		{
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		}
		catch (Exception e) 
		{
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		}
		finally 
		{
			try 
			{
				daoEntradas.cerrarRecursos();
				if(this.conn1!=null)
					this.conn1.close();
			}
			catch (SQLException exception) 
			{
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}

	public void addEscenario(Escenario escenario) throws Exception
	{
		DAOEscenarios daoEscenarios = new DAOEscenarios();
		try 
		{
			//////Transaccion
			this.conn1 = darConexion();
			daoEscenarios.setConn(conn1);
			daoEscenarios.addEscenario(escenario);
			conn1.commit();

		} 
		catch (SQLException e) 
		{
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		}
		catch (Exception e) 
		{
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		}
		finally 
		{
			try 
			{
				daoEscenarios.cerrarRecursos();
				if(this.conn1!=null)
					this.conn1.close();
			}
			catch (SQLException exception) 
			{
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}


	public void addEspectaculo(Espectaculo espectaculo) throws Exception
	{
		DAOEspectaculos daoEspectaculos = new DAOEspectaculos();
		try 
		{
			//////Transaccion
			this.conn1 = darConexion();
			daoEspectaculos.setConn(conn1);
			daoEspectaculos.addEspectaculo(espectaculo);
			conn1.commit();

		} 
		catch (SQLException e) 
		{
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		}
		catch (Exception e) 
		{
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		}
		finally 
		{
			try 
			{
				daoEspectaculos.cerrarRecursos();
				if(this.conn1!=null)
					this.conn1.close();
			}
			catch (SQLException exception) 
			{
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}

	public void addFuncion(Funcion funcion) throws Exception  
	{
		DAOFunciones daoFunciones = new DAOFunciones();
		try 
		{
			//////Transaccion
			this.conn1 = darConexion();
			daoFunciones.setConn(conn1);
			daoFunciones.addFuncion(funcion);
			conn1.commit();

		} 
		catch (SQLException e) 
		{
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		}
		catch (Exception e) 
		{
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		}
		finally 
		{
			try 
			{
				daoFunciones.cerrarRecursos();
				if(this.conn1!=null)
					this.conn1.close();
			}
			catch (SQLException exception) 
			{
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}

	public void updateFuncion(int codFuncion) throws Exception  
	{
		DAOFunciones daoFunciones = new DAOFunciones();
		try 
		{
			//////Transacci贸n
			this.conn1 = darConexion();
			daoFunciones.setConn(conn1);
			daoFunciones.updateFuncion(codFuncion);

		} 
		catch (SQLException e) 
		{
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} 
		catch (Exception e) 
		{
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		}
		finally 
		{
			try 
			{
				daoFunciones.cerrarRecursos();
				if(this.conn1!=null)
					this.conn1.close();
			}
			catch (SQLException exception) 
			{
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}

	public void updateFuncion(Funcion funcion) throws Exception  
	{
		DAOFunciones daoFunciones = new DAOFunciones();
		try 
		{
			//////Transacci贸n
			this.conn1 = darConexion();
			daoFunciones.setConn(conn1);
			daoFunciones.updateFuncion(funcion);

		} 
		catch (SQLException e) 
		{
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} 
		catch (Exception e) 
		{
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		}
		finally 
		{
			try 
			{
				daoFunciones.cerrarRecursos();
				if(this.conn1!=null)
					this.conn1.close();
			}
			catch (SQLException exception) 
			{
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}

	public void addEntradas(ListaEntradas entradas) throws Exception
	{
		DAOEntradas daoEntradas = new DAOEntradas();
		try 
		{
			//////Transacci髇 - ACID Example
			this.conn1 = darConexion();
			conn1.setAutoCommit(false);
			daoEntradas.setConn(conn1);
			for(Entrada entrada : entradas.getEntradas())
				daoEntradas.addEntrada(entrada);
			conn1.commit();
		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			conn1.rollback();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			conn1.rollback();
			throw e;
		} finally {
			try {
				daoEntradas.cerrarRecursos();
				if(this.conn1!=null)
					this.conn1.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}

	public void updateFunciones(ListaEntradas entradas) throws Exception
	{
		DAOFunciones daoFunciones = new DAOFunciones();
		try 
		{
			//////Transacci贸n
			this.conn1 = darConexion();
			conn1.setAutoCommit(false);
			daoFunciones.setConn(conn1);
			for(Entrada entrada: entradas.getEntradas())
			{
				int codActual = entrada.getCodigo();
				daoFunciones.updateFuncion(codActual);
			}
			conn1.commit();
		} 
		catch (SQLException e) 
		{
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			conn1.rollback();
			throw e;
		} 
		catch (Exception e) 
		{
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			conn1.rollback();
			throw e;
		}
		finally 
		{
			try 
			{
				daoFunciones.cerrarRecursos();
				if(this.conn1!=null)
					this.conn1.close();
			}
			catch (SQLException exception) 
			{
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}

	public void devolverEntrada(int id) throws Exception
	{
		DAOEntradas dao = new DAOEntradas();
		try
		{
			this.conn1 = darConexion();
			conn1.setAutoCommit(false);
			dao.setConn(conn1);
			dao.devolverEntrada(id);
			conn1.commit();
		}
		catch (SQLException e) 
		{
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			conn1.rollback();
			throw e;
		} 
		catch (Exception e) 
		{
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			conn1.rollback();
			throw e;
		}
		finally 
		{
			try 
			{
				dao.cerrarRecursos();
				if(this.conn1!=null)
					this.conn1.close();
			}
			catch (SQLException exception) 
			{
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}

	public void devolverAbono(int idCliente, int idAbono) throws Exception
	{
		DAOEntradas dao = new DAOEntradas();
		try
		{
			this.conn1 = darConexion();
			conn1.setAutoCommit(false);
			dao.setConn(conn1);
			dao.devolverAbono(idCliente,idAbono);
			conn1.commit();
		}
		catch (SQLException e) 
		{
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			conn1.rollback();
			throw e;
		} 
		catch (Exception e) 
		{
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			conn1.rollback();
			throw e;
		}
		finally 
		{
			try 
			{
				dao.cerrarRecursos();
				if(this.conn1!=null)
					this.conn1.close();
			}
			catch (SQLException exception) 
			{
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}

	public void abonarCliente(Abono abono) throws Exception
	{
		DAOClientes dao = new DAOClientes();
		DAOEntradas daoEnt = new DAOEntradas();
		try
		{
			this.conn1 = darConexion();
			conn1.setAutoCommit(false);
			dao.setConn(conn1);
			System.out.println("Listo");
			dao.abonar(abono.getIdCliente());

			daoEnt.registrarAbono(abono);
			conn1.commit();
		}
		catch (SQLException e) 
		{
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			conn1.rollback();
			throw e;
		} 
		catch (Exception e) 
		{
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			conn1.rollback();
			throw e;
		}
		finally 
		{
			try 
			{
				dao.cerrarRecursos();
				if(this.conn1!=null)
					this.conn1.close();
			}
			catch (SQLException exception) 
			{
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}

	/**
	public void abonarClienteRemoto(Abono abono) throws Exception 
	{
		DAOClientes daoClientes = new DAOClientes();
		DAOFunciones daoFunciones = new DAOFunciones();
		try 
		{	
			Connection conn = darConexion();
			daoClientes.setConn(conn);
			daoFunciones.setConn(conn);
			daoClientes.abonar(abono.getIdCliente());

			JMSFunciones instancia = JMSFunciones.darInstacia(this);
			instancia.setUpJMSManager(this.numberApps, this.myQueue, this.topicAllAlgo);
			instancia.doReq(abono);  
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			throw e;
		} finally 
		{
			try 
			{
				daoClientes.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}*/

	public int darAsistencias(int id) throws Exception
	{
		DAOFunciones dao = new DAOFunciones();
		int asistencias = -1;
		try
		{
			this.conn1 = darConexion();
			conn1.setAutoCommit(false);
			dao.setConn(conn1);
			asistencias = dao.darAsistenciaCliente(id);
			conn1.commit();
		}
		catch (SQLException e) 
		{
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			conn1.rollback();
			throw e;
		} 
		catch (Exception e) 
		{
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			conn1.rollback();
			throw e;
		}
		finally 
		{
			try 
			{
				dao.cerrarRecursos();
				if(this.conn1!=null)
					this.conn1.close();
			}
			catch (SQLException exception) 
			{
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}

		return asistencias;
	}
	public int darNoAsistencias(int id) throws Exception
	{
		DAOFunciones dao = new DAOFunciones();
		int asistencias = -1;
		try
		{
			this.conn1 = darConexion();
			conn1.setAutoCommit(false);
			dao.setConn(conn1);
			asistencias = dao.darNoAsistenciaCliente(id);
			conn1.commit();
		}
		catch (SQLException e) 
		{
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			conn1.rollback();
			throw e;
		} 
		catch (Exception e) 
		{
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			conn1.rollback();
			throw e;
		}
		finally 
		{
			try 
			{
				dao.cerrarRecursos();
				if(this.conn1!=null)
					this.conn1.close();
			}
			catch (SQLException exception) 
			{
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}

		return asistencias;
	}

	public void deleteFuncion(int id) throws Exception
	{
		DAOFunciones dao = new DAOFunciones();
		DAOEntradas daoEnt = new DAOEntradas();
		try
		{
			this.conn1 = darConexion();
			conn1.setAutoCommit(false);
			dao.setConn(conn1);
			daoEnt.setConn(conn1);
			dao.cancelarFuncion(id);
			daoEnt.devolverEntradasFuncionCancelada(id);
			conn1.commit();
		}
		catch (SQLException e) 
		{
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			conn1.rollback();
			throw e;
		} 
		catch (Exception e) 
		{
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			conn1.rollback();
			throw e;
		}
		finally 
		{
			try 
			{
				dao.cerrarRecursos();
				if(this.conn1!=null)
					this.conn1.close();
			}
			catch (SQLException exception) 
			{
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}

	public ListaFunciones darFuncionesRemote() throws Exception 
	{
		ListaFunciones funciones;
		DAOFunciones dao = new DAOFunciones();
		ArrayList<Funcion> funcionesLocal = new ArrayList<Funcion>();
		try {	
			Connection conn = darConexion();
			dao.setConn(conn);
			funcionesLocal = dao.darFunciones();

			JMSFunciones instancia = JMSFunciones.darInstacia(this);
			instancia.setUpJMSManager(this.numberApps, this.myQueue, this.topicAllFunciones);
			funciones = instancia.getFuncionesResponse();  

			funciones.addFunciones(new ListaFunciones(funcionesLocal));
			System.out.println("size:" + funciones.getFunciones().size());
		} catch (NonReplyException e) 
		{
			throw new IncompleteReplyException("No Reply from apps - Local Videos:",new ListaFunciones(funcionesLocal));
		} catch (IncompleteReplyException e) {
			ListaFunciones temp = e.getPartialResponseFunciones();
			temp.addFunciones(new ListaFunciones(funcionesLocal));
			throw new IncompleteReplyException("Incomplete Reply:",temp);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			try {
				dao.cerrarRecursos();
				if(this.conn1!=null)
					this.conn1.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
		return funciones; 

	}

	public ListaFunciones darFuncionesLocal() throws Exception 
	{
		ArrayList<Funcion> funciones;
		DAOFunciones daoFunciones = new DAOFunciones();
		try 
		{
			//////Transacci髇
			this.conn1 = darConexion();
			daoFunciones.setConn(conn1);
			funciones = daoFunciones.darFunciones();

		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			try {
				daoFunciones.cerrarRecursos();
				if(this.conn1!=null)
					this.conn1.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
		return new ListaFunciones(funciones);
	}

	public ListaRentabilidades darRentabilidadRemote(String nombreCompania) throws Exception 
	{
		nombreCompaniasMachete = nombreCompania;
		ListaRentabilidades rentabilidad;
		DAORentabilidad dao = new DAORentabilidad();
		ArrayList<RentabilidadCompania> rentabilidadLocal = new ArrayList<RentabilidadCompania>();
		try {	
			Connection conn = darConexion();
			dao.setConn(conn);
			rentabilidadLocal = dao.darRentabilidad(nombreCompania);

			JMSRentabilidad instancia = JMSRentabilidad.darInstacia(this);
			instancia.setUpJMSManager(this.numberApps, this.myQueue, this.topicAllFunciones);
			rentabilidad = instancia.getRentabilidadResponse();  

			rentabilidad.addRentabilidades(new ListaRentabilidades(rentabilidadLocal));
			System.out.println("size:" + rentabilidad.getRentabilidades().size());
		} catch (NonReplyException e) 
		{
			throw new IncompleteReplyException("No Reply from apps - Local Videos:",new ListaRentabilidades(rentabilidadLocal));
		} catch (IncompleteReplyException e) {
			ListaRentabilidades temp = e.getPartialResponseRentabilidades();
			temp.addRentabilidades(new ListaRentabilidades(rentabilidadLocal));
			throw new IncompleteReplyException("Incomplete Reply:",temp);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			try {
				dao.cerrarRecursos();
				if(this.conn1!=null)
					this.conn1.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
		return rentabilidad; 
	}

	public ListaRentabilidades darRentabilidadLocal() throws Exception 
	{
		ArrayList<RentabilidadCompania> rentabilidad;
		DAORentabilidad daoRentabilidad = new DAORentabilidad();
		
		try 
		{
			//////Transacci髇
			this.conn1 = darConexion();
			daoRentabilidad.setConn(conn1);
			rentabilidad = daoRentabilidad.darRentabilidad(nombreCompaniasMachete);

		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			try {
				daoRentabilidad.cerrarRecursos();
				if(this.conn1!=null)
					this.conn1.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
		return new ListaRentabilidades(rentabilidad);
	}

	public void RetirarCompaniaLocal(int idCompania) throws Exception{
		 		DAOFunciones daoFunciones = new DAOFunciones();
		 		this.conn1 = darConexion();
		 		daoFunciones.setConn(conn1);
		 		conn1.setAutoCommit(false);
		 		Savepoint s = conn1.setSavepoint("retirarCompania");
		 		List<Funcion> funciones = null;
		 		try 
		 		{
		 			//////Transacci髇
		 			funciones = daoFunciones.darFunciones();
		 			for(int i = 0; i < funciones.size(); i++)
		 			{
		 				deleteFuncion(i);
		 			}
		 
		 		} catch (SQLException e) {
		 			conn1.rollback(s);
		 			System.err.println("SQLException:" + e.getMessage());
		 			e.printStackTrace();
		 			throw e;
		 		} catch (Exception e) {
		 			conn1.rollback(s);
		 			System.err.println("GeneralException:" + e.getMessage());
		 			e.printStackTrace();
		 			throw e;
		 		} finally {
		 			try {
		 				daoFunciones.cerrarRecursos();
		 				if(this.conn1!=null)
		 					this.conn1.close();
		 			} catch (SQLException exception) {
		 				System.err.println("SQLException closing resources:" + exception.getMessage());
		 				exception.printStackTrace();
		 				throw exception;
		 			}
		 		}
		 	}
	public void retirarCompaniaRemote() throws Exception 
	{
		ListaFunciones funciones;
		DAOFunciones dao = new DAOFunciones();
		ArrayList<Funcion> funcionesLocal = new ArrayList<Funcion>();
		try {	
			Connection conn = darConexion();
			dao.setConn(conn);
			funcionesLocal = dao.darFunciones();

			JMSFunciones instancia = JMSFunciones.darInstacia(this);
			instancia.setUpJMSManager(this.numberApps, this.myQueue, this.topicAllFunciones);
			funciones = instancia.getFuncionesResponse();  
 			for(int i = 0; i < funcionesLocal.size(); i++)
 			{
 				deleteFuncion(i);
 			}
		} catch (NonReplyException e) 
		{
			throw new IncompleteReplyException("No Reply from apps - Local Videos:",new ListaFunciones(funcionesLocal));
		} catch (IncompleteReplyException e) {
			ListaFunciones temp = e.getPartialResponseFunciones();
			temp.addFunciones(new ListaFunciones(funcionesLocal));
			throw new IncompleteReplyException("Incomplete Reply:",temp);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			try {
				dao.cerrarRecursos();
				if(this.conn1!=null)
					this.conn1.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		} 

	}
	
	public boolean deleteCompania2pc(int idCompania) throws SQLException, Exception {
		try{
			InitialContext ctx = new InitialContext();
			UserTransaction utx = (UserTransaction) ctx.lookup("/UserTransaction");
			
			try {
				
				this.conn1 = darConexion1();
				this.conn2 = darConexion2();
				this.conn3 = darConexion3();
				utx.begin();
				try {
					Statement st = conn1.createStatement();
					String sql = "DELETE FROM BOLETA WHERE FUNCION IN (SELECT IDFUNCION FROM "
							+ "(SELECT FUNCION.ID AS IDFUNCION,FUNCION.ESPECTACULO FROM FUNCION "
							+ "INNER JOIN ESPECTACULO ON FUNCION.ESPECTACULO = ESPECTACULO.ID)T1 "
							+ "INNER JOIN PATROCINA ON T1.ESPECTACULO = PATROCINA.IDESPECTACULO WHERE IDCOMPANIA ="+idCompania + ")";
				System.out.println(sql);
				st.executeQuery(sql);
				sql = "DELETE FROM FUNCION WHERE ID IN (SELECT IDFUNCION FROM "
						+ "(SELECT FUNCION.ID AS IDFUNCION,FUNCION.ESPECTACULO FROM FUNCION "
						+ "INNER JOIN ESPECTACULO ON FUNCION.ESPECTACULO = ESPECTACULO.ID)T1 "
						+ "INNER JOIN PATROCINA ON T1.ESPECTACULO = PATROCINA.IDESPECTACULO WHERE IDCOMPANIA ="+ idCompania +")";
				st.executeQuery(sql);
				sql = "DELETE FROM COMPANIA WHERE ID = "+ idCompania;
				st.executeQuery(sql);
				System.out.println("OK Datasource 1");
				st.close();
				
				} catch (Exception e) {
					// TODO: handle exception
					utx.setRollbackOnly();
				}
				try {
					Statement st = conn2.createStatement();
					String sql = "DELETE FROM BOLETA WHERE IDBOLETA IN "
							+ "(SELECT DISTINCT IDBOLETA FROM BOLETA NATURAL"
							+ " JOIN FUNCION NATURAL JOIN OBRA NATURAL JOIN "
							+ "FUNCION NATURAL JOIN COMPANIAOBRA NATURAL JOIN "
							+ "COMPANIA WHERE IDCOMPANIA = "+ idCompania+ ")";
				System.out.println(sql);
				st.executeQuery(sql);
				sql = "UPDATE FUNCION SET REALIZADO = 2 WHERE IDFUNCION IN "
						+ "(SELECT DISTINCT IDFUNCION FROM FUNCION NATURAL JOIN "
						+ "OBRA NATURAL JOIN FUNCION NATURAL JOIN COMPANIAOBRA NATURAL JOIN "
						+ "COMPANIA WHERE IDCOMPANIA = "+ idCompania +")";
				st.executeQuery(sql);
				sql = "DELETE FROM COMPANIA WHERE ID = "+idCompania;
				st.executeQuery(sql);
				System.out.println("OK Datasource 2");
				st.close();
				
				} catch (Exception e) {
					// TODO: handle exception
					utx.setRollbackOnly();
				}
				try {
					Statement st = conn3.createStatement();
					String sql = "DELETE FROM BOLETA WHERE FUNCION IN (SELECT IDFUNCION FROM "
							+ "(SELECT FUNCION.ID AS IDFUNCION,FUNCION.ESPECTACULO FROM FUNCION "
							+ "INNER JOIN ESPECTACULO ON FUNCION.ESPECTACULO = ESPECTACULO.ID)T1 "
							+ "INNER JOIN PATROCINA ON T1.ESPECTACULO = PATROCINA.IDESPECTACULO WHERE IDCOMPANIA ="+idCompania + ")";
				System.out.println(sql);
				st.executeQuery(sql);
				sql = "DELETE FROM FUNCION WHERE ID IN (SELECT IDFUNCION FROM "
						+ "(SELECT FUNCION.ID AS IDFUNCION,FUNCION.ESPECTACULO FROM FUNCION "
						+ "INNER JOIN ESPECTACULO ON FUNCION.ESPECTACULO = ESPECTACULO.ID)T1 "
						+ "INNER JOIN PATROCINA ON T1.ESPECTACULO = PATROCINA.IDESPECTACULO WHERE IDCOMPANIA ="+ idCompania +")";
				st.executeQuery(sql);
				sql = "DELETE FROM COMPANIA WHERE ID = "+idCompania;
				st.executeQuery(sql);
				System.out.println("OK Datasource 3");
				st.close();
				
				} catch (Exception e) {
					// TODO: handle exception
					utx.setRollbackOnly();
				}
				utx.commit();
				conn1.close();
				conn2.close();
				conn3.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		
		return true;
	}
}

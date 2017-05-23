package tm;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import dao.DAOClientes;
import dao.DAOCompaniasDeTeatro;
import dao.DAOEntradas;
import dao.DAOEscenarios;
import dao.DAOEspectaculos;
import dao.DAOFunciones;
import dtm.IncompleteReplyException;
import dtm.JMSFunciones;
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

public class FestivAndesTransactionManager {

	public static final String CONNECTION_DATA_FILE_NAME_REMOTE = "/conexion.properties";

	private static String connectionDataPath;

	private String user;

	private String password;

	private String url;

	private String driver;

	private Connection conn;


	private String myQueue;


	private int numberApps;

	private String topicAllFunciones;

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
			this.conn = darConexion();
			daoClientes.setConn(conn);
			daoClientes.addCliente(cliente);
			conn.commit();

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
				if(this.conn!=null)
					this.conn.close();
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
			this.conn = darConexion();
			daoClientes.setConn(conn);
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
				if(this.conn!=null)
					this.conn.close();
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
			this.conn = darConexion();
			daoCompaniasDeTeatro.setConn(conn);
			daoCompaniasDeTeatro.addCompaniaDeTeatro(compania);
			conn.commit();

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
				if(this.conn!=null)
					this.conn.close();
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
			this.conn = darConexion();
			daoEntradas.setConn(conn);
			daoEntradas.addEntrada(entrada);
			conn.commit();

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
				if(this.conn!=null)
					this.conn.close();
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
			this.conn = darConexion();
			daoEscenarios.setConn(conn);
			daoEscenarios.addEscenario(escenario);
			conn.commit();

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
				if(this.conn!=null)
					this.conn.close();
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
			this.conn = darConexion();
			daoEspectaculos.setConn(conn);
			daoEspectaculos.addEspectaculo(espectaculo);
			conn.commit();

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
				if(this.conn!=null)
					this.conn.close();
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
			this.conn = darConexion();
			daoFunciones.setConn(conn);
			daoFunciones.addFuncion(funcion);
			conn.commit();

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
				if(this.conn!=null)
					this.conn.close();
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
			this.conn = darConexion();
			daoFunciones.setConn(conn);
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
				if(this.conn!=null)
					this.conn.close();
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
			this.conn = darConexion();
			daoFunciones.setConn(conn);
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
				if(this.conn!=null)
					this.conn.close();
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
			this.conn = darConexion();
			conn.setAutoCommit(false);
			daoEntradas.setConn(conn);
			for(Entrada entrada : entradas.getEntradas())
				daoEntradas.addEntrada(entrada);
			conn.commit();
		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			conn.rollback();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			conn.rollback();
			throw e;
		} finally {
			try {
				daoEntradas.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
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
			this.conn = darConexion();
			conn.setAutoCommit(false);
			daoFunciones.setConn(conn);
			for(Entrada entrada: entradas.getEntradas())
			{
				int codActual = entrada.getCodigo();
				daoFunciones.updateFuncion(codActual);
			}
			conn.commit();
		} 
		catch (SQLException e) 
		{
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			conn.rollback();
			throw e;
		} 
		catch (Exception e) 
		{
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			conn.rollback();
			throw e;
		}
		finally 
		{
			try 
			{
				daoFunciones.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
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
			this.conn = darConexion();
			conn.setAutoCommit(false);
			dao.setConn(conn);
			dao.devolverEntrada(id);
			conn.commit();
		}
		catch (SQLException e) 
		{
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			conn.rollback();
			throw e;
		} 
		catch (Exception e) 
		{
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			conn.rollback();
			throw e;
		}
		finally 
		{
			try 
			{
				dao.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
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
			this.conn = darConexion();
			conn.setAutoCommit(false);
			dao.setConn(conn);
			dao.devolverAbono(idCliente,idAbono);
			conn.commit();
		}
		catch (SQLException e) 
		{
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			conn.rollback();
			throw e;
		} 
		catch (Exception e) 
		{
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			conn.rollback();
			throw e;
		}
		finally 
		{
			try 
			{
				dao.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
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
			this.conn = darConexion();
			conn.setAutoCommit(false);
			dao.setConn(conn);
			System.out.println("Listo");
			dao.abonar(abono.getIdCliente());

			daoEnt.registrarAbono(abono);
			conn.commit();
		}
		catch (SQLException e) 
		{
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			conn.rollback();
			throw e;
		} 
		catch (Exception e) 
		{
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			conn.rollback();
			throw e;
		}
		finally 
		{
			try 
			{
				dao.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
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
			this.conn = darConexion();
			conn.setAutoCommit(false);
			dao.setConn(conn);
			asistencias = dao.darAsistenciaCliente(id);
			conn.commit();
		}
		catch (SQLException e) 
		{
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			conn.rollback();
			throw e;
		} 
		catch (Exception e) 
		{
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			conn.rollback();
			throw e;
		}
		finally 
		{
			try 
			{
				dao.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
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
			this.conn = darConexion();
			conn.setAutoCommit(false);
			dao.setConn(conn);
			asistencias = dao.darNoAsistenciaCliente(id);
			conn.commit();
		}
		catch (SQLException e) 
		{
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			conn.rollback();
			throw e;
		} 
		catch (Exception e) 
		{
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			conn.rollback();
			throw e;
		}
		finally 
		{
			try 
			{
				dao.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
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
			this.conn = darConexion();
			conn.setAutoCommit(false);
			dao.setConn(conn);
			daoEnt.setConn(conn);
			dao.cancelarFuncion(id);
			daoEnt.devolverEntradasFuncionCancelada(id);
			conn.commit();
		}
		catch (SQLException e) 
		{
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			conn.rollback();
			throw e;
		} 
		catch (Exception e) 
		{
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			conn.rollback();
			throw e;
		}
		finally 
		{
			try 
			{
				dao.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
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
				if(this.conn!=null)
					this.conn.close();
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
			this.conn = darConexion();
			daoFunciones.setConn(conn);
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
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
		return new ListaFunciones(funciones);
	}

}

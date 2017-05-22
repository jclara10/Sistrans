package rest;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

import dtm.RegistrarAbonamientoJMS;
import tm.FestivAndesTransactionManager;

@Path("admin")
public class AdminServices 
{
	/**
	 * Atributo que usa la anotación @Context para tener el ServletContext de la conexión actual.
	 */
	@Context
	private ServletContext context;

	/**
	 * Método que retorna el path de la carpeta WEB-INF/ConnectionData en el deploy actual dentro del servidor.
	 * @return path de la carpeta WEB-INF/ConnectionData en el deploy actual.
	 */
	private String getPath() {
		return context.getRealPath("WEB-INF/ConnectionData");
	}
	
	/**
	 * Método que retorna el error formateo para responder el Json en caso de Exception
	 * @return String con el Json del error
	 */
	private String doErrorMessage(Exception e){
		return "{ \"ERROR\": \""+ e.getMessage() + "\"}" ;
	}
	
	/**
	 * Método que expone servicio REST usando POST para inicializar los servicios de JMS
	 * <b>URL: </b> http://"ip o nombre de host":8080/VideoAndes/rest/admin/jmsInit
	 */
	@POST
	@Path("/jmsInit")
	public Response initApp() 
	{
		try {
			RegistrarAbonamientoJMS manager = RegistrarAbonamientoJMS.darInstacia(new FestivAndesTransactionManager(getPath()));
			initDataFromFile(manager);
			System.out.println("InitApp1");
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).build();
	}
	
	/**
	 * Método que inicializa los atributos basicos de JMSManager
	 * 
	 */
	public void initDataFromFile(RegistrarAbonamientoJMS manager) {
		try {
			String contextPathP = context.getRealPath("WEB-INF/ConnectionData");
			String connectionDataPath = contextPathP + FestivAndesTransactionManager.CONNECTION_DATA_FILE_NAME_REMOTE;
			
			File arch = new File(connectionDataPath);
			Properties prop = new Properties();
			FileInputStream in = new FileInputStream(arch);
			prop.load(in);
			in.close();
			String myQueue = prop.getProperty("myQueue");
			String topicAllVideos = prop.getProperty("topicAllVideos");
			int numberApps = Integer.parseInt(prop.getProperty("numberApps"));
			
			manager.setUpJMSManager(numberApps, myQueue, topicAllVideos);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

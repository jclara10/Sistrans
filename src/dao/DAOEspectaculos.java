package dao;

import java.sql.Connection;
import java.io.*;
import java.sql.*;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.*;

import vos.*;

public class DAOEspectaculos 
{
	private ArrayList<Object> recursos;

	private Connection conn;

	public DAOEspectaculos() 
	{
		recursos = new ArrayList<Object>();
	}

	public void cerrarRecursos() 
	{
		for(Object ob : recursos)
		{
			if(ob instanceof PreparedStatement)
				try 
			{
					((PreparedStatement) ob).close();
			} 
			catch (Exception ex) 
			{
				ex.printStackTrace();
			}
		}
	}

	public void setConn(Connection con)
	{
		this.conn = con;
	}

	public ArrayList<Espectaculo> darEspectaculos() throws SQLException, Exception 
	{
		ArrayList<Espectaculo>  espectaculos = new ArrayList<Espectaculo>();
		String sql = "SELECT * FROM ISIS2304A031720.ESPECTACULOS";
		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();

		while (rs.next()) 
		{
			String name = rs.getString("NOMBRE");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String fecha = rs.getString("FECHA"); 
			Date date = (Date) sdf.parse(fecha);
			int duration = Integer.parseInt(rs.getString("DURACION"));
			String style = rs.getString("ESTILO");
			int code = Integer.parseInt(rs.getString("CODIGO"));
			Double developerCoast = Double.parseDouble(rs.getString("COSTO_REALIZACION"));
			String language = rs.getString("IDIOMA");
			String booleano = rs.getString("TIENE_TRADUCCION");
			Boolean hasTranslation;
			if(booleano.equals("Si"))
			{
				hasTranslation = true;					
			}
			else
			{
				hasTranslation = false;
			}
			String objectivePublic = rs.getString("PUBLICO_OBJETIVO");
			String description = rs.getString("DESCRIPCION");
			espectaculos.add(new Espectaculo(name, date, duration, style, code, language, developerCoast, hasTranslation, objectivePublic, description));
		}

		return espectaculos;
	}
	
	public void addEspectaculo(Espectaculo espectaculo) throws SQLException, Exception 
	{
		String sql = "INSERT INTO falta VALUES ('";
		sql += espectaculo.getNombre() + "','";
		sql += espectaculo.getFecha() + "',";
		sql += espectaculo.getDuracion() + ",'";
		sql += espectaculo.getEstilo() + "',";
		sql += espectaculo.getCodigo() + ",";
		sql += espectaculo.getCostoRealizacion() + ",'";
		sql += espectaculo.getIdioma() + "','";
		sql += espectaculo.getTieneTraduccion() + "','";
		sql += espectaculo.getPublicoObjetivo() + "','";
		sql += espectaculo.getDescripcion() + "')";

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();

	}
	
	public String generarReporte(int codigoEspectaculo) throws Exception
	{
		DAOFunciones funcion = new DAOFunciones();
		ArrayList funciones = funcion.darFunciones();
		int ganancias = 0;
		int vendidas = 0;
		int disponibles = 0;
		
		for (int i = 0; i < funciones.size(); i++)
		{
			int x = ((Funcion) funciones.get(i)).getCodigo();
			ganancias += funcion.darProducido(x);
			disponibles += ((Funcion) funciones.get(i)).getNumEntradasDisponibles();
			vendidas += ((Funcion) funciones.get(i)).getNumEntradasVendidas();
		}
		
		double total = vendidas/disponibles*100;
		
		return "Numero de boletas vendidas: "+vendidas+" Total producido:"+ganancias+" Porcentaje de ocupacion: "+total;
	}

}

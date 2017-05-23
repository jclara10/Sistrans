package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vos.Funcion;
import vos.ListaRentabilidades;
import vos.RentabilidadCompania;

public class DAORentabilidad 
{
	private ArrayList<Object> recursos;

	private Connection conn;

	public DAORentabilidad()
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
			} catch (Exception ex)
			{
				ex.printStackTrace();
			}
		}
	}

	public void setConn(Connection con)
	{
		this.conn = con;
	}

	public ArrayList<RentabilidadCompania> darRentabilidad(String pnombreCompania) throws SQLException, Exception 
	{
		ArrayList<RentabilidadCompania> rent = new ArrayList<RentabilidadCompania>();
		String sql = "SELECT COUNT (PRECIO) AS NUM_BOLETAS_VENDIDAS FROM " + 
				"(SELECT f.NOMBRE_COMPAÑIA, e.PRECIO FROM ISIS2304A031720.FUNCIONES f INNER JOIN ISIS2304A031720.COMPAÑIAS_DE_TEATRO c ON f.NOMBRE_COMPAÑIA =c.NOMBRE "+ 
				"INNER JOIN ISIS2304A031720.ENTRADAS e ON f.CODIGO=e.COD_FUNCION)";

		String sql2 = "SELECT SUM (PRECIO) AS TOTAL_FACTURADO FROM " + 
				"(SELECT f.NOMBRE_COMPAÑIA, e.PRECIO FROM ISIS2304A031720.FUNCIONES f INNER JOIN ISIS2304A031720.COMPAÑIAS_DE_TEATRO c ON f.NOMBRE_COMPAÑIA =c.NOMBRE "+ 
				"INNER JOIN ISIS2304A031720.ENTRADAS e ON f.CODIGO=e.COD_FUNCION)";

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();
		
		PreparedStatement prepStmt2 = conn.prepareStatement(sql2);
		recursos.add(prepStmt2);
		ResultSet rs2 = prepStmt2.executeQuery();

		if (rs.next() && rs2.next()) 
		{
			String nombreCompania = pnombreCompania;
			int numBoletasVendidas = rs.getInt("NUM_BOLETAS_VENDIDAS");
			int totalFacturado = rs2.getInt("TOTAL_FACTURADO");			

			rent.add(new RentabilidadCompania(nombreCompania, numBoletasVendidas, totalFacturado));
		}
		return rent;
	}

}

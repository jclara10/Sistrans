package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vos.CompaniaDeTeatro;
import vos.Funcion;

public class DAOCompaniasDeTeatro 
{

	private ArrayList<Object> recursos;

	private Connection conn;

	public DAOCompaniasDeTeatro() 
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

	public void addCompaniaDeTeatro(CompaniaDeTeatro compania) throws SQLException, Exception 
	{
		String sql = "INSERT INTO ISIS2304A031720.COMPAÑIAS_DE_TEATRO VALUES ('";
		sql += compania.getNombre() + "','";
		sql += compania.getRepresentante() + "',";
		sql += compania.getIdRepresentante() + ",'";
		sql += compania.getPaisOrigen() + "','";
		sql += compania.getPaginaWeb() + "','";
		sql += compania.getFechaLlegada() + "','";
		sql += compania.getFechaPartida() + "','";
		sql += compania.getEmail() + "','";
		sql += compania.getPassword() + "')";

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();

	}

	public ArrayList<CompaniaDeTeatro> darCompaniaRetiradas(String nombreCompania) throws SQLException 
	{
		ArrayList<CompaniaDeTeatro> companias = new ArrayList<CompaniaDeTeatro>();	
		
		String sql = "SELECT * FROM ISIS2304A031720.COMPAÑIAS_DE_TEATRO WHERE NOMBRE ="+nombreCompania;

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();
		
		while (rs.next()) 
		{
			String nombre = rs.getString("NOMBRE");
			String representante = rs.getString("NOMBRE_REPRESENTANTE");
			int idRepresentante = rs.getInt("ID_REPRESENTANTE");
			String paisOrigen = rs.getString("PAIS_ORIGEN");
			String paginaWeb = rs.getString("PAIS_ORIGEN");
			Date fechaLlegada = rs.getDate("FECHA_LLEGADA");
			Date fechaPartida = rs.getDate("FECHA_PARTIDA");
			String email = rs.getString("EMAIL");
			String password = rs.getString("PASSWORD");
			int codigoEspectaculo = rs.getInt("CODIGO_ESPECTACULO");

			companias.add(new CompaniaDeTeatro(nombre, representante, idRepresentante, paisOrigen, paginaWeb, fechaLlegada, fechaPartida, email, password, codigoEspectaculo));
		}
		return companias;
	}


}

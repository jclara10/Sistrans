package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import vos.CompaniaDeTeatro;

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


}

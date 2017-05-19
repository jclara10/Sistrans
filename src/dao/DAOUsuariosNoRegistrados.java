package dao;

import java.io.*;
import java.sql.*;
import java.util.*;

import vos.*;

public class DAOUsuariosNoRegistrados 
{
	private ArrayList<Object> recursos;

	private Connection conn;

	public DAOUsuariosNoRegistrados() 
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

	public ArrayList<UsuarioNoRegistrado> darUsuariosNoRegistrados() throws Exception 
	{
		ArrayList<UsuarioNoRegistrado> usuariosNoRegistrados = new ArrayList<UsuarioNoRegistrado>();
		String sql = "SELECT * FROM ISIS2304A031720.USUARIOS_NO_REGISTRADOS";
		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();

		while (rs.next()) 
		{
			String name = rs.getString("NOMBRE");
			int id = Integer.parseInt(rs.getString("ID"));
			String email = rs.getString("EMAIL");
			String rol = rs.getString("ROL");
			int codEntrada = Integer.parseInt(rs.getString("COD_ENTRADA"));
			usuariosNoRegistrados.add(new UsuarioNoRegistrado(name, id, email, rol, codEntrada));
		}
		return usuariosNoRegistrados;
	}

}

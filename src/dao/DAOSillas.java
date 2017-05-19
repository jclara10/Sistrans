package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import vos.Silla;

public class DAOSillas 
{
	private ArrayList<Object> recursos;

	private Connection conn;
	
	public DAOSillas() 
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
	
	public ArrayList<Silla> darSillas() throws SQLException, Exception 
	{
		ArrayList<Silla> sillas = new ArrayList<Silla>();
		String sql = "SELECT * FROM ISIS2304A031720.SILLAS";
		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();

		while (rs.next()) 
		{
			int codEscenario = Integer.parseInt(rs.getString("CODIGO_ESCENARIO"));
			String locaclidad = rs.getString("LOCALIDAD");
			int numFila = Integer.parseInt(rs.getString("NUM_FILA"));
			int numColumna = Integer.parseInt(rs.getString("NUM_COLUMNA"));
			String tipo = rs.getString("TIPO");
			int codEntrada = Integer.parseInt(rs.getString("CODIGO_ENTRADA"));
			sillas.add(new Silla(codEscenario, locaclidad, numFila, numColumna, tipo, codEntrada));
		}

		return sillas;
	}

}

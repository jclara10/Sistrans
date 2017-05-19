package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import vos.Cliente;

public class DAOClientes 
{
	private ArrayList<Object> recursos;

	private Connection conn;

	public DAOClientes() 
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
	
	public void addCliente(Cliente cliente) throws SQLException, Exception 
	{
		String sql = "INSERT INTO ISIS2304A031720.CLIENTES VALUES ('";
		sql += cliente.getNombre() + "',";
		sql += cliente.getId() + ",'";
		sql += cliente.getEmail() + "','";
		sql += cliente.getRol() + "','";
		sql += cliente.getPreferencia() + "','";
		sql += cliente.getPassword() + "','";
		sql += cliente.getEsAbonado() + "')";             

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();

	}

	public void updateCliente(Cliente cliente) throws SQLException, Exception
	{
		String sql = "UPDATE ISIS2304A031720.CLIENTES SET ";
		sql += "PREFERENCIA='" + cliente.getPreferencia() + "',";
		sql += " WHERE ID = " + cliente.getId();

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();

	}

	public void abonar(int idCliente) throws SQLException, Exception
	{
		String sql = "UPDATE ISIS2304A031720.CLIENTES SET ";
		sql += "ES_ABONADO ='sí'";
		sql += " WHERE ID = " + idCliente;
		
		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		System.out.println("ListoPollo");
		prepStmt.executeQuery();
	}

}


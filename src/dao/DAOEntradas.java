package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vos.Abono;
import vos.Entrada;
import vos.Funcion;

public class DAOEntradas 
{
	private ArrayList<Object> recursos;

	private Connection conn;

	public DAOEntradas() 
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
	
	public void addEntrada(Entrada entrada) throws SQLException, Exception 
	{
		String sql = "INSERT INTO ISIS2304A031720.ENTRADAS VALUES (";
		sql += entrada.getCodigo() + ",";
		sql += entrada.getNumColumna() + ",";
		sql += entrada.getNumFila() + ","; 
		sql += entrada.getPrecio() + ",";
		sql += entrada.getIdPersona() + ","; 
		sql += entrada.getIdCliente()  + ",";
		sql += entrada.getCodigoFuncion() + ")";      

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();

	}
	
	public void devolverEntrada(int id) throws SQLException 
	{
		String sql = "DELETE FROM ENTRADAS WHERE codigo ="+id;
		
		System.out.println("SQL stmt:" + sql);
		
		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}
	
	public void devolverAbono(int idCliente, int idAbono) throws SQLException 
	{
		String sql = "SELECT idBoleta FROM ABONO WHERE id="+idAbono +"AND idCliente ="+idCliente;
		
		System.out.println("SQL stmt:" + sql);
		
		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();
		
		while(rs.next())
		{
			int idBoleta = rs.getInt("idBoleta");
			devolverEntrada(idBoleta);
		}
	}

	public void registrarAbono(Abono abono) throws SQLException 
	{
		String sql = "INSERT INTO ISIS2304A031720.ABONO VALUES (";
		sql += abono.getId() + ",";
		sql += abono.getIdEntrada() + ",";
		sql += abono.getIdCliente() + ")";
		
		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}

	public void devolverEntradasFuncionCancelada(int id) throws SQLException  
	{
		String sql = "SELECT CODIGO FROM ENTRADAS WHERE COD_FUNCION = " + id;
		System.out.println("SQL stmt:" + sql);
		System.out.println(conn);
		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();
		
		while(rs.next())
		{
			devolverEntrada(rs.getInt("CODIGO"));
		}
	}

}

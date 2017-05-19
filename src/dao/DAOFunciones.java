package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vos.Funcion;


public class DAOFunciones
{
	private ArrayList<Object> recursos;

	private Connection conn;

	public DAOFunciones()
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


	public void addFuncion(Funcion funcion) throws SQLException, Exception 
	{

		String sql = "INSERT INTO ISIS2304A031720.FUNCIONES VALUES (";
		sql += funcion.getCodigo() + ",'";
		sql += funcion.getFecha() + "','";
		sql += funcion.getHora() + "','";
		sql += funcion.isYaRealizada() + "',";
		sql += funcion.getNumEntradasDisponibles() + ",";
		sql += funcion.getNumEntradasVendidas() + ",";
		sql += funcion.getCodigoEspectaculo() + ",";
		sql += funcion.getCodigoEscenario() + ")";

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}

	public ArrayList<Funcion> darFunciones() throws Exception 
	{
		ArrayList<Funcion> funciones = new ArrayList<Funcion>();
		String sql = "SELECT * FROM ISIS2304A031720.FUNCIONES";
		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();

		while (rs.next()) 
		{
			int codigo = Integer.parseInt(rs.getNString("CODIGO"));
			Date fecha = rs.getDate("FECHA");
			Date hora = rs.getDate("HORA");
			boolean yaRealizada = rs.getBoolean("YA_FUE_REALIZADA");
			int numEntradasDisponibles = rs.getInt("NUM_ENTRADAS_DISPONIBLES");
			int numEntradasVendidas = rs.getInt("NUM_ENTRADAS_VENDIDAS");
			int codigoEspectaculo = rs.getInt("CODIGO_ESPECTACULO");
			int codigoEscenario = rs.getInt("CODIGO_ESCENARIO");

			funciones.add(new Funcion(codigo, fecha, hora, yaRealizada, numEntradasDisponibles, numEntradasVendidas, codigoEspectaculo, codigoEscenario));
		}
		return funciones;
	}

	public void updateFuncion(int codFuncion) throws Exception 
	{
		String sql = "UPDATE ISIS2304A031720.FUNCIONES SET ";
		sql += "NUM_ENTRADAS_DISPONIBLES = " + (darNumEntradasDisponiblesDeFuncion(codFuncion)-1)+",";
		sql += "NUM_ENTRADAS_VENDIDAS = "+ (darNumEntradasVendidasDeFuncion(codFuncion)+1);
		sql += "WHERE codigo="+codFuncion;

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}

	private int darNumEntradasVendidasDeFuncion(int codFuncion) throws Exception  
	{
		int num = -1;
		String sql = "SELECT NUM_ENTRADAS_VENDIDAS FROM ISIS2304A031720.FUNCIONES WHERE CODIGO = " + codFuncion;
		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();
		while (rs.next()) 
		{
			num = rs.getInt("NUM_ENTRADAS_VENDIDAS");
		}
		return num;
	}

	private int darNumEntradasDisponiblesDeFuncion(int codFuncion) throws Exception 
	{
		int num = -1;
		String sql = "SELECT NUM_ENTRADAS_DISPONIBLES FROM ISIS2304A031720.FUNCIONES WHERE CODIGO = " + codFuncion;
		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();
		while (rs.next()) 
		{
			num = rs.getInt("NUM_ENTRADAS_DISPONIBLES");
		}

		return num;
	}

	public void updateFuncion(Funcion funcion) throws Exception  
	{
		String sql = "UPDATE ISIS2304A031720.FUNCIONES SET ";
		sql += "ya_Fue_Realizada = "+"TRUE";
		sql += "WHERE codigo="+funcion.getCodigo();

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}

	public String generarReporte(int funcion) throws Exception
	{
		String sql = "SELECT Precio FROM ENTRADAS WHERE codigofuncion ="+funcion;
		int num = 0;

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();
		while (rs.next()) 
		{
			num = num + rs.getInt("PRECIO");
		}

		num = num*darNumEntradasVendidasDeFuncion(funcion);
		int num2 = darNumEntradasVendidasDeFuncion(funcion);

		return "Numero de boletas vendidas"+num2+" Total producido:"+num;
	}

	public String generarReportePorCliente(int funcion) throws Exception
	{
		String sql = "SELECT Precio FROM ENTRADAS WHERE codigofuncion ="+funcion+" AND idCliente NOT = NULL";
		int num = 0;

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();
		while (rs.next()) 
		{
			num = num + rs.getInt("PRECIO");
		}

		num = num*darNumEntradasVendidasDeFuncion(funcion);
		int num2 = darNumEntradasVendidasDeFuncion(funcion);

		return "Numero de boletas vendidas"+num2+" Total producido:"+num;
	}

	public String generarReportePorUsuario(int funcion) throws Exception
	{
		String sql = "SELECT Precio FROM ENTRADAS WHERE codigofuncion ="+funcion+" AND idPersona NOT = NULL";
		int num = 0;

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();
		while (rs.next()) 
		{
			num = num + rs.getInt("PRECIO");
		}

		num = num*darNumEntradasVendidasDeFuncion(funcion);
		int num2 = darNumEntradasVendidasDeFuncion(funcion);

		return "Numero de boletas vendidas: "+num2+" Total producido: "+num;
	}

	public int darProducido(int funcion) throws Exception
	{
		String sql = "SELECT Precio FROM ENTRADAS WHERE codigofuncion ="+funcion+" AND idPersona NOT = NULL";
		int num = 0;

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();
		while (rs.next()) 
		{
			num = num + rs.getInt("PRECIO");
		}

		num = num*darNumEntradasVendidasDeFuncion(funcion);

		return num;
	}

	public int darAsistenciaCliente(int id) throws Exception 
	{
		String sql = "SELECT COUNT(COD_FUNCION) FROM (FUNCIONES c INNER JOIN ENTRADAS b ON c.CODIGO = b.COD_FUNCION) WHERE YA_FUE_REALIZADA = 'Si'  AND ID_CLIENTE = ";
		sql += id + " GROUP BY ID_CLIENTE";

		int cantidad = -1;

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();

		if(rs.next())
		{
			cantidad = rs.getInt("COUNT(COD_FUNCION)");
		}

		return cantidad;
	}
	public int darNoAsistenciaCliente(int id) throws Exception 
	{
		String sql = "SELECT COUNT(COD_FUNCION) FROM (FUNCIONES c INNER JOIN ENTRADAS b ON c.CODIGO = b.COD_FUNCION) WHERE AND ID_CLIENTE NOT = ";
		sql += id + " GROUP BY ID_CLIENTE";

		int cantidad = -1;

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();

		if(rs.next())
		{
			cantidad = rs.getInt("COUNT(COD_FUNCION)");
		}

		return cantidad;
	}

	public void cancelarFuncion(int id) throws Exception  
	{
		String sql = "DELETE FROM ISIS2304A031720.FUNCIONES WHERE CODIGO = " + id;
		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}
}

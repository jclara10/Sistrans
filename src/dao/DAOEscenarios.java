package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import vos.Escenario;
import vos.Espectaculo;

public class DAOEscenarios 
{
	private ArrayList<Object> recursos;

	private Connection conn;

	public DAOEscenarios() 
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
	
	public ArrayList<Escenario> darEscenarios() throws SQLException, Exception 
	{
		ArrayList<Escenario>  escenarios = new ArrayList<Escenario>();
		String sql = "SELECT * FROM ISIS2304A031720.ESCENARIOS";
		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();

		while (rs.next()) 
		{
			String name = rs.getString("NOMBRE");
			int code = Integer.parseInt(rs.getString("CODIGO"));
			String direccion = rs.getString("DIRECCION");
			int capacidad = Integer.parseInt(rs.getString("CAPACIDAD"));
			String tipo = rs.getString("TIPO");
			String booleano = rs.getString("ES_APTO_PERSONAS_ESPECIALES");
			boolean esAptoPersonasEspeciales;
			if(booleano.equals("Si"))
			{
				esAptoPersonasEspeciales = true;					
			}
			else
			{
				esAptoPersonasEspeciales = false;
			}
			SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
			String horaA = rs.getString("HORA_APERTURA"); 
			Date horaApertura = (Date) sdf.parse(horaA);
			SimpleDateFormat sdf2 = new SimpleDateFormat("hh:mm:ss");
			String horaC = rs.getString("HORA_CIERRE"); 
			Date horaCierre = (Date) sdf.parse(horaC);
			String condicionesTecnicas = rs.getString("CONDICIONES_TECNICAS");
			String tipoCombateClima = rs.getString("TIPO_COMBATE_CLIMA");
			escenarios.add(new Escenario(name, code, direccion, capacidad, tipo, esAptoPersonasEspeciales, horaApertura, horaCierre, condicionesTecnicas, tipoCombateClima));
		}

		return escenarios;
	}
	
	public void addEscenario(Escenario escenario) throws SQLException, Exception 
	{
		String sql = "INSERT INTO ISIS2304A031720.ESCENARIOS VALUES ('";
		sql += escenario.getNombre() + "','";
		sql += escenario.getDireccion() + "',";
		sql += escenario.getCodigo() + ",";
		sql += escenario.getCapacidad() + ",'";
		sql += escenario.getTipo() + "','";
		sql += escenario.getCondicionesTecnicas() + "','";
		sql += escenario.getHoraApertura() + "','";
		sql += escenario.getHoraCierre() + "','";
		sql += escenario.getTipoCombateClima() + "')";  

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();

	}

}

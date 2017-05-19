package vos;

import java.sql.Date;

import org.codehaus.jackson.annotate.JsonProperty;

public class Funcion
{
	@JsonProperty(value="fecha")
	private Date fecha;
	
	@JsonProperty(value="hora")
	private Date hora;
	
	@JsonProperty(value="yaRealizada")
	private boolean yaRealizada;
	
	@JsonProperty(value="numEntradasDisponibles")
	private int numEntradasDisponibles;
	
	@JsonProperty(value="numEntradasVendidas")
	private int numEntradasVendidas;
	
	@JsonProperty(value="codigo")
	private int codigo;
	
	@JsonProperty(value="codigoEspectaculo")
	private int codigoEspectaculo;
	
	@JsonProperty(value="codigoEscenario")
	private int codigoEscenario;

	public Funcion(@JsonProperty(value="codigo")int codigo, @JsonProperty(value="fecha")Date fecha, @JsonProperty(value="hora")Date hora, @JsonProperty(value="yaRealizada")boolean yaRealizada, @JsonProperty(value="numEntradasDisponibles")int numEntradasDisponibles, @JsonProperty(value="numEntradasVendidas")int numEntradasVendidas,
			@JsonProperty(value="codigoEspectaculo")int codigoEspectaculo, @JsonProperty(value="codigoEscenario")int codigoEscenario)
	{
		super();
		this.fecha = fecha;
		this.hora = hora;
		this.yaRealizada = yaRealizada;
		this.numEntradasDisponibles = numEntradasDisponibles;
		this.numEntradasVendidas = numEntradasVendidas;
		this.codigo = codigo;
		this.codigoEspectaculo = codigoEspectaculo;
		this.codigoEscenario = codigoEscenario;
	}

	public Date getFecha()
	{
		return fecha;
	}

	public void setFecha(Date fecha)
	{
		this.fecha = fecha;
	}

	public Date getHora()
	{
		return hora;
	}

	public void setHora(Date hora)
	{
		this.hora = hora;
	}

	public boolean isYaRealizada()
	{
		return yaRealizada;
	}

	public void setYaRealizada(boolean yaRealizada)
	{
		this.yaRealizada = yaRealizada;
	}

	public int getNumEntradasDisponibles()
	{
		return numEntradasDisponibles;
	}

	public void setNumEntradasDisponibles(int numEntradasDisponibles)
	{
		this.numEntradasDisponibles = numEntradasDisponibles;
	}

	public int getNumEntradasVendidas()
	{
		return numEntradasVendidas;
	}

	public void setNumEntradasVendidas(int numEntradasVendidas)
	{
		this.numEntradasVendidas = numEntradasVendidas;
	}

	public int getCodigo()
	{
		return codigo;
	}

	public void setCodigo(int codigo)
	{
		this.codigo = codigo;
	}

	public int getCodigoEspectaculo()
	{
		return codigoEspectaculo;
	}

	public void setCodigoEspectaculo(int codigoEspectaculo)
	{
		this.codigoEspectaculo = codigoEspectaculo;
	}

	public int getCodigoEscenario()
	{
		return codigoEscenario;
	}

	public void setCodigoEscenario(int codigoEscenario)
	{
		this.codigoEscenario = codigoEscenario;
	}
	
	
}

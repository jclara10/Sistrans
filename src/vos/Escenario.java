package vos;

import java.sql.Date;

import org.codehaus.jackson.annotate.JsonProperty;

public class Escenario 
{
	
	@JsonProperty(value="nombre")
	private String nombre;
	
	@JsonProperty(value="codigo")
	private int codigo;
	
	@JsonProperty(value="direccion")
	private String direccion;
	
	@JsonProperty(value="capacidad")
	private int capacidad;
	
	@JsonProperty(value="tipo")
	private String tipo;
	
	@JsonProperty(value="esAptoPersonasEspeciales")
	private boolean esAptoPersonasEspeciales;
	
	@JsonProperty(value="horaApertura")
	private Date horaApertura;
	
	@JsonProperty(value="horaCierre")
	private Date horaCierre;
	
	@JsonProperty(value="condicionesTecnicas")
	private String condicionesTecnicas;
	
	@JsonProperty(value="tipoCombateClima")
	private String tipoCombateClima;

	public Escenario(@JsonProperty(value="nombre")String pNombre, @JsonProperty(value="codigo")int pCodigo, @JsonProperty(value="direccion")String pDireccion, @JsonProperty(value="capacidad")int pCapacidad, @JsonProperty(value="capacidad")String pTipo, @JsonProperty(value="esAptoPersonasEspeciales")boolean pEsAptoPersonasEspeciales, @JsonProperty(value="horaApertura")Date pHoraApertura, @JsonProperty(value="horaCierre")Date pHoraCierre, @JsonProperty(value="condicionesTecnicas")String pCondicionesTecnicas, @JsonProperty(value="tipoCombateClima")String pTipoCombateclima) 
	{
		this.nombre = pNombre;
		this.codigo = pCodigo;
		this.direccion = pDireccion;
		this.capacidad = pCapacidad;
		this.tipo = pTipo;
		this.esAptoPersonasEspeciales = pEsAptoPersonasEspeciales;
		this.horaApertura = pHoraApertura;
		this.horaCierre = pHoraCierre;
		this.condicionesTecnicas = pCondicionesTecnicas;
		this.tipoCombateClima = pTipoCombateclima;
	}

	public String getNombre() 
	{
		return this.nombre;
	}

	public void setNombre(String pNombre) 
	{
		this.nombre = pNombre;
	}

	public int getCodigo() 
	{
		return this.codigo;
	}

	public void setCodigo(int pCodigo) 
	{
		this.codigo = pCodigo;
	}

	public String getDireccion() 
	{
		return this.direccion;
	}

	public void setDireccion(String pDireccion) 
	{
		this.direccion = pDireccion;
	}

	public int getCapacidad() 
	{
		return this.capacidad;
	}

	public void setCapacidad(int pCapacidad) 
	{
		this.capacidad = pCapacidad;
	}

	public String getTipo() 
	{
		return this.tipo;
	}

	public void setTipo(String pTipo) 
	{
		this.tipo = pTipo;
	}

	public boolean esAptoPersonasEspeciales() 
	{
		return this.esAptoPersonasEspeciales;
	}

	public void setEsAptoPersonasEspeciales(boolean pEsAptoPersonasEspeciales) 
	{
		this.esAptoPersonasEspeciales = pEsAptoPersonasEspeciales;
	}

	public Date getHoraApertura() 
	{
		return this.horaApertura;
	}

	public void setHoraApertura(Date pHoraApertura) 
	{
		this.horaApertura = pHoraApertura;
	}

	public Date getHoraCierre() 
	{
		return this.horaCierre;
	}

	public void setHoraCierre(Date pHoraCierre) 
	{
		this.horaCierre =pHoraCierre;
	}

	public String getCondicionesTecnicas() 
	{
		return this.condicionesTecnicas;
	}

	public void setCondicionesTecnicas(String pCondicionesTecnicas) 
	{
		this.condicionesTecnicas = pCondicionesTecnicas;
	}

	public String getTipoCombateClima() 
	{
		return this.tipoCombateClima;
	}

	public void setTipoCombateClima(String pTipoCombateClima) 
	{
		this.tipoCombateClima = pTipoCombateClima;
	}
	
	

}

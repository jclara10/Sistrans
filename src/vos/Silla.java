package vos;

import org.codehaus.jackson.annotate.JsonProperty;

public class Silla 
{
	@JsonProperty(value="localidad")
	private String localidad;
	
	@JsonProperty(value="codigoEscenario")
	private int codigoEscenario;
	
	@JsonProperty(value="codigoEntrada")
	private int codigoEntrada;
	
	@JsonProperty(value="numFila")
	private int numFila;

	@JsonProperty(value="numColumna")
	private int numColumna;
	
	@JsonProperty(value="tipo")
	private String tipo;
	
	public Silla(@JsonProperty(value="codigoEntrada")int codEscenario, @JsonProperty(value="localidad")String pLocalidad, @JsonProperty(value="numFila")int pNumFila, @JsonProperty(value="numColumna")int pNumColumna, @JsonProperty(value="tipo")String pTipo, @JsonProperty(value="codigoEntrada")int codEntrada)
	{
		this.codigoEscenario = codEscenario;
		this.localidad = pLocalidad;
		this.numFila = pNumFila;
		this.numColumna = pNumColumna;
		this.tipo = pTipo;
		this.codigoEntrada = codEntrada;
	}

	public int getCodigoEscenario() {
		return codigoEscenario;
	}

	public void setCodigoEscenario(int codigoEscenario) {
		this.codigoEscenario = codigoEscenario;
	}

	public int getCodigoEntrada() {
		return codigoEntrada;
	}

	public void setCodigoEntrada(int codigoEntrada) {
		this.codigoEntrada = codigoEntrada;
	}

	public String getLocalidad() 
	{
		return this.localidad;
	}

	public void setLocalidad(String pLocalidad) 
	{
		this.localidad = pLocalidad;
	}

	public int getNumFila() 
	{
		return this.numFila;
	}

	public void setNumFila(int pNumFila) 
	{
		this.numFila = pNumFila;
	}

	public int getNumColumna() 
	{
		return this.numColumna;
	}

	public void setNumColumna(int pNumColumna) 
	{
		this.numColumna = pNumColumna;
	}

	public String getTipo() 
	{
		return this.tipo;
	}

	public void setTipo(String pTipo) 
	{
		this.tipo = pTipo;
	}
	
	
}

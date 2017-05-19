package vos;

import org.codehaus.jackson.annotate.JsonProperty;

public class Entrada
{
	@JsonProperty(value="codigo")
	private int codigo;
	
	@JsonProperty(value="numColumna")
	private int numColumna;
	
	@JsonProperty(value="precio")
	private double precio;
	
	@JsonProperty(value="idPersona")
	private int idPersona;
	
	@JsonProperty(value="numFila")
	private int numFila;

	@JsonProperty(value="codigoFuncion")
	private int codigoFuncion;
	
	@JsonProperty(value="idCliente")
	private int idCliente;

	
	public Entrada(@JsonProperty(value="codigo")int codigo, @JsonProperty(value="numColumna")int numColumna, @JsonProperty(value="precio")double precio, @JsonProperty(value="idPersona")int idPersona, @JsonProperty(value="numFila")int numFila, @JsonProperty(value="codigoFuncion")int codigoFuncion,
			@JsonProperty(value="idCliente")int idCliente)
	{
		super();
		this.codigo = codigo;
		this.numColumna = numColumna;
		this.precio = precio;
		this.idPersona = idPersona;
		this.numFila = numFila;
		this.codigoFuncion = codigoFuncion;
		this.idCliente = idCliente;
	}

	public int getCodigo()
	{
		return codigo;
	}

	public void setCodigo(int codigo)
	{
		this.codigo = codigo;
	}

	public int getNumColumna()
	{
		return numColumna;
	}

	public void setNumColumna(int numColumna)
	{
		this.numColumna = numColumna;
	}

	public double getPrecio()
	{
		return precio;
	}

	public void setPrecio(double precio)
	{
		this.precio = precio;
	}

	public int getIdPersona()
	{
		return idPersona;
	}

	public void setIdPersona(int idPersona)
	{
		this.idPersona = idPersona;
	}

	public int getNumFila()
	{
		return numFila;
	}

	public void setNumFila(int numFila)
	{
		this.numFila = numFila;
	}

	public int getCodigoFuncion()
	{
		return codigoFuncion;
	}

	public void setCodigoFuncion(int codigoFuncion)
	{
		this.codigoFuncion = codigoFuncion;
	}

	public int getIdCliente()
	{
		return idCliente;
	}

	public void setIdCliente(int idCliente)
	{
		this.idCliente = idCliente;
	}
	
	
}

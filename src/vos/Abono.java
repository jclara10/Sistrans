package vos;

import org.codehaus.jackson.annotate.JsonProperty;

public class Abono 
{
	@JsonProperty(value="idCliente")
	private int idCliente;
	
	@JsonProperty(value="id")
	private int id;

	@JsonProperty(value="idEntrada")
	private int idEntrada;

	public Abono(@JsonProperty(value="idCliente")int pIdCliente, @JsonProperty(value="id")int pId, @JsonProperty(value="idEntrada")int pIdEntrada)
	{
		this.id = pId;
		this.idCliente = pIdCliente;
		this.idEntrada = pIdEntrada;
	}
	
	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdEntrada() {
		return idEntrada;
	}

	public void setIdEntrada(int idEntrada) {
		this.idEntrada = idEntrada;
	}
}

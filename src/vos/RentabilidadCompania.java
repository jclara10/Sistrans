package vos;

import org.codehaus.jackson.annotate.JsonProperty;

import sun.net.www.content.image.png;

public class RentabilidadCompania 
{
	@JsonProperty(value="nombreCompania")
	private String nombreCompania;

	@JsonProperty(value="numBoletasVendidas")
	private int numBoletasVendidas;
	
	@JsonProperty(value="totalFacturado")
	private int totalFacturado;
	
	public RentabilidadCompania()
	{
		this.nombreCompania = null;
		this.numBoletasVendidas = 0;
		this.totalFacturado = 0;
	}
	
	public RentabilidadCompania(@JsonProperty(value="nombreCompania")String pNombreCompania, @JsonProperty(value="numBoletasVendidas")int pNumBoletasVendidas, @JsonProperty(value="totalFacturado")int pTotalFacturado) 
	{
		this.nombreCompania = pNombreCompania;
		this.numBoletasVendidas = pNumBoletasVendidas;
		this.totalFacturado = pTotalFacturado;
	}

	public String getNombreCompania() {
		return nombreCompania;
	}

	public void setNombreCompania(String nombreCompania) {
		this.nombreCompania = nombreCompania;
	}

	public int getNumBoletasVendidas() {
		return numBoletasVendidas;
	}

	public void setNumBoletasVendidas(int numBoletasVendidas) {
		this.numBoletasVendidas = numBoletasVendidas;
	}

	public int getTotalFacturado() {
		return totalFacturado;
	}

	public void setTotalFacturado(int totalFacturado) {
		this.totalFacturado = totalFacturado;
	}
}

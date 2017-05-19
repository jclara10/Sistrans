package vos;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ListaEntradas 
{

	@JsonProperty(value="entradas")
	private List<Entrada> entradas;
	
	public ListaEntradas(@JsonProperty(value="entradas")List<Entrada> pEntradas)
	{
		this.entradas = pEntradas;
	}
	
	public List<Entrada> getEntradas()
	{
		return this.entradas;
	}
	
	public void setEntradas(List<Entrada> newEntradas)
	{
		this.entradas = newEntradas;
	}
}

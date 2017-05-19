package vos;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ListaEspectaculos 
{
	@JsonProperty(value="espectaculos")
	private List<Espectaculo> espectaculos;
	
	public ListaEspectaculos(@JsonProperty(value="espectaculos")List<Espectaculo> pEspectaculos)
	{
		this.espectaculos = pEspectaculos;
	}
	
	public List<Espectaculo> getEspectaculos()
	{
		return this.espectaculos;
	}
	
	public void setEspectaculos(List<Espectaculo> newEspectaculos)
	{
		this.espectaculos = newEspectaculos;
	}
}

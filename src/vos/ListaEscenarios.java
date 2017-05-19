package vos;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ListaEscenarios 
{
	@JsonProperty(value="escenarios")
	private List<Escenario> escenarios;
	
	public ListaEscenarios(@JsonProperty(value="escenarios")List<Escenario> pEscenarios)
	{
		this.escenarios = pEscenarios;
	}
	
	public List<Escenario> getEscenarios()
	{
		return this.escenarios;
	}
	
	public void setEscenarios(List<Escenario> newEscenarios)
	{
		this.escenarios = newEscenarios;
	}
}

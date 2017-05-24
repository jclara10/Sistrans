package vos;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ListaCompaniasRetiradas 
{

	@JsonProperty(value="companias")
	private List<CompaniaDeTeatro> companias;

	public ListaCompaniasRetiradas(@JsonProperty(value="companias")List<CompaniaDeTeatro> companias) 
	{
		super();
		this.companias = companias;
	}

	public ListaCompaniasRetiradas() 
	{
		companias = new ArrayList<CompaniaDeTeatro>();
	}

	public List<CompaniaDeTeatro> getCompanias() {
		return companias;
	}

	public void setCompanias(List<CompaniaDeTeatro> companias) {
		this.companias = companias;
	}	

	public void addCompanias(ListaCompaniasRetiradas companiasNew){
		this.companias.addAll(companiasNew.getCompanias());
	}
}

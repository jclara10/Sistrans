package vos;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ListaRentabilidades 
{
	@JsonProperty(value="rentabilidades")
	private List<RentabilidadCompania> rentabilidades;

	public ListaRentabilidades(@JsonProperty(value="rentabilidades")List<RentabilidadCompania> rentabilidades) 
	{
		super();
		this.rentabilidades = rentabilidades;
	}

	public ListaRentabilidades() 
	{
		rentabilidades = new ArrayList<RentabilidadCompania>();
	}

	public List<RentabilidadCompania> getRentabilidades() 
	{
		return rentabilidades;
	}

	public void setRentabilidades(List<RentabilidadCompania> rentabilidades) {
		this.rentabilidades = rentabilidades;
	}	

	public void addRentabilidades(ListaRentabilidades rentabilidadesNew){
		this.rentabilidades.addAll(rentabilidadesNew.getRentabilidades());
	}
}

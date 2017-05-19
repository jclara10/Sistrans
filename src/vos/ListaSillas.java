package vos;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ListaSillas 
{
	@JsonProperty(value="sillas")
	private List<Silla> sillas;
	
	public ListaSillas(@JsonProperty(value="sillas")List<Silla> pSillas)
	{
		this.sillas = pSillas;
	}
	
	public List<Silla> getSillas()
	{
		return this.sillas;
	}
	
	public void setSillas(List<Silla> newSillas)
	{
		this.sillas = newSillas;
	}

}

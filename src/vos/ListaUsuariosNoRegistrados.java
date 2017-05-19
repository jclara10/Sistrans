package vos;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ListaUsuariosNoRegistrados 
{

	@JsonProperty(value="usuariosNoRegistrados")
	private List<UsuarioNoRegistrado> usuariosNoRegistrados;
	
	public ListaUsuariosNoRegistrados(@JsonProperty(value="usuariosNoRegistrados")List<UsuarioNoRegistrado> pUsuariosNoRegistrados)
	{
		this.usuariosNoRegistrados = pUsuariosNoRegistrados;
	}
	
	public List<UsuarioNoRegistrado> getUsuariosNoRegistrados()
	{
		return this.usuariosNoRegistrados;
	}
	
	public void setUsuariosNoRegistrados(List<UsuarioNoRegistrado> newUsuariosNoRegistrados)
	{
		this.usuariosNoRegistrados = newUsuariosNoRegistrados;
	}
	
}
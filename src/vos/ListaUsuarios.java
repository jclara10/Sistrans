package vos;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ListaUsuarios 
{
	@JsonProperty(value="usuarios")
	private List<Cliente> usuarios;

	public ListaUsuarios(@JsonProperty(value="usuarios")List<Cliente> usuarios){
		this.usuarios = usuarios;
	}

	public ListaUsuarios() {
		usuarios = new ArrayList<Cliente>();
	}

	public List<Cliente> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Cliente> usuarios) {
		this.usuarios = usuarios;
	}

	public void addUsuario(ListaUsuarios usuariosNew)
	{
		this.usuarios.addAll(usuariosNew.getUsuarios());
	}
}

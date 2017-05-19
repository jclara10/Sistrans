package vos;

import org.codehaus.jackson.annotate.*;

public class Administrador
{
	@JsonProperty(value="nombre")
	private String nombre;
	
	@JsonProperty(value="id")
	private int id;
	
	@JsonProperty(value="password")
	private String password;
	
	@JsonProperty(value="usuario")
	private String usuario;
	
	public Administrador(@JsonProperty(value="nombre")String pNombre, @JsonProperty(value="id")int pId, @JsonProperty(value="password")String pPassword, @JsonProperty(value="usuario")String pUsuario) 
	{
		super();
		this.nombre = pNombre;
		this.id = pId;
		this.password = pPassword;
		this.usuario = pUsuario;
	}
	
	public String getNombre()
	{
		return this.nombre;
	}
	
	public int getId()
	{
		return this.id;
	}
	
	public String getUsuario()
	{
		return this.usuario;
	}

	public String getPassword()
	{
		return this.password;
	}
	
	public void setNombre(String newNombre)
	{
		this.nombre = newNombre;
	}
	
	public void setUsuario(String newUsuario)
	{
		this.nombre = newUsuario;
	}
	
	public void setPassword(String newPassword)
	{
		this.nombre = newPassword;
	}
	
	public void setId(int newId)
	{
		this.id = newId;
	}
	
}

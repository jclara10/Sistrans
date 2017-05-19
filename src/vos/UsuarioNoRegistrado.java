package vos;

import org.codehaus.jackson.annotate.JsonProperty;

public class UsuarioNoRegistrado 
{

	@JsonProperty(value="nombre")
	private String nombre;
	
	@JsonProperty(value="id")
	private int id;
	
	@JsonProperty(value="email")
	private String email;
	
	@JsonProperty(value="rol")
	private String rol;
	
	@JsonProperty(value="codEntrada")
	private int codEntrada;
	
	public UsuarioNoRegistrado(@JsonProperty(value="nombre")String pNombre, @JsonProperty(value="id")int pId, @JsonProperty(value="email")String pEmail, @JsonProperty(value="rol")String pRol, @JsonProperty(value="codEntrada")int pCodEntrada) 
	{
		this.nombre = pNombre;
		this.id = pId;
		this.email = pEmail;
		this.rol = pRol;
		this.codEntrada = pCodEntrada;
	}
	
	public String getNombre()
	{
		return this.nombre;
	}
	
	public int getId()
	{
		return this.id;
	}
	
	public String getEmail()
	{
		return this.email;
	}

	public String getRol()
	{
		return this.rol;
	}
	
	public int getCodEntrada()
	{
		return this.codEntrada;
	}
	
	public void setNombre(String newNombre)
	{
		this.nombre = newNombre;
	}
	
	public void setId(int newId)
	{
		this.id = newId;
	}
	
	public void setEmail(String newEmail)
	{
		this.email = newEmail;
	}
	
	public void setRol(String newRol)
	{
		this.rol = newRol;
	}
	
	public void setCodEntrada(int newCodEntrada)
	{
		this.codEntrada = newCodEntrada;
	}
}

package vos;

import org.codehaus.jackson.annotate.JsonProperty;

public class Cliente
{
	@JsonProperty(value="nombre")
	private String nombre;
	
	@JsonProperty(value="id")
	private int id;

	@JsonProperty(value="email")
	private String email;
	
	@JsonProperty(value="rol")
	private String rol;
	
	@JsonProperty(value="password")
	private String password;
	
	@JsonProperty(value="prefencia")
	private String preferencia;

	@JsonProperty(value="codigoEntrada")
	private int codigoEntrada;
	
	@JsonProperty(value="esAbonado")
	private String esAbonado;
	
	//@JsonProperty(value="codigoEntrada")int codigoEntrada,

	public Cliente(@JsonProperty(value="nombre")String nombre, @JsonProperty(value="id")int id, @JsonProperty(value="email")String email, @JsonProperty(value="rol")String rol, @JsonProperty(value="password")String password,  @JsonProperty(value="prefencia")String pPreferencia, @JsonProperty(value="esAbonado")String pEsAbonado)
	{
		super();
		this.nombre = nombre;
		this.id = id;
		this.email = email;
		this.rol = rol;
		this.password = password;
		//this.codigoEntrada = codigoEntrada;
		this.preferencia = pPreferencia; 
		this.esAbonado = pEsAbonado;
	}

	public String getNombre()
	{
		return nombre;
	}

	public void setNombre(String nombre)
	{
		this.nombre = nombre;
	}
	
	public String getPreferencia()
	{
		return preferencia;
	}

	public void setPreferencia(String preferencia)
	{
		this.preferencia = preferencia;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getRol()
	{
		return rol;
	}

	public void setRol(String rol)
	{
		this.rol = rol;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public int getCodigoEntrada()
	{
		return codigoEntrada;
	}

	public void setCodigoEntrada(int codigoEntrada)
	{
		this.codigoEntrada = codigoEntrada;
	}
	public String getEsAbonado()
	{
		return esAbonado;
	}

	public void setEsAbonado(String pEsAbonado)
	{
		this.esAbonado = pEsAbonado;
	}
	
}

package vos;

import java.util.Date;

import org.codehaus.jackson.annotate.JsonProperty;

public class CompaniaDeTeatro
{
	@JsonProperty(value="nombre")
	private String nombre;
	
	@JsonProperty(value="representante")
	private String representante;
	
	@JsonProperty(value="codigo")
	private int codigo;

	@JsonProperty(value="idRepresentante")
	private int idRepresentante;
	
	@JsonProperty(value="paisOrigen")
	private String paisOrigen;
	
	@JsonProperty(value="paginaWeb")
	private String paginaWeb;
	
	@JsonProperty(value="fechaLlegada")
	private Date fechaLlegada;
	
	@JsonProperty(value="fechaPartida")
	private Date fechaPartida;
	
	@JsonProperty(value="email")
	private String email;
	
	@JsonProperty(value="password")
	private String password;

	@JsonProperty(value="codigoEspectaculo")
	private int codigoEspectaculo;

	public CompaniaDeTeatro(@JsonProperty(value="nombre")String nombre, @JsonProperty(value="representante")String representante, @JsonProperty(value="idRepresentante")int idRepresentante, @JsonProperty(value="paisOrigen")String paisOrigen,
			@JsonProperty(value="paginaWeb")String paginaWeb, @JsonProperty(value="fechaLlegada")Date fechaLlegada, @JsonProperty(value="fechaPartida")Date fechaPartida, @JsonProperty(value="email")String email, @JsonProperty(value="password")String password,
			@JsonProperty(value="codigoEspectaculo")int codigoEspectaculo, @JsonProperty(value="codigo")int pCodigo)
	{
		super();
		this.nombre = nombre;
		this.representante = representante;
		this.idRepresentante = idRepresentante;
		this.paisOrigen = paisOrigen;
		this.paginaWeb = paginaWeb;
		this.fechaLlegada = fechaLlegada;
		this.fechaPartida = fechaPartida;
		this.email = email;
		this.password = password;
		this.codigoEspectaculo = codigoEspectaculo;
		this.codigo = pCodigo;
	}

	public String getNombre()
	{
		return nombre;
	}

	public void setNombre(String nombre)
	{
		this.nombre = nombre;
	}

	public String getRepresentante()
	{
		return representante;
	}

	public void setRepresentante(String representante)
	{
		this.representante = representante;
	}

	public int getIdRepresentante()
	{
		return idRepresentante;
	}

	public void setIdRepresentante(int idRepresentante)
	{
		this.idRepresentante = idRepresentante;
	}

	public String getPaisOrigen()
	{
		return paisOrigen;
	}

	public void setPaisOrigen(String paisOrigen)
	{
		this.paisOrigen = paisOrigen;
	}

	public String getPaginaWeb()
	{
		return paginaWeb;
	}

	public void setPaginaWeb(String paginaWeb)
	{
		this.paginaWeb = paginaWeb;
	}

	public Date getFechaLlegada()
	{
		return fechaLlegada;
	}

	public void setFechaLlegada(Date fechaLlegada)
	{
		this.fechaLlegada = fechaLlegada;
	}

	public Date getFechaPartida()
	{
		return fechaPartida;
	}

	public void setFechaPartida(Date fechaPartida)
	{
		this.fechaPartida = fechaPartida;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public int getCodigoEspectaculo()
	{
		return codigoEspectaculo;
	}

	public void setCodigoEspectaculo(int codigoEspectaculo)
	{
		this.codigoEspectaculo = codigoEspectaculo;
	}
	
	public int getCodigo() 
	{
		return codigo;
	}

	public void setCodigo(int codigo) 
	{
		this.codigo = codigo;
	}
	
	
}

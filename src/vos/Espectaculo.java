package vos;

import java.sql.Date;

import org.codehaus.jackson.annotate.JsonProperty;

public class Espectaculo 
{

	@JsonProperty(value="nombre")
	private String nombre;
	
	@JsonProperty(value="fecha")
	private Date fecha;
	
	@JsonProperty(value="duracion")
	private int duracion;
	
	@JsonProperty(value="estilo")
	private String estilo;
	
	@JsonProperty(value="codigo")
	private int codigo;
	
	@JsonProperty(value="idioma")
	private String idioma;
	
	@JsonProperty(value="costoRealizacion")
	private Double costoRealizacion;
	
	@JsonProperty(value="tieneTraduccion")
	private Boolean tieneTraduccion;
	
	@JsonProperty(value="publicoObjetivo")
	private String publicoObjetivo;
	
	@JsonProperty(value="descripcion")
	private String descripcion;
	
	public Espectaculo(@JsonProperty(value="nombre")String pNombre, @JsonProperty(value="fecha")Date pFecha, @JsonProperty(value="duracion")int pDuracion, @JsonProperty(value="estilo")String pEstilo, @JsonProperty(value="codigo")int pCodigo, @JsonProperty(value="idioma")String pIdioma, @JsonProperty(value="costoRealizacion")Double pCostoRealizacion, @JsonProperty(value="tieneTraduccion")Boolean pTieneTraduccion, @JsonProperty(value="publicoObjetivo")String pPublicoObjetivo, @JsonProperty(value="descripcion")String pDescripcion) 
	{
		super();
		this.nombre = pNombre;
		this.fecha = pFecha;
		this.duracion = pDuracion;
		this.estilo = pEstilo;
		this.codigo = pCodigo;
		this.idioma = pIdioma;
		this.costoRealizacion = pCostoRealizacion;
		this.tieneTraduccion = pTieneTraduccion;
		this.publicoObjetivo = pPublicoObjetivo;
		this.descripcion = pDescripcion;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getNombre() 
	{
		return this.nombre;
	}

	public void setNombre(String newNombre) 
	{
		this.nombre = newNombre;
	}

	public int getDuracion() 
	{
		return this.duracion;
	}
	
	public void setDuracion(int newDuracion) 
	{
		this.duracion = newDuracion;
	}

	public String getEstilo() 
	{
		return this.estilo;
	}

	public void setEstilo(String newEstilo) 
	{
		this.estilo = newEstilo;
	}

	public int getCodigo() 
	{
		return this.codigo;
	}

	public void setCodigo(int newCodigo) 
	{
		this.codigo = newCodigo;
	}

	public String getIdioma() 
	{
		return this.idioma;
	}

	public void setIdioma(String newIdioma) 
	{
		this.idioma = newIdioma;
	}

	public Double getCostoRealizacion() 
	{
		return this.costoRealizacion;
	}

	public void setCostoRealizacion(Double newCostoRealizacion) 
	{
		this.costoRealizacion = newCostoRealizacion;
	}

	public Boolean getTieneTraduccion() 
	{
		return this.tieneTraduccion;
	}

	public void setTieneTraduccion(Boolean newTieneTraduccion) 
	{
		this.tieneTraduccion = newTieneTraduccion;
	}

	public String getPublicoObjetivo() 
	{
		return this.publicoObjetivo;
	}

	public void setPublicoObjetivo(String newPublicoObjetivo) 
	{
		this.publicoObjetivo = newPublicoObjetivo;
	}

	public String getDescripcion() 
	{
		return this.descripcion;
	}

	public void setDescripcion(String newDescripcion) 
	{
		this.descripcion = newDescripcion;
	}

}

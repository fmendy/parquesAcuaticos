package com.alvaro.parquesAcuaticos.bean;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Parque")
public class Parque {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDParque", nullable = false, unique = true, updatable = false)
	private int idParque;
	
	@Column(name = "Nombre", nullable = false, unique = true, length = 80)
	private String nombre;
	
	@Column(name = "Web", length = 250)
	private String web;
	
	@Column(name = "Imagen", length = 250)
	private String imagen;
	
	@Column(name = "Descripcion", length = 500)
	private String descripcion;
	
	@ManyToOne
    @JoinColumn(name="IDCompania", nullable=false)
	private Compania compania = new Compania();
	
	@ManyToOne
    @JoinColumn(name="IDLocalidad", nullable=false)
	private Localidad localidad = new Localidad();
	
	@Column(name = "Activo", insertable = false)
	private boolean activo;
	
	@Column(name = "FechaCreacion", insertable = false, updatable = false)
	private Date fechaCreacion;
	
	@Column(name = "FechaUltimaModificacion", insertable = false)
	private Date fechaUltimaModificacion;

	/**
	 * @return the idParque
	 */
	public int getIdParque() {
		return idParque;
	}

	/**
	 * @param idParque the idParque to set
	 */
	public void setIdParque(int idParque) {
		this.idParque = idParque;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the web
	 */
	public String getWeb() {
		return web;
	}

	/**
	 * @param web the web to set
	 */
	public void setWeb(String web) {
		this.web = web;
	}

	/**
	 * @return the imagen
	 */
	public String getImagen() {
		return imagen;
	}

	/**
	 * @param imagen the imagen to set
	 */
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * @return the compania
	 */
	public Compania getCompania() {
		return compania;
	}

	/**
	 * @param compania the compania to set
	 */
	public void setCompania(Compania compania) {
		this.compania = compania;
	}

	/**
	 * @return the localidad
	 */
	public Localidad getLocalidad() {
		return localidad;
	}

	/**
	 * @param localidad the localidad to set
	 */
	public void setLocalidad(Localidad localidad) {
		this.localidad = localidad;
	}

	/**
	 * @return the activo
	 */
	public boolean isActivo() {
		return activo;
	}

	/**
	 * @param activo the activo to set
	 */
	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	/**
	 * @return the fechaCreacion
	 */
	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	/**
	 * @param fechaCreacion the fechaCreacion to set
	 */
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	/**
	 * @return the fechaUltimaModificacion
	 */
	public Date getFechaUltimaModificacion() {
		return fechaUltimaModificacion;
	}

	/**
	 * @param fechaUltimaModificacion the fechaUltimaModificacion to set
	 */
	public void setFechaUltimaModificacion(Date fechaUltimaModificacion) {
		this.fechaUltimaModificacion = fechaUltimaModificacion;
	}

	public Parque() {
		super();
	}
	
	
	
}

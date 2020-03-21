package com.alvaro.parquesAcuaticos.bean;

import java.io.Serializable;
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
@Table(name = "Foto")
public class Foto implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDFoto", nullable = false, unique = true, updatable = false)
	private int idFoto;
	
	@Column(name = "url", length = 250)
	private String url;
	
	@Column(name = "Activo", insertable = false)
	private boolean activo;
	
	@Column(name = "FechaCreacion", insertable = false, updatable = false)
	private Date fechaCreacion;
	
	@Column(name = "FechaUltimaModificacion", insertable = false)
	private Date fechaUltimaModificacion;
	
	@ManyToOne
    @JoinColumn(name="IDParque")
	private Parque parque= new Parque();
	
	@ManyToOne
    @JoinColumn(name="IDAtraccion")
	private Atraccion atraccion= new Atraccion();
	
	@ManyToOne
    @JoinColumn(name="IDTipoFoto")
	private TipoFoto tipoFoto= new TipoFoto();

	/**
	 * @return the idFoto
	 */
	public int getIdFoto() {
		return idFoto;
	}

	/**
	 * @param idFoto the idFoto to set
	 */
	public void setIdFoto(int idFoto) {
		this.idFoto = idFoto;
	}

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
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
	
	

	/**
	 * @return the parque
	 */
	public Parque getParque() {
		return parque;
	}

	/**
	 * @param parque the parque to set
	 */
	public void setParque(Parque parque) {
		this.parque = parque;
	}
	
	

	/**
	 * @return the tipoFoto
	 */
	public TipoFoto getTipoFoto() {
		return tipoFoto;
	}

	/**
	 * @param tipoFoto the tipoFoto to set
	 */
	public void setTipoFoto(TipoFoto tipoFoto) {
		this.tipoFoto = tipoFoto;
	}
	
	

	/**
	 * @return the atraccion
	 */
	public Atraccion getAtraccion() {
		return atraccion;
	}

	/**
	 * @param atraccion the atraccion to set
	 */
	public void setAtraccion(Atraccion atraccion) {
		this.atraccion = atraccion;
	}

	public Foto() {
		super();
	}
	
	
}

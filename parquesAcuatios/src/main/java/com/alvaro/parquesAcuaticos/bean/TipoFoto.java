package com.alvaro.parquesAcuaticos.bean;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TipoFoto")
public class TipoFoto implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDTipoFoto", nullable = false, unique = true, updatable = false)
	private int idTipoFoto;
	
	@Column(name = "Nombre", nullable = false, unique = true, length = 80)
	private String nombre;
	
	@Column(name = "Activo", insertable = false)
	private boolean activo;
	
	@Column(name = "FechaCreacion", insertable = false, updatable = false)
	private Date fechaCreacion;
	
	@Column(name = "FechaUltimaModificacion", insertable = false)
	private Date fechaUltimaModificacion;

	/**
	 * @return the idTipoFoto
	 */
	public int getIdTipoFoto() {
		return idTipoFoto;
	}

	/**
	 * @param idTipoFoto the idTipoFoto to set
	 */
	public void setIdTipoFoto(int idTipoFoto) {
		this.idTipoFoto = idTipoFoto;
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

	public TipoFoto() {
		super();
	}
	
	

}

package com.alvaro.parquesAcuaticos.bean;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Atraccion")
public class Atraccion implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDAtraccion", nullable = false, unique = true, updatable = false)
	private int idCompania;

	@Column(name = "Nombre", nullable = false, unique = true, length = 80)
	private String nombre;

	@Column(name = "Descripcion", length = 500)
	private String descripcion;

	@ManyToOne
	@JoinColumn(name = "IDParque", nullable = false)
	private Parque parque = new Parque();

	@Column(name = "Activo", insertable = false, updatable = false)
	private boolean activo;

	@Column(name = "FechaCreacion", insertable = false, updatable = false)
	private Date fechaCreacion;

	@Column(name = "FechaUltimaModificacion", insertable = false)
	private Date fechaUltimaModificacion;

	@OneToMany(mappedBy = "atraccion", fetch = FetchType.EAGER)
	private List<Foto> listFoto = new ArrayList<Foto>();

	/**
	 * @return the idCompania
	 */
	public int getIdCompania() {
		return idCompania;
	}

	/**
	 * @param idCompania the idCompania to set
	 */
	public void setIdCompania(int idCompania) {
		this.idCompania = idCompania;
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
	 * @return the listFoto
	 */
	public List<Foto> getListFoto() {
		return listFoto;
	}

	/**
	 * @param listFoto the listFoto to set
	 */
	public void setListFoto(List<Foto> listFoto) {
		this.listFoto = listFoto;
	}

	public Atraccion() {
		super();
	}

}

package com.alvaro.parquesAcuaticos.bean;

import java.io.File;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "Compania")
public class Compania {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDCompania", nullable = false, unique = true, updatable = false)
	private int idCompania;
	
	@Column(name = "Nombre", nullable = false, unique = true, length = 80)
	private String nombre;
	
	@Column(name = "Web", length = 250)
	private String web;
	
	@Column(name = "Imagen", length = 250)
	private String imagen;
	


	@Column(name = "Activo", insertable = false, updatable = false)
	private boolean activo;
	
	@Column(name = "FechaCreacion", insertable = false, updatable = false)
	private Date fechaCreacion;
	
	@Column(name = "FechaUltimaModificacion", insertable = false)
	private Date fechaUltimaModificacion;
	
	@OneToMany(mappedBy="compania", fetch = FetchType.EAGER)
	private List<Parque> listParque = new ArrayList<Parque>();
	
	

	/**
	 * @return the listParque
	 */
	public List<Parque> getListParque() {
		return listParque;
	}

	/**
	 * @param listParque the listParque to set
	 */
	public void setListParque(List<Parque> listParque) {
		this.listParque = listParque;
	}

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

	public Compania() {
		super();
	}

	@Override
	public boolean equals(Object obj) {

		return this.idCompania == ((Compania) obj).idCompania;
	}
	
	
	
}


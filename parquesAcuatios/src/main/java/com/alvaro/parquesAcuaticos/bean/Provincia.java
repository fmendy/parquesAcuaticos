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
@Table(name = "Provincia")
public class Provincia implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDProvincia", nullable = false, unique = true, updatable = false)
	private int idProvincia;
	
	@Column(name = "Nombre", nullable = false, unique = true, length = 80)
	private String nombre;

	@ManyToOne
    @JoinColumn(name="IDPais", nullable=false)
	private Pais pais = new Pais();
	
	@Column(name = "Activo", insertable = false)
	private boolean activo;
	
	@Column(name = "FechaCreacion", insertable = false, updatable = false)
	private Date fechaCreacion;
	
	@Column(name = "FechaUltimaModificacion", insertable = false)
	private Date fechaUltimaModificacion;
	
	@OneToMany(mappedBy="provincia", fetch = FetchType.EAGER)
	private List<Localidad> listLocalidad= new ArrayList<Localidad>();

	/**
	 * @return the idProvincia
	 */
	public int getIdProvincia() {
		return idProvincia;
	}

	/**
	 * @param idProvincia the idProvincia to set
	 */
	public void setIdProvincia(int idProvincia) {
		this.idProvincia = idProvincia;
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
	 * @return the pais
	 */
	public Pais getPais() {
		return pais;
	}

	/**
	 * @param pais the pais to set
	 */
	public void setPais(Pais pais) {
		this.pais = pais;
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
	 * @return the listLocalidad
	 */
	public List<Localidad> getListLocalidad() {
		return listLocalidad;
	}

	/**
	 * @param listLocalidad the listLocalidad to set
	 */
	public void setListLocalidad(List<Localidad> listLocalidad) {
		this.listLocalidad = listLocalidad;
	}

	public Provincia() {
		super();
	}
	
	
	
}

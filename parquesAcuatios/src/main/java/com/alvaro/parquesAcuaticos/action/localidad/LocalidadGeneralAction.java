package com.alvaro.parquesAcuaticos.action.localidad;

import java.util.ArrayList;
import java.util.List;

import com.alvaro.parquesAcuaticos.action.GeneralAction;
import com.alvaro.parquesAcuaticos.bean.Localidad;
import com.alvaro.parquesAcuaticos.bean.Provincia;
import com.alvaro.parquesAcuaticos.business.dao.LocalidadDAO;
import com.alvaro.parquesAcuaticos.business.dao.impl.LocalidadDAOImpl;
import com.alvaro.parquesAcuaticos.session.SessionesGlobales;

public class LocalidadGeneralAction extends GeneralAction {
	private List<Localidad> listaLocalidades = new ArrayList<Localidad>();
	private LocalidadDAO localidadDAO = new LocalidadDAOImpl();
	private Provincia provincia = new Provincia();

	public String getLocalidadesPorPais() {

		listaLocalidades = new ArrayList<Localidad>();
		if (provincia.getIdProvincia() > 0) {
			listaLocalidades = localidadDAO.getLocalidadesPorProvincia(provincia);
		}
		return SessionesGlobales.SUCCESS;
	}

	/**
	 * @return the listaLocalidades
	 */
	public List<Localidad> getListaLocalidades() {
		return listaLocalidades;
	}

	/**
	 * @param listaLocalidades the listaLocalidades to set
	 */
	public void setListaLocalidades(List<Localidad> listaLocalidades) {
		this.listaLocalidades = listaLocalidades;
	}

	/**
	 * @return the provincia
	 */
	public Provincia getProvincia() {
		return provincia;
	}

	/**
	 * @param provincia the provincia to set
	 */
	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}

}

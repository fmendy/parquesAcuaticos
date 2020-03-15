package com.alvaro.parquesAcuaticos.action.provincia;

import java.util.ArrayList;
import java.util.List;

import com.alvaro.parquesAcuaticos.action.GeneralAction;
import com.alvaro.parquesAcuaticos.bean.Localidad;
import com.alvaro.parquesAcuaticos.bean.Pais;
import com.alvaro.parquesAcuaticos.bean.Provincia;
import com.alvaro.parquesAcuaticos.business.dao.ProvinciaDAO;
import com.alvaro.parquesAcuaticos.business.dao.impl.ProvinciaDAOImpl;
import com.alvaro.parquesAcuaticos.session.SessionesGlobales;

public class ProvinciaGeneralAction extends GeneralAction {
	private List<Provincia> listaProvincias = new ArrayList<Provincia>();
	private ProvinciaDAO provinciaDAO = new ProvinciaDAOImpl();
	private Pais pais = new Pais();
	private Localidad localidad = new Localidad();
	
	
	
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

	public String getProvinciaPorPais() {
		System.out.println(pais.getIdPais());
		listaProvincias = provinciaDAO.getProvinciasPorPais(pais);
		for (Provincia p: listaProvincias) {
			System.out.println(p.getNombre());
		}

		return SessionesGlobales.SUCCESS;
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
	 * @return the listaProvincias
	 */
	public List<Provincia> getListaProvincias() {
		return listaProvincias;
	}

	/**
	 * @param listaProvincias the listaProvincias to set
	 */
	public void setListaProvincias(List<Provincia> listaProvincias) {
		this.listaProvincias = listaProvincias;
	}
	

}

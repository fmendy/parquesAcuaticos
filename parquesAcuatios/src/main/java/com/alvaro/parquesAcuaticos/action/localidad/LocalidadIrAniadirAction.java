package com.alvaro.parquesAcuaticos.action.localidad;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.alvaro.parquesAcuaticos.action.GeneralAction;
import com.alvaro.parquesAcuaticos.bean.Localidad;
import com.alvaro.parquesAcuaticos.bean.Pais;
import com.alvaro.parquesAcuaticos.bean.Provincia;
import com.alvaro.parquesAcuaticos.business.dao.PaisDAO;
import com.alvaro.parquesAcuaticos.business.dao.ProvinciaDAO;
import com.alvaro.parquesAcuaticos.business.dao.impl.PaisDAOImpl;
import com.alvaro.parquesAcuaticos.business.dao.impl.ProvinciaDAOImpl;
import com.alvaro.parquesAcuaticos.session.SessionesGlobales;

public class LocalidadIrAniadirAction extends GeneralAction {

	private PaisDAO paisDao = new PaisDAOImpl();
	final static Logger log = LogManager.getLogger(LocalidadIrAniadirAction.class);
	
	private List<Pais> listaPaises = new ArrayList<Pais>();
	private List<Provincia> listaProvincias = new ArrayList<Provincia>();
	private Localidad localidad = new Localidad();
	
	
	/**
	 * @return the paisDao
	 */
	public PaisDAO getPaisDao() {
		return paisDao;
	}


	/**
	 * @param paisDao the paisDao to set
	 */
	public void setPaisDao(PaisDAO paisDao) {
		this.paisDao = paisDao;
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
	 * @return the listaPaises
	 */
	public List<Pais> getListaPaises() {
		return listaPaises;
	}


	/**
	 * @param listaPaises the listaPaises to set
	 */
	public void setListaPaises(List<Pais> listaPaises) {
		this.listaPaises = listaPaises;
	}




	public String execute() {
		
		if (isUserLoged()) {
			listaPaises = paisDao.listarPaises();
			return SessionesGlobales.SUCCESS;
		} else {
			return SessionesGlobales.NO_LOGEADO;
		}
	}
	
}

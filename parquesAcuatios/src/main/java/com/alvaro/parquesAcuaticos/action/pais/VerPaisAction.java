package com.alvaro.parquesAcuaticos.action.pais;

import java.util.ArrayList;
import java.util.List;

import com.alvaro.parquesAcuaticos.bean.Localidad;
import com.alvaro.parquesAcuaticos.bean.Pais;
import com.alvaro.parquesAcuaticos.bean.Parque;
import com.alvaro.parquesAcuaticos.bean.Provincia;
import com.alvaro.parquesAcuaticos.business.dao.ParqueDAO;
import com.alvaro.parquesAcuaticos.business.dao.ProvinciaDAO;
import com.alvaro.parquesAcuaticos.business.dao.impl.ParqueDAOImpl;
import com.alvaro.parquesAcuaticos.business.dao.impl.ProvinciaDAOImpl;
import com.alvaro.parquesAcuaticos.session.SessionesGlobales;

public class VerPaisAction extends PaisGeneralAction{

	private ProvinciaDAO provinciaDAO = new ProvinciaDAOImpl();
	private ParqueDAO parqueDAO = new ParqueDAOImpl();
	private List<Pais> listPaises = new ArrayList<Pais>();	
	
	public String verPais() {
		
		pais = paisDAO.getPaisByID(pais);
		
		return SessionesGlobales.SUCCESS;
	}

	
	public String verPaises() {
		
		listPaises = paisDAO.listarPaises();
		return SessionesGlobales.SUCCESS;
	}
	/**
	 * @return the listPaises
	 */
	public List<Pais> getListPaises() {
		return listPaises;
	}

	/**
	 * @param listPaises the listPaises to set
	 */
	public void setListPaises(List<Pais> listPaises) {
		this.listPaises = listPaises;
	}

	
	
}

package com.alvaro.parquesAcuaticos.action.compania;

import java.util.ArrayList;
import java.util.List;

import com.alvaro.parquesAcuaticos.bean.Compania;
import com.alvaro.parquesAcuaticos.business.dao.ParqueDAO;
import com.alvaro.parquesAcuaticos.business.dao.impl.ParqueDAOImpl;
import com.alvaro.parquesAcuaticos.session.SessionesGlobales;

public class VerCompanias extends CompaniaGeneral {

	private List<Compania> listCompanias = new ArrayList<Compania>();
	private ParqueDAO parqueDAO = new ParqueDAOImpl();

	/**
	 * Solamente se ven aquellas compañias activas
	 * 
	 * @return
	 */
	public String verTodas() {

		listCompanias = companiaDAO.getAllCompanias();
		return SessionesGlobales.SUCCESS;
	}

	
	public String verCompania() {
		compania = companiaDAO.buscarCompaniaID(compania);
		compania.setListParque(parqueDAO.getParquePorCompania(compania));

		return SessionesGlobales.SUCCESS;
	}
	/**
	 * @return the listCompanias
	 */
	public List<Compania> getListCompanias() {
		return listCompanias;
	}

	/**
	 * @param listCompanias the listCompanias to set
	 */
	public void setListCompanias(List<Compania> listCompanias) {
		this.listCompanias = listCompanias;
	}

}

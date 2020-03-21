package com.alvaro.parquesAcuaticos.action.compania;

import com.alvaro.parquesAcuaticos.action.GeneralAction;
import com.alvaro.parquesAcuaticos.bean.Compania;
import com.alvaro.parquesAcuaticos.business.dao.CompaniaDAO;
import com.alvaro.parquesAcuaticos.business.dao.impl.CompaniaDAOImpl;

public class CompaniaGeneral extends GeneralAction {

	protected Compania compania = new Compania();
	protected CompaniaDAO companiaDAO = new CompaniaDAOImpl();
	/**
	 * @return the compania
	 */
	public Compania getCompania() {
		return compania;
	}
	/**
	 * @param compania the compania to set
	 */
	public void setCompania(Compania compania) {
		this.compania = compania;
	}
	/**
	 * @return the companiaDAO
	 */
	public CompaniaDAO getCompaniaDAO() {
		return companiaDAO;
	}
	/**
	 * @param companiaDAO the companiaDAO to set
	 */
	public void setCompaniaDAO(CompaniaDAO companiaDAO) {
		this.companiaDAO = companiaDAO;
	}
	
	
}

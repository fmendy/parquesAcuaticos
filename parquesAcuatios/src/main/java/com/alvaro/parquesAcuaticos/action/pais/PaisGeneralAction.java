package com.alvaro.parquesAcuaticos.action.pais;

import com.alvaro.parquesAcuaticos.action.GeneralAction;
import com.alvaro.parquesAcuaticos.bean.Pais;
import com.alvaro.parquesAcuaticos.business.dao.PaisDAO;
import com.alvaro.parquesAcuaticos.business.dao.impl.PaisDAOImpl;

public class PaisGeneralAction extends GeneralAction {

	protected Pais pais = new Pais();
	protected PaisDAO paisDAO = new PaisDAOImpl();
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
	
	
}

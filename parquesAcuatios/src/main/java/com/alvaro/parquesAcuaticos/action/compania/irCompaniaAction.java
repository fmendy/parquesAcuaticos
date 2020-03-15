package com.alvaro.parquesAcuaticos.action.compania;

import com.alvaro.parquesAcuaticos.action.GeneralAction;
import com.alvaro.parquesAcuaticos.bean.Compania;
import com.alvaro.parquesAcuaticos.business.dao.CompaniaDAO;
import com.alvaro.parquesAcuaticos.business.dao.impl.CompaniaDAOImpl;
import com.alvaro.parquesAcuaticos.session.SessionesGlobales;

public class irCompaniaAction extends GeneralAction {

	private Compania compania = new Compania();
	private CompaniaDAO companiaDAO = new CompaniaDAOImpl();

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

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		if (isUserLoged()) {
		if (compania.getIdCompania() > 0) {
			compania = companiaDAO.buscarCompaniaID(compania);
		}

		return SessionesGlobales.SUCCESS;
		} else {
			return SessionesGlobales.NO_LOGEADO;
		}
	}

}

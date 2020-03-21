package com.alvaro.parquesAcuaticos.action.compania;

import com.alvaro.parquesAcuaticos.action.GeneralAction;
import com.alvaro.parquesAcuaticos.bean.Compania;
import com.alvaro.parquesAcuaticos.business.dao.CompaniaDAO;
import com.alvaro.parquesAcuaticos.business.dao.impl.CompaniaDAOImpl;
import com.alvaro.parquesAcuaticos.session.SessionesGlobales;

public class irCompaniaAction extends CompaniaGeneral {

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

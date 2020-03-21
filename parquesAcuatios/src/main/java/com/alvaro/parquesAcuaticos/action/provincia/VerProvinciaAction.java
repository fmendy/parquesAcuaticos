package com.alvaro.parquesAcuaticos.action.provincia;

import com.alvaro.parquesAcuaticos.session.SessionesGlobales;

public class VerProvinciaAction extends ProvinciaGeneralAction {

	public String verProvincia() {
		provincia = provinciaDAO.getProvinciaByID(provincia);
		
		return SessionesGlobales.SUCCESS;
	}
}

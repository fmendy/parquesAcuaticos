package com.alvaro.parquesAcuaticos.action.usuario;

import com.alvaro.parquesAcuaticos.action.GeneralAction;
import com.alvaro.parquesAcuaticos.session.SessionesGlobales;

public class UsuarioVerMisDatosAction extends GeneralAction{

	@Override
	public String execute() throws Exception {
		if (isUserLoged()) {
			this.usuario = getUsuarioEnSession();
			return SessionesGlobales.SUCCESS;
		}
		else {
			return SessionesGlobales.FAILED;
		}
	}

	
}

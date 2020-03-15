package com.alvaro.parquesAcuaticos.action.usuario;

import java.util.List;

import com.alvaro.parquesAcuaticos.action.GeneralAction;
import com.alvaro.parquesAcuaticos.bean.Usuario;
import com.alvaro.parquesAcuaticos.session.SessionesGlobales;

public class UsuarioIrRegistroAction extends GeneralAction{
	
	public String execute() throws Exception {
		if (!isUserLoged()) {
			return SessionesGlobales.SUCCESS;
		}
		else {
			this.setUsuario(getUsuarioEnSession());
			return SessionesGlobales.FAILED;
		}
	}
}

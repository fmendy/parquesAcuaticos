package com.alvaro.parquesAcuaticos.action.usuario;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.alvaro.parquesAcuaticos.action.GeneralAction;
import com.alvaro.parquesAcuaticos.bean.Usuario;
import com.alvaro.parquesAcuaticos.business.dao.UsuarioDAO;
import com.alvaro.parquesAcuaticos.business.dao.impl.UsuarioDAOImpl;
import com.alvaro.parquesAcuaticos.session.SessionesGlobales;
import com.opensymphony.xwork2.ActionSupport;

public class UsuarioLoginAction extends GeneralAction {
	private UsuarioDAO usuarioDao = new UsuarioDAOImpl();
	final static Logger log = LogManager.getLogger(UsuarioLoginAction.class);

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("logeando");
		if (isUserLoged()) {
			this.setUsuario(getUsuarioEnSession());
			return SessionesGlobales.SUCCESS;
		}
		if (this.getUsuario() != null) {
			Usuario userAux = usuarioDao.iniciarSesion(this.getUsuario());
			if (userAux != null) {
				guardarUsuarioEnSession(userAux);
				this.setUsuario(userAux);
				return SessionesGlobales.SUCCESS;
			}
		}
		return SessionesGlobales.FAILED;

	}

}

package com.alvaro.parquesAcuaticos.action.usuario;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.alvaro.parquesAcuaticos.action.GeneralAction;
import com.alvaro.parquesAcuaticos.business.dao.UsuarioDAO;
import com.alvaro.parquesAcuaticos.business.dao.impl.UsuarioDAOImpl;
import com.alvaro.parquesAcuaticos.session.SessionesGlobales;
import com.microsoft.sqlserver.jdbc.SQLServerDriver;
import com.opensymphony.xwork2.ActionSupport;

public class UsuarioRegistrarAction extends GeneralAction {

	private UsuarioDAO usuarioDAO = new UsuarioDAOImpl();

	public String execute() throws Exception {
		if (!isUserLoged()) {
			usuarioDAO.guardarUsuario(usuario);
			return SessionesGlobales.SUCCESS;
		} else {
			this.setUsuario(getUsuarioEnSession());
			return "LOGEADO";
		}
	}

	public void validate() {
		ActionSupport actionSupport = new ActionSupport();
		if (!usuarioDAO.isEmailValidForRegistration(usuario.getEmail())) {
			addFieldError("usuario.email", actionSupport.getText("usuario.email.ya.registrado"));
		}
		if (!usuarioDAO.isApodoValidForRegistration(usuario.getApodo())) {
			addFieldError("usuario.apodo", actionSupport.getText("usuario.apodo.ya.registrado"));
		}

	}
	

}


package com.alvaro.parquesAcuaticos.action;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.alvaro.parquesAcuaticos.bean.Usuario;
import com.alvaro.parquesAcuaticos.business.dao.CompaniaDAO;
import com.alvaro.parquesAcuaticos.business.dao.impl.CompaniaDAOImpl;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author alvaro
 *
 */
public class GeneralAction extends ActionSupport {

	protected Usuario usuario;
	
	protected String operationStatus;

	public HttpSession getSession() {
		return ServletActionContext.getRequest().getSession();
	}

	public void guardarUsuarioEnSession(Usuario usuario) {
		HttpSession session = getSession();
		session.setAttribute("usuario", usuario);
	}

	public Usuario getUsuarioEnSession() {
		return (Usuario) getSession().getAttribute("usuario");
	}

	public boolean isUserLoged() {
		return (getUsuarioEnSession() == null ? false : true);
	}

	/**
	 * @return the usuario
	 */
	public Usuario getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	/**
	 * @return the operationStatus
	 */
	public String getOperationStatus() {
		return operationStatus;
	}

	/**
	 * @param operationStatus the operationStatus to set
	 */
	public void setOperationStatus(String operationStatus) {
		this.operationStatus = operationStatus;
	}
	
	

}

/**
 * 
 */
package com.alvaro.parquesAcuaticos.business.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.alvaro.parquesAcuaticos.bean.Usuario;
import com.alvaro.parquesAcuaticos.persistence.HibernateUtil;

/**
 * @author alvaro
 *
 */
public interface UsuarioDAO {

	public boolean guardarUsuario(Usuario usuario);
	
	public Usuario iniciarSesion(Usuario usuario);
	
	public boolean isApodoValidForRegistration(String apodo);
	
	public boolean isEmailValidForRegistration(String email);
	

}

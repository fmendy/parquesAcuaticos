/**
 * 
 */
package com.alvaro.parquesAcuaticos.business.dao.impl;


import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.alvaro.parquesAcuaticos.bean.Usuario;
import com.alvaro.parquesAcuaticos.business.dao.UsuarioDAO;
import com.alvaro.parquesAcuaticos.persistence.HibernateUtil;

/**
 * @author alvaro
 *
 */
public class UsuarioDAOImpl implements UsuarioDAO {

	public boolean guardarUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		boolean result = false;
		Transaction transaction = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {

			// Empieza Transaction
			transaction = session.beginTransaction();
			session.save(usuario);

			transaction.commit();
			result = true;

		} catch (Exception e) {
			System.err.println(e);
			if (transaction != null) {
				transaction.rollback();
			}
			result = false;
		} finally {
			session.close();
		}
		return result;

	}

	public Usuario iniciarSesion(Usuario usuario) {
		// TODO Auto-generated method stub
		Usuario user = null;
		Transaction transaction = null;
		String hql = "from Usuario u where u.email=:usuarioEmail and u.password=:usuarioPassword and u.activo = 1";
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {

			// Empieza Transaction
			transaction = session.beginTransaction();

			Query query = session.createQuery(hql);
			query.setParameter("usuarioEmail", usuario.getEmail());
			query.setParameter("usuarioPassword", usuario.getPassword());
			if (query.list() != null) {
				user = (Usuario) query.list().get(0);
			}

			transaction.commit();

		} catch (Exception e) {
			System.out.println(e);
			if (transaction != null) {
				transaction.rollback();
			}
			user = null;
		} finally {
			session.close();
		}
		return user;
	}

	public boolean isApodoValidForRegistration(String apodo) {
		// TODO Auto-generated method stub
		boolean result = false;
		Transaction transaction = null;
		String hql = "from Usuario u where u.apodo=:usuarioApodo and u.activo = 1";
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {

			// Empieza Transaction
			transaction = session.beginTransaction();

			Query query = session.createQuery(hql);
			query.setParameter("usuarioApodo", apodo);
			if(query.list().size()==0) {
				result = true;
			}

			transaction.commit();

		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			result = false;
		} finally {
			session.close();
		}

		return result;
	}

	public boolean isEmailValidForRegistration(String email) {
		// TODO Auto-generated method stub
		boolean result = false;
		Transaction transaction = null;
		String hql = "from Usuario u where u.email=:usuarioEmail and u.activo = 1";
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {

			// Empieza Transaction
			transaction = session.beginTransaction();

			Query query = session.createQuery(hql);
			query.setParameter("usuarioEmail", email);
			if(query.list().size()==0) {
				result = true;
			}
			transaction.commit();

		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			result = false;
		} finally {
			session.close();
		}

		return result;
	}

}

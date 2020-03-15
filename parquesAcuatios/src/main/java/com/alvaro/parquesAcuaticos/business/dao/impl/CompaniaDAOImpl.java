package com.alvaro.parquesAcuaticos.business.dao.impl;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.alvaro.parquesAcuaticos.bean.Compania;
import com.alvaro.parquesAcuaticos.business.dao.CompaniaDAO;
import com.alvaro.parquesAcuaticos.persistence.HibernateUtil;
import com.alvaro.parquesAcuaticos.session.SessionesGlobales;

public class CompaniaDAOImpl implements CompaniaDAO {

	public Compania buscarCompaniaID(Compania compania) {
		Compania comp = null;
		Transaction transaction = null;
		String hql = "from Compania c where c.idCompania=:idenCompa and c.activo = 1";
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {

			// Empieza Transaction
			transaction = session.beginTransaction();

			Query query = session.createQuery(hql);
			query.setParameter("idenCompa", compania.getIdCompania());
			if (query.list() != null) {
				comp = (Compania) query.list().get(0);
				System.out.println(comp.getIdCompania()+ " "+comp.getIdCompania());
			}

			transaction.commit();

		} catch (Exception e) {
			System.out.println(e);
			if (transaction != null) {
				transaction.rollback();
			}
			comp = null;
		} finally {
			session.close();
		}
		return comp;
	}

	public boolean guardarCompania(Compania compania) {
		// TODO Auto-generated method stub
		boolean result = false;
		Transaction transaction = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {

			// Empieza Transaction
			transaction = session.beginTransaction();
			
			session.save(compania);

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

	public boolean actualizarCompania(Compania compania) {
		boolean result = false;
		Transaction transaction = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {

			// Empieza Transaction
			transaction = session.beginTransaction();

			
			compania.setFechaUltimaModificacion(SessionesGlobales.getDateSQL());
			session.update(compania);

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

}

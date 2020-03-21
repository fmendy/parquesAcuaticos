package com.alvaro.parquesAcuaticos.business.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.alvaro.parquesAcuaticos.bean.Compania;
import com.alvaro.parquesAcuaticos.bean.Parque;
import com.alvaro.parquesAcuaticos.business.dao.ParqueDAO;
import com.alvaro.parquesAcuaticos.persistence.HibernateUtil;
import com.alvaro.parquesAcuaticos.session.SessionesGlobales;

public class ParqueDAOImpl implements ParqueDAO {

	public boolean guardarParque(Parque parque) {
		boolean result = false;
		Transaction transaction = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {

			// Empieza Transaction
			transaction = session.beginTransaction();

			session.save(parque);
			parque.setActivo(true);
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

	public Parque buscarParque(Parque parque) {
		Parque result = null;
		Transaction transaction = null;
		String hql = "from Parque p where p.idParque=:idenParque and p.activo = 1";
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {

			// Empieza Transaction
			transaction = session.beginTransaction();

			Query query = session.createQuery(hql);
			query.setParameter("idenParque", parque.getIdParque());
			if (query.list() != null) {
				result = (Parque) query.list().get(0);
			}

			transaction.commit();

		} catch (Exception e) {
			System.out.println(e);
			if (transaction != null) {
				transaction.rollback();
			}
			result = null;
		} finally {
			session.close();
		}
		return result;
	}

	public boolean actualizarParque(Parque parque) {
		boolean result = false;
		Transaction transaction = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {

			// Empieza Transaction
			transaction = session.beginTransaction();

			parque.setFechaUltimaModificacion(SessionesGlobales.getDateSQL());
			session.update(parque);

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

	public List<Parque> getParquePorCompania(Compania compania) {
		List<Parque> result = null;
		Transaction transaction = null;
		String hql = "from Parque p where p.compania.idCompania=:idenCompania and p.activo = 1";
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {

			// Empieza Transaction
			transaction = session.beginTransaction();

			Query query = session.createQuery(hql);
			query.setParameter("idenCompania", compania.getIdCompania());
			result = query.list();

			transaction.commit();

		} catch (Exception e) {
			System.out.println(e);
			if (transaction != null) {
				transaction.rollback();
			}
			result = null;
		} finally {
			session.close();
		}

		if (result == null) {
			result = new ArrayList<Parque>();
		}
		return result;
	}

}

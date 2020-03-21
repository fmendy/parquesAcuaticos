package com.alvaro.parquesAcuaticos.business.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.alvaro.parquesAcuaticos.bean.Etiqueta;
import com.alvaro.parquesAcuaticos.bean.Pais;
import com.alvaro.parquesAcuaticos.bean.Usuario;
import com.alvaro.parquesAcuaticos.business.dao.EtiquetaDAO;
import com.alvaro.parquesAcuaticos.persistence.HibernateUtil;
import com.alvaro.parquesAcuaticos.session.SessionesGlobales;

public class EtiquetaDAOImpl implements EtiquetaDAO {

	public boolean guardarEtiqueta(Etiqueta etiqueta) {
		boolean result = false;
		Transaction transaction = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {

			// Empieza Transaction
			transaction = session.beginTransaction();
			session.save(etiqueta);

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

	public Etiqueta getEtiquetaNombreExacto(Etiqueta etiqueta) {
		Etiqueta result = null;
		Transaction transaction = null;
		String hql = "from Etiqueta e where e.nombre=:etNombre and e.activo = 1";
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {

			// Empieza Transaction
			transaction = session.beginTransaction();

			Query query = session.createQuery(hql);
			query.setParameter("etNombre", etiqueta.getNombre());
			if (query.list() != null) {
				result = (Etiqueta) query.list().get(0);
			}
			transaction.commit();

		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
		return result;
	}

	public Etiqueta getEtiquetaByID(Etiqueta etiqueta) {
		Etiqueta result = null;
		Transaction transaction = null;
		String hql = "from Etiqueta e where e.idEtiqueta=:etId and e.activo = 1";
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {

			// Empieza Transaction
			transaction = session.beginTransaction();

			Query query = session.createQuery(hql);
			query.setParameter("etId", etiqueta.getIdEtiqueta());
			if (query.list() != null) {
				result = (Etiqueta) query.list().get(0);
			}
			transaction.commit();

		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
		return result;
	}

	public boolean actualiarEtiqueta(Etiqueta etiqueta) {
		boolean result = false;
		Transaction transaction = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {

			// Empieza Transaction
			transaction = session.beginTransaction();

			etiqueta.setFechaUltimaModificacion(SessionesGlobales.getDateSQL());
			session.update(etiqueta);

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

	public List<Etiqueta> getAllEtiquetas() {
		List<Etiqueta> result = null;
		Transaction transaction = null;
		String hql = "Select e from Etiqueta e " + "where e.activo = 1";
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {

			// Empieza Transaction
			transaction = session.beginTransaction();
			Query query = session.createQuery(hql);
			result = query.list();

			transaction.commit();

		} catch (Exception e) {
			System.err.println(e);
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}

		if (result == null) {
			result = new ArrayList<Etiqueta>();
		}
		return result;
	}

}

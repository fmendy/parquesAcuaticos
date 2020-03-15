package com.alvaro.parquesAcuaticos.business.dao.impl;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.alvaro.parquesAcuaticos.bean.Localidad;
import com.alvaro.parquesAcuaticos.business.dao.LocalidadDAO;
import com.alvaro.parquesAcuaticos.persistence.HibernateUtil;

public class LocalidadDAOImpl implements LocalidadDAO {

	public boolean localidadValidarNombre(Localidad localidad) {
		boolean result = false;
		Transaction transaction = null;
		String hql = "from Localidad l where l.nombre=:localidadNombre and l.provincia.idProvincia=:idProv and u.activo = 1";
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {

			// Empieza Transaction
			transaction = session.beginTransaction();

			Query query = session.createQuery(hql);
			query.setParameter("localidadNombre", localidad.getNombre());
			query.setParameter("idProv", localidad.getProvincia().getIdProvincia());
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

	public boolean aniadirLocalidad(Localidad localidad) {
		// TODO Auto-generated method stub
				boolean result = false;
				Transaction transaction = null;
				Session session = HibernateUtil.getSessionFactory().openSession();
				try {

					// Empieza Transaction
					transaction = session.beginTransaction();
					session.save(localidad);

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

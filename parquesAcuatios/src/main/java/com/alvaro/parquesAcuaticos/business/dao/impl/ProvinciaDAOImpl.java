package com.alvaro.parquesAcuaticos.business.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.alvaro.parquesAcuaticos.bean.Pais;
import com.alvaro.parquesAcuaticos.bean.Provincia;
import com.alvaro.parquesAcuaticos.business.dao.ProvinciaDAO;
import com.alvaro.parquesAcuaticos.persistence.HibernateUtil;

public class ProvinciaDAOImpl implements ProvinciaDAO{

	public List<Provincia> getProvinciasPorPais(Pais pais) {
		List<Provincia> result = new ArrayList<Provincia>();
		Transaction transaction = null;
		String hql = "from Provincia p where p.pais.idPais=:idenPais and p.activo = 1 order by p.nombre";
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {

			// Empieza Transaction
			transaction = session.beginTransaction();
			Query query = session.createQuery(hql);
			
			query.setParameter("idenPais", pais.getIdPais());
			System.out.println(query);
			System.out.println("Pais "+pais.getIdPais());
			if (query.list() != null) {
				result = query.list();
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

	public Provincia getProvinciaByID(Provincia provincia) {
		Provincia result = null;
		Transaction transaction = null;
		String hql = "Select pr from Provincia pr  left join pr.listLocalidad l on l.activo = 1 left join l.listParque par on par.activo = 1 "
				+ "where pr.idProvincia=:idenProvi and pr.activo = 1 ";
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {

			// Empieza Transaction
			transaction = session.beginTransaction();

			Query query = session.createQuery(hql);
			query.setParameter("idenProvi", provincia.getIdProvincia());
			if (query.list() != null) {
				result = (Provincia) query.list().get(0);
			}

			transaction.commit();

		} catch (Exception e) {
			System.err.println(e);
			if (transaction != null) {
				transaction.rollback();
			}
			result = null;
		} finally {
			session.close();
		}
		return result;
	}

}

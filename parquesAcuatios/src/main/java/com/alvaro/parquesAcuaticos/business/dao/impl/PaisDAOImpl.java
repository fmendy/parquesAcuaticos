package com.alvaro.parquesAcuaticos.business.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.alvaro.parquesAcuaticos.bean.Compania;
import com.alvaro.parquesAcuaticos.bean.Pais;
import com.alvaro.parquesAcuaticos.business.dao.PaisDAO;
import com.alvaro.parquesAcuaticos.persistence.HibernateUtil;

public class PaisDAOImpl implements PaisDAO {

	public List<Pais> listarPaises() {
		List<Pais> result = new ArrayList<Pais>();
		Transaction transaction = null;
		String hql = "Select p from Pais p "
				+ "where p.activo = 1";
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {

			// Empieza Transaction
			transaction = session.beginTransaction();
			Query query = session.createQuery(hql);
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

	public Pais getPaisByID(Pais pais) {
		Pais result = null;
		Transaction transaction = null;
		String hql = "Select p from Pais p "
				+ "left join p.listProvincia pr on pr.activo = 1 "
				+ "left join pr.listLocalidad l on l.activo = 1 "
				+ "left join l.listParque par on par.activo = 1 "
				+ "where p.idPais=:idenPais and p.activo = 1 ";
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {

			// Empieza Transaction
			transaction = session.beginTransaction();

			Query query = session.createQuery(hql);
			query.setParameter("idenPais", pais.getIdPais());
			if (query.list() != null) {
				result = (Pais) query.list().get(0);
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

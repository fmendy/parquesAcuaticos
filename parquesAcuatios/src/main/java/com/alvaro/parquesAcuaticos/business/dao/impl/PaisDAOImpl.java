package com.alvaro.parquesAcuaticos.business.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.alvaro.parquesAcuaticos.bean.Pais;
import com.alvaro.parquesAcuaticos.business.dao.PaisDAO;
import com.alvaro.parquesAcuaticos.persistence.HibernateUtil;

public class PaisDAOImpl implements PaisDAO {

	public List<Pais> listarPaises() {
		List<Pais> result = new ArrayList<Pais>();
		Transaction transaction = null;
		String hql = "from Pais p where p.activo = 1";
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

}

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
		System.out.println("pasa");
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

}

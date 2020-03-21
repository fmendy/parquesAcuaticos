package com.alvaro.parquesAcuaticos.business.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.alvaro.parquesAcuaticos.bean.Foto;
import com.alvaro.parquesAcuaticos.bean.Localidad;
import com.alvaro.parquesAcuaticos.bean.Parque;
import com.alvaro.parquesAcuaticos.business.dao.FotoDAO;
import com.alvaro.parquesAcuaticos.persistence.HibernateUtil;
import com.alvaro.parquesAcuaticos.session.SessionesGlobales;

public class FotoDAOImpl implements FotoDAO {

	public boolean guardarFoto(Foto foto) {
		boolean result = false;
		Transaction transaction = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {

			// Empieza Transaction
			transaction = session.beginTransaction();

			session.save(foto);
			foto.setActivo(true);
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

	public boolean actualizarFoto(Foto foto) {
		boolean result = false;
		Transaction transaction = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {

			// Empieza Transaction
			transaction = session.beginTransaction();

			foto.setFechaUltimaModificacion(SessionesGlobales.getDateSQL());
			session.update(foto);

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

	public boolean desactivarFotoPrincipal(Object object) {
		boolean result = true;

		List<Foto> listFotos = new ArrayList<Foto>();
		listFotos = getAllFotos(object);
		try {
			for (Foto f : listFotos) {
				if (f.isActivo() && f.getTipoFoto().getIdTipoFoto() == 1) {
					desactivarFoto(f);
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			return false;
		}

		return result;
	}

	public List<Foto> getAllFotos(Object object) {

		List<Foto> result = new ArrayList<Foto>();
		Transaction transaction = null;
		String hql = "from Foto f where f.activo = 1";
		if (object instanceof Parque) {
			hql = hql + " and f.parque.idParque = " + ((Parque) object).getIdParque();
		}
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {

			// Empieza Transaction
			transaction = session.beginTransaction();
			Query query = session.createQuery(hql);

			result = query.list();
			if (result == null) {
				result = new ArrayList<Foto>();
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

	private boolean desactivarFoto(Foto foto) {
		boolean result = false;
		Transaction transaction = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {

			// Empieza Transaction
			transaction = session.beginTransaction();

			foto.setFechaUltimaModificacion(SessionesGlobales.getDateSQL());
			foto.setActivo(false);
			System.out.println(foto.getIdFoto() +" parque: "+foto.getParque().getIdParque() );
			session.update(foto);

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

	public boolean desactivarFotoActivas(Object object) {
		boolean result = true;

		List<Foto> listFotos = new ArrayList<Foto>();
		
		//SI es un parque.
		if (object instanceof Parque) {
			Parque p = (Parque)object;
			for(int i=0;i<p.getListFoto().size();i++) {
				if (p.getListFoto().get(i)!= null && !p.getListFoto().get(i).isActivo()) {
					Foto f = p.getListFoto().get(i);
					f.setParque(p);
					listFotos.add(f);
				}
			}
		}
		try {
			for (Foto f : listFotos) {
					desactivarFoto(f);
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			return false;
		}
		return result;

	};

}

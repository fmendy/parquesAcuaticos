package com.alvaro.parquesAcuaticos.persistence;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import com.alvaro.parquesAcuaticos.bean.Compania;
import com.alvaro.parquesAcuaticos.bean.Localidad;
import com.alvaro.parquesAcuaticos.bean.Pais;
import com.alvaro.parquesAcuaticos.bean.Parque;
import com.alvaro.parquesAcuaticos.bean.Provincia;
import com.alvaro.parquesAcuaticos.bean.Usuario;
import com.fasterxml.classmate.AnnotationConfiguration;

public class HibernateUtil {

	private static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			try {
			Configuration configuration = new Configuration();

			Properties prop = new Properties();

			prop.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
			prop.put(Environment.URL, "jdbc:mysql://localhost:3306/parques_acuaticos?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
			prop.put(Environment.USER, "admin");
			prop.put(Environment.PASS, "admin");
			prop.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");
			prop.put(Environment.SHOW_SQL, "true");
			prop.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
			

			configuration.setProperties(prop);

			configuration.addAnnotatedClass(Usuario.class);
			configuration.addAnnotatedClass(Pais.class);
			configuration.addAnnotatedClass(Provincia.class);
			configuration.addAnnotatedClass(Localidad.class);
			configuration.addAnnotatedClass(Compania.class);
			configuration.addAnnotatedClass(Parque.class);
			
			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
					.applySettings(configuration.getProperties()).build();
			
			sessionFactory = configuration.buildSessionFactory(serviceRegistry);
			} catch (Exception e) {
				System.err.println(e);
			}

		}
		return sessionFactory;

	}
}

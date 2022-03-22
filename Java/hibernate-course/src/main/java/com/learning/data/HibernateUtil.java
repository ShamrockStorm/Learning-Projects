package com.learning.data;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.learning.data.entities.Acounts;
import com.learning.data.entities.Countries;
import com.learning.data.entities.Curencies;
import com.learning.data.entities.Users;

public class HibernateUtil {
	
	public static final SessionFactory sessionFactory = buildSessionFactory(); 
	
	private static SessionFactory buildSessionFactory () {
		try {
			Configuration configuration = new Configuration();
			configuration.addAnnotatedClass(Countries.class);
			configuration.addAnnotatedClass(Curencies.class);
			configuration.addAnnotatedClass(Acounts.class);
			configuration.addAnnotatedClass(Users.class);
			return configuration.buildSessionFactory(new StandardServiceRegistryBuilder().build());
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException("There was an error");
		}
	}
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

}


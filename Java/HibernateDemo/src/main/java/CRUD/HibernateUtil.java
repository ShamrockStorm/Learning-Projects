package CRUD;

import Entities.Account;
import Entities.Country;
import Entities.Curency;
import Entities.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	
	public static final SessionFactory sessionFactory = buildSessionFactory(); 
	
	private static SessionFactory buildSessionFactory () {
		try {
			Configuration configuration = new Configuration();
			configuration.addAnnotatedClass(Country.class);
			configuration.addAnnotatedClass(Curency.class);
			configuration.addAnnotatedClass(Account.class);
			configuration.addAnnotatedClass(User.class);
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


package com.learning.data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.*;

import com.learning.data.entities.Countries;
import com.learning.data.entities.Curencies;
import com.learning.data.entities.Users;
import com.learning.data.interfaces.NamableEntity;

import org.hibernate.Query;
import org.hibernate.Session;


public class Criteria {
	public static void main(String... args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		
		//EntityManagerFactory emf = Persistence.createEntityManagerFactory("");
		//EntityManager em = emf.createEntityManager();
		
		session.beginTransaction();
		
		CriteriaQuery<Object[]> cr = cb.createQuery(Object[].class);
		Root<Countries> root = cr.from(Countries.class);
		//ListJoin<Countries, Curencies> curency = root.join(Countries_.curencies);
		
		Root<Curencies> root1 = cr.from(Curencies.class);
		//cr.select(root);
		cr.multiselect(root.get("co_name"),root1.get("cu_name"));
		Query<Object[]> query = session.createQuery(cr);
		List<Object[]> results = query.getResultList();
		
		System.out.println("------------------------------------------------------------");
		for(Object[] r : results) {
			System.out.println(r[0]);
			System.out.println(r[1]);
		}
		System.out.println("------------------------------------------------------------");
		
		
		session.getTransaction().commit();
		session.close();
	}
}

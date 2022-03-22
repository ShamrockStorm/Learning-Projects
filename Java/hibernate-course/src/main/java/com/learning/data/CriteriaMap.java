package com.learning.data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.transform.Transformers;

import com.learning.data.entities.Countries;

public class CriteriaMap {
	public static void main(String... args) {
		
		//lista de map id + nume  (country)	incarcate prin criteria JPA
		
		Map <Long,String > hm = new HashMap<Long, String>();
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		session.beginTransaction();
		
		CriteriaQuery<Countries> cr = cb.createQuery(Countries.class);
		Root<Countries> root = cr.from(Countries.class);
		cr.multiselect(root.get("co_id"),root.get("co_name"));
		Query<Countries> query = session.createQuery(cr);
		
		List<Countries> resultList = query.getResultList();
		
		//Map<Long, String> resultList = (Map<Long, String>) query.getResultList();
		//hm = resultList;
		
		for(Countries co : resultList) {
			hm.put(co.getId(), co.getName());
		}
		
		System.out.println("------------------------------------------------------------");
		for(Map.Entry<Long, String> r : hm.entrySet()) {
			System.out.println(r.getKey()+"|"+r.getValue());
		}
		System.out.println("------------------------------------------------------------");
		
		session.getTransaction().commit();
		session.close();
	}
}

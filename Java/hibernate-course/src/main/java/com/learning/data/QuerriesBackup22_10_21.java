package com.learning.data;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.learning.data.entities.Users;


public class QuerriesBackup22_10_21 {
	public static void main(String... args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		Query query = session.createQuery("select u from Users u where u.us_type = 'Person' and country.co_id > '3'");
		List<Users> users = query.list();
		
		System.out.println("------------------------------------------------------------");
		for(Users u : users) {
			System.out.println(u.getName());
		}
		System.out.println("------------------------------------------------------------");
		
		Query query2 = session.createQuery("select u from Users u where u.us_type = 'Person' and acount.ac_Product_Type = 'Credit Card'");
		List<Users> users2 = query2.list();
		
		//  crearea unui pachet nou pt toti cei care nu folosesc toate valutele din tara de origine
		
		
		System.out.println("------------------------------------------------------------");
		for(Users u : users2) {
			System.out.println(u.getName());
		}
		System.out.println("------------------------------------------------------------");
		
		
		
		Query NewPackagePart1 = session.createQuery("select us.us_id, cu.cu_id from Users as us "
				+ "inner join us.country co "
				+ "left join co.curencies cu");
		
		Query NewPackagePart2 = session.createQuery("select us.us_id, cu.cu_id from Users as us "
				+ "inner join us.acount ac "
				+ "left join ac.curencies cu");
		//lista de map id + nume  (country)	incarcate prin criteria JPA
		
		List<Object[]> pkg1 = NewPackagePart1.list();
		List<Object[]> pkg2 = NewPackagePart2.list();
		
		System.out.println("------------------------------------------------------------");
		for(Object[] p : pkg1) {
			System.out.println(p[0]+"|"+p[1]);
		}
		System.out.println("------------------------------------------------------------");
		
		
		System.out.println("------------------------------------------------------------");
		for(Object[] p : pkg2) {
			System.out.println(p[0]+"|"+p[1]);
		}
		System.out.println("------------------------------------------------------------");
		
		List<Long> PackageUserId= new ArrayList<Long>();
		
		boolean ok;
		for(Object[]p1 : pkg1) {
			ok = true;
			for(Object[] p2 : pkg2) {
				System.out.println("____");
				System.out.println(p1[0]+"|"+p1[1]);
				System.out.println(p2[0]+"|"+p2[1]);
				System.out.println("____");
				if(p1[0].equals(p2[0]) && p1[1].equals(p2[1]))ok = false;
				System.out.println(ok);
			}
			if(ok == true) {
				PackageUserId.add((Long) p1[0]);
			}
		}
		
		System.out.println("------------------------------------------------------------");
		for(Long p : PackageUserId) {
			System.out.println(p);
		}
		System.out.println("------------------------------------------------------------");
		
		
		
		session.getTransaction().commit();
		session.close();
	}

}

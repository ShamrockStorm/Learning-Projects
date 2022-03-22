package com.learning.data;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;

import com.learning.data.entities.Acounts;
import com.learning.data.entities.Countries;
import com.learning.data.entities.Curencies;
import com.learning.data.entities.Users;

public class DisplayTables {
	public static void main(String... args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		Criteria criteria = session.createCriteria(Countries.class);
		List<Countries> list = criteria.list();
		
		
		Criteria criteria1 = session.createCriteria(Curencies.class);
		List<Curencies> list1 = criteria1.list();
		
		
		Criteria criteria2 = session.createCriteria(Users.class);
		List<Users> list2 = criteria2.list();
		
		
		Criteria criteria3 = session.createCriteria(Acounts.class);
		List<Acounts> list3 = criteria3.list();
		
		System.out.println("");
		System.out.println("_______________________tCountries___________________________");
		System.out.println("Id |   Name   | Capital");
		System.out.println("------------------------------------------------------------");
		for(Countries test: list) {
		    System.out.println(test.getId() + " | " + test.getName() + " | " + test.getCapital());
		}
		System.out.println("------------------------------------------------------------");
		
		System.out.println("");
		System.out.println("_______________________tCurencies___________________________");
		System.out.println(" Id | ISO |   Name   | Code");
		System.out.println("------------------------------------------------------------");
		for(Curencies test1: list1) {
		    System.out.println(test1.getId() + " | " + test1.getISO() + " | " + test1.getName() + " | " + test1.getCode());
		}
		System.out.println("------------------------------------------------------------");
		
		System.out.println("");
		System.out.println("_________________________tUsers_____________________________");
		System.out.println(" Id |  Type  |   Name");
		System.out.println("------------------------------------------------------------");
		for(Users test2: list2) {
		    System.out.println(test2.getId() + " | " + test2.getType() + " | " + test2.getName());
		}
		System.out.println("------------------------------------------------------------");
		
		System.out.println("");
		System.out.println("________________________tAcounts____________________________");
		System.out.println(" Id | Product Type |   Date   | User Id");
		System.out.println("------------------------------------------------------------");
		for(Acounts test3: list3) {
		    System.out.println(test3.getId() + " | " + test3.getProdType() + " | " + test3.getDate() + " | " + test3.getUser().getId());
		}
		System.out.println("------------------------------------------------------------");
		
		
		session.getTransaction().commit();
		session.close();
		
		//change sql id_type to number and java id type to long
	
	}

}

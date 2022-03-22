package com.learning.data;


import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;

import com.learning.data.entities.Acounts;
import com.learning.data.entities.Countries;
import com.learning.data.entities.Curencies;
import com.learning.data.entities.Users;


public class Application {
	
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		Countries co1 = new Countries(); 
		co1.setName("Romania"); 
		co1.setCapital("Bucharest");
		System.out.println("After creation0 co");
		System.out.print("------------------------------------------------------------");
		System.out.print(co1.getId());
		System.out.println("------------------------------------------------------------");
		
		Countries co2 = new Countries();
		co2.setName("Bulgaria");
		co2.setCapital("Sofia");
		
		Countries co3 = new Countries();
		co3.setName("France");
		co3.setCapital("Paris");
		
		Countries co4 = new Countries();
		co4.setName("Cuba");
		co4.setCapital("Havana");
		
		
		Curencies cu1 = new Curencies();
		cu1.setName("Romanian leu");
		cu1.setCode("RON");
		cu1.setISO(946);
		
		Curencies cu2 = new Curencies();
		cu2.setName("Bulgarian lev");
		cu2.setCode("BGN");
		cu2.setISO(975);
		
		Curencies cu3 = new Curencies();
		cu3.setName("Euro");
		cu3.setCode("EUR");
		cu3.setISO(978);
		
		Curencies cu4 = new Curencies();
		cu4.setName("Cuban Peso");
		cu4.setCode("CUP");
		cu4.setISO(192);
		
		Curencies cu5 = new Curencies();
		cu5.setName("Convertable Peso");
		cu5.setCode("CUC");
		cu5.setISO(931);
		
		Users us1 = new Users();
		us1.setType("Person");
		us1.setName("Remus Pereria");
		
		System.out.println("After creation0");
		System.out.print("------------------------------------------------------------");
		System.out.print(us1.getId());
		System.out.println("------------------------------------------------------------");
		
		Users us2 = new Users();
		us2.setType("Person");
		us2.setName("Elvira Bachchan");
		
		Users us3 = new Users();
		us3.setType("Company");
		us3.setName("Favero inc");
		
		System.out.println("After creation1");
		System.out.print("------------------------------------------------------------");
		System.out.print(us1.getId());
		System.out.println("------------------------------------------------------------");
		
		
		Acounts ac1 = new Acounts(new Date());
		ac1.setUser(us1);
		ac1.setProdType("Debit Card");
		
		Acounts ac2 = new Acounts(new Date());
		ac2.setUser(us2);
		ac2.setProdType("Credit Card");
		
		Acounts ac3 = new Acounts(new Date());
		ac3.setUser(us3);
		ac3.setProdType("Credit Card");
		
		System.out.println("After creation2");
		System.out.print("------------------------------------------------------------");
		System.out.print(us1.getId());
		System.out.println("------------------------------------------------------------");
		
		co4.getUsers().add(us1);
		co3.getUsers().add(us2);
		co3.getUsers().add(us3);
		
		co1.getCurencies().add(cu1);
		co2.getCurencies().add(cu2);
		co3.getCurencies().add(cu3);
		co4.getCurencies().add(cu4);
		co4.getCurencies().add(cu5);
		
		System.out.println("After curency mapping");
		System.out.print("------------------------------------------------------------");
		System.out.print(us1.getId());
		System.out.println("------------------------------------------------------------");
		
		ac1.getCurencies().add(cu4);
		ac1.getCurencies().add(cu5);
		ac2.getCurencies().add(cu3);
		ac3.getCurencies().add(cu3);
		ac3.getCurencies().add(cu5);
		
		System.out.println("After currency gets mapped to Acount");
		System.out.print("------------------------------------------------------------");
		System.out.print(us1.getId());
		System.out.println("------------------------------------------------------------");
		
		cu3.getAccounts().add(ac2);
		cu3.getAccounts().add(ac3);
		cu4.getAccounts().add(ac1);
		cu5.getAccounts().add(ac1);
		cu5.getAccounts().add(ac3);
		
		System.out.println("End value");
		System.out.print("------------------------------------------------------------");
		System.out.print(us1.getId());
		System.out.println("------------------------------------------------------------");
		
		session.save(us1);
		
		session.save(ac1);
		session.save(ac2);
		session.save(ac3);
		
		session.save(co1);
		session.save(co2);
		session.save(co3);
		session.save(co4);
		
		session.getTransaction().commit();
		
		session.close();
	}

}

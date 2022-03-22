package com.learning.data;

import java.util.DoubleSummaryStatistics;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Query;
import org.hibernate.Session;

import com.learning.data.entities.Acounts;
import com.learning.data.entities.Countries;
import com.learning.data.entities.Curencies;
import com.learning.data.entities.Users;

public class Streams {
	public static void main(String... args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		session.beginTransaction();
		
		CriteriaQuery<Countries> CountriesCriteria = builder.createQuery(Countries.class);
		Root<Countries> CountriesRoot = CountriesCriteria.from(Countries.class);
		CountriesCriteria.select(CountriesRoot);
		Query<Countries> CountriesQuery = session.createQuery(CountriesCriteria);
		List<Countries> CountriesList = CountriesQuery.getResultList();
		
		CriteriaQuery<Curencies> CurenciesCriteria = builder.createQuery(Curencies.class);
		Root<Curencies> CurenciesRoot = CurenciesCriteria.from(Curencies.class);
		CurenciesCriteria.select(CurenciesRoot);
		Query<Curencies> CurenciesQuery = session.createQuery(CurenciesCriteria);
		List<Curencies> CurenciesList = CurenciesQuery.getResultList();
		
		CriteriaQuery<Users> UsersCriteria = builder.createQuery(Users.class);
		Root<Users> UsersRoot = UsersCriteria.from(Users.class);
		UsersCriteria.select(UsersRoot);
		Query<Users> UsersQuery = session.createQuery(UsersCriteria);
		List<Users> UsersList = UsersQuery.getResultList();
		
		CriteriaQuery<Acounts> AcountsCriteria = builder.createQuery(Acounts.class);
		Root<Acounts> AcountsRoot = AcountsCriteria.from(Acounts.class);
		AcountsCriteria.select(AcountsRoot);
		Query<Acounts> AcountsQuery = session.createQuery(AcountsCriteria);
		List<Acounts> AcountsList = AcountsQuery.getResultList();
		
		Map<Boolean,List<Curencies>> CurenciesMap = CurenciesList.stream().collect(Collectors.partitioningBy(element -> element.getISO() > 900));
		
		for(Map.Entry<Boolean,List<Curencies>> entry : CurenciesMap.entrySet()) {
			System.out.println(entry.getKey());
			for(Curencies curency : entry.getValue()) {
				System.out.println(curency.getCode()+"|"+curency.getISO());
			}
		}
		
		Optional<Integer> numberOfCreditCards = AcountsList.stream().map(element -> {
			if(element.getProdType().equals("Credit Card")) return 1;
			else return 0;
		}).reduce((a,b) -> a+b);
		
		Optional<Integer> numberOfDebitCards = AcountsList.stream().map(element -> {
			if(element.getProdType().equals("Debit Card")) return 1;
			else return 0;
		}).reduce((a,b) -> a+b);
		
		System.out.println("Number of Credit cards: "+numberOfCreditCards.get());
		System.out.println("Number of Debit cards: "+numberOfDebitCards.get());
		
		double AverageISO = CurenciesList.stream().collect(Collectors.averagingDouble(Curencies::getISO));
		
		System.out.println("The average ISO of all available curencies is: "+AverageISO);
		
		DoubleSummaryStatistics ISOstatistics = CurenciesList.parallelStream().collect(Collectors.summarizingDouble(Curencies::getISO));
		
		System.out.println("The Curency ISO statistics are:"+ISOstatistics.toString());
				
		List<Users> UsersSortedAlphabeticly = UsersList.stream().sorted((Users user1, Users user2) -> user1.getName().compareTo(user2.getName())).collect(Collectors.toList());
		
		List<Users> UsersSortedReverseAlphabeticly = UsersList.stream().sorted((Users user2, Users user1) -> user1.getName().compareTo(user2.getName())).collect(Collectors.toList());
		
		for(Users user : UsersSortedAlphabeticly)System.out.println(user.getName());
		System.out.println("------------------------------------------------------------");
		for(Users user : UsersSortedReverseAlphabeticly)System.out.println(user.getName());
		
		session.getTransaction().commit();
		session.close();
	}
}

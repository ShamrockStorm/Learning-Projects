package com.project.jsf.beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.*;


@ManagedBean(name = "student2", eager = true)
@RequestScoped
public class Student {
	private String firstName;
	private String lastName;
	private String country;
	private String favouriteLanguage;
	private String[] knownProgrammingLanguages;
	List<String> countryOptions;
	
	public Student() {
		firstName = "John";
		lastName = "Doe";
		favouriteLanguage = "PHP";
		
		countryOptions = new ArrayList<>();
		
		countryOptions.add("Brazil");
		countryOptions.add("France");
		countryOptions.add("Germany");
		countryOptions.add("India");
		countryOptions.add("Turkey");
		countryOptions.add("United Kingdom");
		countryOptions.add("Unnited States");
		countryOptions.add("Romania");
	}

	
	public List<String> getCountryOptions() {
		return countryOptions;
	}
	
	public void setCountryOptions(List<String> countryOptions) {
		this.countryOptions = countryOptions;
	}


	public String getFirstName() {
		System.out.println("First Name get");
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
		System.out.println("First Name set");
	}

	public String getLastName() {
		System.out.println("Last Name get");
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
		System.out.println("Last Name set");
	}

	public String getCountry() {
		System.out.println("Country get");
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
		System.out.println("Country set");
	}


	public String getFavouriteLanguage() {
		return favouriteLanguage;
	}


	public void setFavouriteLanguage(String favouriteLanguage) {
		this.favouriteLanguage = favouriteLanguage;
	}


	public String[] getKnownProgrammingLanguages() {
		return knownProgrammingLanguages;
	}


	public void setKnownProgrammingLanguages(String[] knownProgrammingLanguages) {
		this.knownProgrammingLanguages = knownProgrammingLanguages;
	}
	
	
}

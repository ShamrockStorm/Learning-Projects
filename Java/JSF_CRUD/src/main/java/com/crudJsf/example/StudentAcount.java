package com.crudJsf.example;

import java.io.Serializable;

import org.hibernate.Session;

import com.crudJsf.persistance.HibernateUtil;
import com.crudJsf.persistance.StudentAcountEntity;

public class StudentAcount implements Serializable{
	private static final long serialVersionUID = 2L;
	
	private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String hashSalt;
    private String hashedPassword;
    private StudentAcountEntity studentAcountEntity;
    
    public StudentAcount() {}
    public StudentAcount(String firstName, String lastName, String eMail, String hashSalt, String hashedPassword) {
    	Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = eMail;
		session.getTransaction().commit();
		session.close();
    }
    
    public StudentAcount(StudentAcountEntity studentAcountEntity) {
    	this.id = studentAcountEntity.getId();
    	this.firstName = studentAcountEntity.getFirstName();
    	this.lastName = studentAcountEntity.getLastName();
    	this.email = studentAcountEntity.getEmail();
    	this.hashSalt = studentAcountEntity.getHashSalt();
    	this.hashedPassword = studentAcountEntity.getHashedPassword();
    }
    
    public Integer getId() {
		return id;
	}
    public void setId(Integer id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getHashSalt() {
		return hashSalt;
	}
	public void setHashSalt(String hashSalt) {
		this.hashSalt = hashSalt;
	}
	public String getHashedPassword() {
		return hashedPassword;
	}
	public void setHashedPassword(String hashedPassword) {
		this.hashedPassword = hashedPassword;
	}
	
	@Override 
	public StudentAcount clone() {
		return new StudentAcount(firstName, lastName, email, hashSalt, hashedPassword);
	}
	
	public void restore (StudentAcount studentAcount) {
		this.id = studentAcount.getId();
        this.firstName = studentAcount.getFirstName();
        this.lastName = studentAcount.getLastName();
        this.email = studentAcount.getEmail();
        this.hashSalt = studentAcount.getHashSalt();
        this.hashedPassword = studentAcount.getHashedPassword();
	}
	
	
}

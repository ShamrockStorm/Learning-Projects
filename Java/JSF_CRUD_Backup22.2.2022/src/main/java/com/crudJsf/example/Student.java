package com.crudJsf.example;

import java.io.Serializable;

import org.hibernate.Session;

import com.crudJsf.persistance.HibernateUtil;
import com.crudJsf.persistance.StudentEntity;

public class Student implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private StudentEntity studentEntity;
    
    public Student() {}
    public Student(String firstName, String lastName, String eMail) {
    	Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
    	//studentEntity = new StudentEntity();
    	//this.id = studentEntity.getId();
        this.firstName = firstName;
        //studentEntity.setFirstName(firstName);
        this.lastName = lastName;
        //studentEntity.setLastName(lastName);
        this.email = eMail;
        //studentEntity.setEmail(eMail);
        
        //session.save(studentEntity);
        session.getTransaction().commit();
		session.close();
    }
  
    public Student(StudentEntity studentEntity) {
    	this.id = studentEntity.getId();
    	this.firstName = studentEntity.getFirstName();
    	this.lastName = studentEntity.getLastName();
    	this.email = studentEntity.getEmail();
    	this.studentEntity = studentEntity;
    }
    
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public String getEmail() { return email; }
    public void setEmail(String eMail) { this.email = eMail; }
    public StudentEntity getStudentEntity() {return studentEntity;}
    public void setStudentEntity(StudentEntity studentEntity) {this.studentEntity = studentEntity;}
    
    @Override
    public Student clone() {
        return new Student(firstName, lastName, email);
    }
    
    public void restore(Student student) {
        this.id = student.getId();
        this.firstName = student.getFirstName();
        this.lastName = student.getLastName();
        this.email = student.getEmail();
    }
}

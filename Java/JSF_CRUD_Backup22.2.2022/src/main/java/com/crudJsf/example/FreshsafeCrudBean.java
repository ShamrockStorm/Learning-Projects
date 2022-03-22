package com.crudJsf.example;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.crudJsf.persistance.HibernateUtil;
import com.crudJsf.persistance.StudentEntity;
import com.crudJsf.util.CommonUtils;


@ManagedBean(name = "freshsafeCrudBeanA", eager = true)
@SessionScoped
public class FreshsafeCrudBean implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private List<Student> list;
    private Student item = new Student();
    private Student beforeEditItem = null;
    private boolean edit;
    
    @ManagedProperty(value="#{commonUtils}")
    private CommonUtils util;
    public void setUtil(CommonUtils util) {
        this.util = util;
    }
    
    @PostConstruct
    public void init() {
    	SessionFactory sessionfactory = this.buildSessionFactory();
    	Session session = sessionfactory.openSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		session.beginTransaction();
		
        list = new ArrayList<Student>();
        
        CriteriaQuery<StudentEntity> StudentCriteria = builder.createQuery(StudentEntity.class);
		Root<StudentEntity> StudentRoot = StudentCriteria.from(StudentEntity.class);
		StudentCriteria.select(StudentRoot);
		Query<StudentEntity> StudentQuery = session.createQuery(StudentCriteria);
		List<StudentEntity> StudentList = StudentQuery.getResultList();
		
		for(StudentEntity studentEntity : StudentList) {
			Student student = new Student(studentEntity);
			list.add(student);
		}
		
		session.getTransaction().commit();
		session.close();
    }
    
    public void add() {
        // DAO save the add
        Session session = HibernateUtil.getSessionFactory().openSession();
		//CriteriaBuilder builder = session.getCriteriaBuilder();
		session.beginTransaction();
		
        list.add(item);
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setFirstName(item.getFirstName());
        studentEntity.setLastName(item.getLastName());
        studentEntity.setEmail(item.getEmail());
        
        session.save(studentEntity);
        
        session.getTransaction().commit();
		session.close();
		
        item = new Student();
    
        util.redirectWithGet();
        
        
    }
    
    public void resetAdd() {
        item = new Student();
    
        util.redirectWithGet();
    }
    
    public void edit(Student item) {
        beforeEditItem = item.clone();
        this.item = item;
        edit = true;
    
        util.redirectWithGet();
    }
    
    public void cancelEdit() {
        this.item.restore(beforeEditItem);
        this.item = new Student();
        edit = false;
    
        util.redirectWithGet();
    }
    
    public void saveEdit() {
        // DAO save the edit
        this.item = new Student();
        edit = false;
    
        util.redirectWithGet();
    }
    
    public void delete(Student item) throws IOException {
        // DAO save the delete
        list.remove(item);
    
        util.redirectWithGet();
    }
    
    public List<Student> getList() {
        return list;
    }
    
    public Student getItem() {
        return this.item;
    }
    
    public boolean isEdit() {
        return this.edit;
    }
    
    private static SessionFactory buildSessionFactory () {
		try {
			Configuration configuration = new Configuration();
			configuration.addAnnotatedClass(StudentEntity.class);
			return configuration.buildSessionFactory(new StandardServiceRegistryBuilder().build());
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException("There was an error");
		}
	}
    
} 
//Autentificare / login , dataTable, deschidere Add in alta pagina

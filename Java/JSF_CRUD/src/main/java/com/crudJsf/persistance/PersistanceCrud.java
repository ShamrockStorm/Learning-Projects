package com.crudJsf.persistance;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.crudJsf.example.Student;
import com.crudJsf.example.StudentAcount;

public class PersistanceCrud {
	
	public List getStudentsList() {
		SessionFactory sessionfactory = HibernateUtil.getSessionFactory();
    	Session session = sessionfactory.openSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		session.beginTransaction();
		
        List list = new ArrayList<Student>();
        
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
		
		return list;
	}
	
	public List getStudentAcountsList() {
		SessionFactory sessionfactory = HibernateUtil.getSessionFactory();
    	Session session = sessionfactory.openSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		session.beginTransaction();
		
        List list = new ArrayList<StudentAcount>();
        
        CriteriaQuery<StudentAcountEntity> StudentAcountCriteria = builder.createQuery(StudentAcountEntity.class);
		Root<StudentAcountEntity> StudentAcountRoot = StudentAcountCriteria.from(StudentAcountEntity.class);
		StudentAcountCriteria.select(StudentAcountRoot);
		Query<StudentAcountEntity> StudentAcountQuery = session.createQuery(StudentAcountCriteria);
		List<StudentAcountEntity> StudentAcountList = StudentAcountQuery.getResultList();
		
		for(StudentAcountEntity studentAcountEntity : StudentAcountList) {
			StudentAcount studentAcount = new StudentAcount(studentAcountEntity);
			list.add(studentAcount);
		}
		
		session.getTransaction().commit();
		session.close();
		
		return list;
	}
	
	public void addStudent(Student student) {
		SessionFactory sessionfactory = HibernateUtil.getSessionFactory();
    	Session session = sessionfactory.openSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		session.beginTransaction();
		
		StudentEntity studentEntity = new StudentEntity(student);
		
		session.save(studentEntity);
		session.getTransaction().commit();
		session.close();
		
		student.setId(studentEntity.getId());
	}
	
	public void addStudentAcount(StudentAcount studentAcount) {
		SessionFactory sessionfactory = HibernateUtil.getSessionFactory();
    	Session session = sessionfactory.openSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		session.beginTransaction();
		
		StudentAcountEntity studentAcountEntity = new StudentAcountEntity(studentAcount);
		
		session.save(studentAcountEntity);
		session.getTransaction().commit();
		session.close();
		
		studentAcount.setId(studentAcountEntity.getId());
	}
	
	public static StudentAcountEntity getStudentAcount(StudentAcount studentAcount) {
		SessionFactory sessionfactory = HibernateUtil.getSessionFactory();
    	Session session = sessionfactory.openSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		session.beginTransaction();
		
		CriteriaQuery<StudentAcountEntity> StudentAcountCriteria = builder.createQuery(StudentAcountEntity.class);
		Root<StudentAcountEntity> StudentAcountRoot = StudentAcountCriteria.from(StudentAcountEntity.class);
		StudentAcountCriteria.select(StudentAcountRoot).where(builder.equal(StudentAcountRoot.get("email"),studentAcount.getEmail()));
		Query<StudentAcountEntity> StudentAcountQuery = session.createQuery(StudentAcountCriteria);
		List<StudentAcountEntity> studentAcountList = StudentAcountQuery.getResultList();
		StudentAcountEntity studentAcountEntity = studentAcountList.get(0);
		return studentAcountEntity;
		
	}
	
	public void updateStudent(Student student) {
		SessionFactory sessionfactory = HibernateUtil.getSessionFactory();
    	Session session = sessionfactory.openSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		session.beginTransaction();
		
		String updateString = "Update StudentEntity s set s.firstName = '"+student.getFirstName()+"', s.lastName = '"+student.getLastName()+
				"' , s.email = '"+student.getEmail()+"' where s.id = "+student.getId();
		
		Query updateQuery =session.createQuery(updateString);
		
		updateQuery.executeUpdate();
		
		session.getTransaction().commit();
	    session.clear();
	    session.close();
	}
	
	public void deleteStudent(Student student) {
		SessionFactory sessionfactory = HibernateUtil.getSessionFactory();
    	Session session = sessionfactory.openSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		session.beginTransaction();
		
		String deleteString = "delete from StudentEntity s where s.id = "+student.getId();
		
		Query deleteQuery =session.createQuery(deleteString);
		
		deleteQuery.executeUpdate();
		
		
		session.getTransaction().commit();
	    session.clear();
	    session.close();
	}

}

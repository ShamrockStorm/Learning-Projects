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

package com.crudJsf.example;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.crudJsf.persistance.PersistanceCrud;
import com.crudJsf.persistance.StudentEntity;
import com.crudJsf.util.CommonUtils;

@ManagedBean(name = "studentBean", eager = true)
@SessionScoped
public class StudentManagerBean {
	//implements Serializable
	//private static final long serialVersionUID = 1L;
	
	 private List<Student> list;
	 private Student item = new Student();
	 private Student beforeEditItem = null;
	 private boolean edit;
	 private boolean firstLoad = true;
	 
	 public StudentManagerBean() {
		 
	 }

	public List<Student> getList() {
		return list;
	}

	public void setList(List<Student> list) {
		this.list = list;
	}

	public Student getItem() {
		return item;
	}

	public void setItem(Student item) {
		this.item = item;
	}

	public Student getBeforeEditItem() {
		return beforeEditItem;
	}

	public void setBeforeEditItem(Student beforeEditItem) {
		this.beforeEditItem = beforeEditItem;
	}

	public boolean isEdit() {
		return edit;
	}

	public void setEdit(boolean edit) {
		this.edit = edit;
	}
	 
	 public boolean isFirstLoad() {
		return firstLoad;
	}

	public void setFirstLoad(boolean firstLoad) {
		this.firstLoad = firstLoad;
	}

	@ManagedProperty(value="#{commonUtils}")
	    private CommonUtils util;
	    public void setUtil(CommonUtils util) {
	        this.util = util;
	    }
	    
	    @PostConstruct
	    public void init() {
	    	
	    	PersistanceCrud persistanceCrud = new PersistanceCrud();
	    	list = persistanceCrud.getStudentsList();
	    	firstLoad = false;
	    	
	    }
	    
	    public void add() {
	    	PersistanceCrud persistanceCrud = new PersistanceCrud();
	    	persistanceCrud.addStudent(item);
	    	list.add(item);
	    	item = new Student();
	    	util.redirectWithGet();
	    }
	    
	    public void resetAdd() {
	        item = new Student();
	    
	        util.redirectWithGet();
	    }
	    
	    public void editStudent(Student item) {
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
	    
	    //create persistance Update si Delete
	    
	    public void saveEdit() {
	        // DAO save the edit
	    	PersistanceCrud persistanceCrud = new PersistanceCrud();
	    	persistanceCrud.updateStudent(item);
	        this.item = new Student();
	        edit = false;
	    
	        util.redirectWithGet();
	    }
	    
	    public void delete(Student item) throws IOException {
	        // DAO save the delete
	    	PersistanceCrud persistanceCrud = new PersistanceCrud();
	    	persistanceCrud.deleteStudent(item);
	        list.remove(item);
	    
	        util.redirectWithGet();
	    }
	 
}

package com.crudJsf.example;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import com.crudJsf.persistance.PersistanceCrud;
import com.crudJsf.util.CommonUtils;

@ManagedBean(name = "studentAcountBean", eager = true)
@SessionScoped
public class StudentAcountManagerBean {
		private List<StudentAcount> list;
		private boolean firstLoad = true;
		
		public StudentAcountManagerBean() {
			
		}
		public List<StudentAcount> getList() {
			return list;
		}
		public void setList(List<StudentAcount> list) {
			this.list = list;
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
	    	list = persistanceCrud.getStudentAcountsList();
	    	firstLoad = false;
	    	
	    }
		
		
}

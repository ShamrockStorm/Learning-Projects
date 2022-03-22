package com.crudJsf.example;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.crudJsf.persistance.PersistanceCrud;
import com.crudJsf.persistance.StudentAcountEntity;
import com.crudJsf.security.SecurityService;

@ManagedBean(name = "logInBean", eager = true)
@SessionScoped
public class LogInManagerBean {
	StudentAcount logedInStudentAcount = new StudentAcount();
	StudentAcount enteredStudentAcount = new StudentAcount();
	String tempPass1;
	String tempPass2;
	
	public LogInManagerBean() {
	
	}
	
	public StudentAcount getLogedInStudentAcount() {
		return this.logedInStudentAcount;
	}
	
	public void setLogedInStudentAcount(StudentAcount studentAcount) {
		this.logedInStudentAcount = studentAcount;
	}
	
	public StudentAcount getEnteredStudentAcount() {
		return this.enteredStudentAcount;
	}
	
	public void setEnteredStudentAcount(StudentAcount studentAcount) {
		this.enteredStudentAcount = studentAcount;
	}
	
	public String getTempPass1() {
		return this.tempPass1;
	}
	
	public void setTempPass1(String tempPass) {
		this.tempPass1 = tempPass;
	}
	
	public String getTempPass2() {
		return this.tempPass2;
	}
	
	public void setTempPass2(String tempPass) {
		this.tempPass2 = tempPass;
	}
	
	public void signUp() throws NoSuchAlgorithmException, InvalidKeySpecException, IOException {
		if(this.enteredStudentAcount.getFirstName() != "" &&
				this.enteredStudentAcount.getLastName() != "" &&
				this.enteredStudentAcount.getEmail() != "" &&
				this.tempPass1 != "" &&
				this.tempPass1.equals(this.tempPass2)) {
			byte[] salt = SecurityService.generateNewSalt();
			byte[] hashedPassword = SecurityService.hashPassword(tempPass1, salt);
			this.enteredStudentAcount.setHashSalt(new String(salt, StandardCharsets. ISO_8859_1));
			this.enteredStudentAcount.setHashedPassword(new String(hashedPassword, StandardCharsets. ISO_8859_1));
			
			PersistanceCrud persistanceCrud = new PersistanceCrud();
	    	persistanceCrud.addStudentAcount(this.enteredStudentAcount);
	    	this.enteredStudentAcount = new StudentAcount();
	    	//FacesContext.getCurrentInstance().getExternalContext().redirect("/StudentLogIn.xhtml");
	    	FacesContext.getCurrentInstance().getApplication().getNavigationHandler().handleNavigation(FacesContext.getCurrentInstance(), null, "StudentLogIn.xhtml");
		}
			
	}
	
	public void logIn() throws NoSuchAlgorithmException, InvalidKeySpecException {
		StudentAcountEntity studentAcountEntity = PersistanceCrud.getStudentAcount(this.enteredStudentAcount);
		byte[] salt = studentAcountEntity.getHashSalt().getBytes(StandardCharsets.ISO_8859_1);
		byte[] hashedPassword = studentAcountEntity.getHashedPassword().getBytes(StandardCharsets.ISO_8859_1);
		
		if(Arrays.equals(SecurityService.hashPassword(tempPass1, salt) , hashedPassword))
			FacesContext.getCurrentInstance().getApplication().getNavigationHandler().handleNavigation(FacesContext.getCurrentInstance(), null, "StudentAcountsDisplay.xhtml");
		
	}
}

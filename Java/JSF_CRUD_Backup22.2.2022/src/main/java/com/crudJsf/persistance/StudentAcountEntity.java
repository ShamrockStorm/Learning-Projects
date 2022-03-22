package com.crudJsf.persistance;

import javax.persistence.*;

import com.crudJsf.example.StudentAcount;


@Entity
@Table(name = "tStudentAcounts")
public class StudentAcountEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "Student_acount_sequence") 
	@SequenceGenerator (name= "Student_acount_sequence", sequenceName = "seq_id_StudentAcounts", allocationSize = 1,initialValue = 1)
	@Column(name = "StudentId" , nullable = false)
	Integer id;
	@Column(name ="StudentFirstName")
	String firstName;
	@Column(name ="StudentLastName")
	String lastName;
	@Column(name ="StudentEmail")
	String email;
	@Column(name="HashSalt")
	String hashSalt;
	@Column(name="HashedPassword")
	String hashedPassword;
	
	public StudentAcountEntity() {
		
	}
	
	public StudentAcountEntity(StudentAcount studentAcount) {
		this.firstName = studentAcount.getFirstName();
		this.lastName = studentAcount.getLastName();
		this.email = studentAcount.getEmail();
		this.hashSalt = studentAcount.getHashSalt();
		this.hashedPassword = studentAcount.getHashedPassword();
	}
	
	public Integer getId() {
		return id;
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
	
}

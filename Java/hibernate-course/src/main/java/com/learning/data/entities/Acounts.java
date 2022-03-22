package com.learning.data.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tAcounts")

public class Acounts {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "ID_sequence") 
	@SequenceGenerator (name= "ID_sequence", sequenceName = "seq_id_Acounts", allocationSize = 1,initialValue = 300)
	@Column(name = "AC_ID" , nullable = false)
	private long ac_id;
	
	
	@ManyToMany(cascade = CascadeType.ALL, mappedBy = "acounts")
	private Set<Curencies> curencies = new HashSet<Curencies>();
	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name ="AC_US_ID")
	public Users user;
	
	
	@Column(name = "AC_PRODUCT_TYPE")
	private String ac_Product_Type;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "AC_DATE_CREATED")
	private Date ac_Date_Created;
	
	
	public Acounts() {
		System.out.println(this.ac_id);
		System.out.println("------------------------------------------------------------");
	}
	
	public Acounts(Date date) {
		this.ac_Date_Created = date;
		System.out.println(this.ac_id);
		System.out.println("------------------------------------------------------------");
	}
	
	
	public long getId() {    
	    return ac_id;    
	}    
	public void setId(long id) {    
	    this.ac_id = id;    
	} 
	
	public String getProdType() {    
	    return ac_Product_Type;    
	}    
	public void setProdType(String pt) {    
	    this.ac_Product_Type = pt;    
	} 
	
	public Date getDate() {    
	    return ac_Date_Created;    
	}    
	public void setDate(Date date) {    
	    this.ac_Date_Created = date;    
	} 
	
	public Users getUser() {
		return this.user;
	}
	
	public void setUser(Users user) {
		this.user = user;
	}
	
	public Set<Curencies>getCurencies(){
		return curencies;
	}
	
}

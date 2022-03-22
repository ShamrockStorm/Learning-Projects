package com.learning.data.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import com.learning.data.interfaces.NamableEntity;


@Entity
@Table(name = "tCurencies")

public class Curencies implements NamableEntity{
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "ID_sequence") 
	@SequenceGenerator (name= "ID_sequence", sequenceName = "seq_id_Curencies", allocationSize = 1,initialValue = 100)
	@Column(name = "CU_ID" , nullable = false)
	private long cu_id;
	
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="tAcounts_TCurencies", joinColumns = @JoinColumn(name = "CU_ID"),
			inverseJoinColumns = @JoinColumn(name = "AC_ID"))
	private Set<Acounts> acounts = new HashSet<Acounts>();
	
	
	
	@ManyToOne
	@JoinColumn(name = "CU_COUNTRY_OF_ORIGIN_ID")
	private Countries country;
	
	@Column(name = "CU_ISO")
	private long cu_ISO;
	
	@Column(name = "CU_NAME")
	private String cu_name;
	
	@Column(name = "CU_CODE")
	private String cu_code;
	
	public Curencies() {
		System.out.println(this.cu_id);
		System.out.println("------------------------------------------------------------");
	}
	
	public long getId() {    
	    return cu_id;    
	}    
	public void setId(long id) {    
	    this.cu_id = id;    
	} 
	
	public long getISO() {    
	    return cu_ISO;    
	}    
	public void setISO(long ISO) {    
	    this.cu_ISO = ISO;    
	} 
	
	public String getName() {    
	    return cu_name;    
	}    
	public void setName(String name) {    
	    this.cu_name = name;    
	}    
	
	public String getCode() {    
	    return cu_code;    
	}    
	public void setCode(String code) {    
	    this.cu_code = code;    
	} 
	
	public void setCountry(Countries co) {
		this.country = co;
	}
	
	public Countries getCountry() {
		return country;
	}
	
	public Set<Acounts >getAccounts(){
		return acounts;
	}
	
}

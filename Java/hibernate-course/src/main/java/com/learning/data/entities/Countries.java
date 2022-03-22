package com.learning.data.entities;

import com.learning.data.*;
import com.learning.data.interfaces.NamableEntity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;


@Entity
@Table(name = "tCountries")
public class Countries implements NamableEntity{
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "ID_sequence") 
	@SequenceGenerator (name= "ID_sequence", sequenceName = "seq_id_Countries",allocationSize = 1,initialValue = 1)
	@Column(name = "CO_ID" ,nullable = false)
	private long co_id;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "US_CO_ID")
	List<Users> users = new ArrayList<Users>();
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "CU_COUNTRY_OF_ORIGIN_ID")
	List<Curencies> curencies = new ArrayList<Curencies>();
	
	@Column(name = "CO_NAME")
	private String co_name;
	
	@Column(name = "CO_CAPITAL")
	private String co_capital;
	
	public Countries() {
		System.out.println(this.co_id);
		System.out.println("------------------------------------------------------------");
	}
	public Countries(long id, String name) {
		this.co_id = id;
		this.co_name = name;
	}
	/*
	public Countries(long id, String name,String Capital, List<Curencies> curencies, List<Users> users) {
		this.co_id = id;
		this.co_name = name;
		this.co_capital = Capital;
		this.curencies = curencies;
		this.users = users;
	}
	*/
	public long getId() {    
	    return co_id;    
	}    
	public void setId(long id) {    
	    this.co_id = id;    
	}    
	
	public String getName() {    
	    return co_name;    
	}    
	public void setName(String name) {    
	    this.co_name = name;    
	}    
	
	public String getCapital() {    
	    return co_capital;    
	}    
	public void setCapital(String capital) {    
	    this.co_capital = capital;    
	}
	
	public List<Curencies> getCurencies() {
		return curencies;
	}

	public void setCurencies(List<Curencies> curencies) {
		this.curencies = curencies;
	}
	
	public List<Users> getUsers() {
		return users;
	}

	public void setUsers(List<Users> users) {
		this.users = users;
	}
	

}
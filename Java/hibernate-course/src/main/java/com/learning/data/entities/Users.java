package com.learning.data.entities;

import javax.persistence.*;
//import java.util.Date;

import com.learning.data.interfaces.NamableEntity;

@Entity
@Table(name = "tUsers")

public class Users implements NamableEntity{
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "ID_sequence") 
	@SequenceGenerator (name= "ID_sequence", sequenceName = "seq_id_Users", allocationSize = 1,initialValue = 300)
	@Column(name = "US_ID" , nullable = false)
	private long us_id;
	
	@OneToOne(mappedBy = "user")
	@JoinColumn(name ="AC_US_ID")
	private Acounts acount;
	
	@ManyToOne
	@JoinColumn(name = "US_CO_ID")
	private Countries country;
	
	
	@Column(name = "US_TYPE")
	private String us_type;
	
	@Column(name ="US_NAME")
	private String us_name;
	
	
	public Users() {
		System.out.println(this.us_id);
		System.out.println("------------------------------------------------------------");
	}
	
	public long getId() {    
	    return us_id;    
	}    
	public void setId(long id) {    
	    this.us_id = id;    
	} 
	public String getType() {    
	    return us_type;    
	}    
	public void setType(String type) {    
	    this.us_type = type;    
	} 
	public String getName() {
		return us_name;
	}
	public void setName(String name) {
		this.us_name = name;
	}
	
}

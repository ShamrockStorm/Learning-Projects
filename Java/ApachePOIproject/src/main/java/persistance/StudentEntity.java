package persistance;
import javax.persistence.*;




@Entity
@Table(name = "tStudents")
public class StudentEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "Student_sequence") 
	@SequenceGenerator (name= "Student_sequence", sequenceName = "seq_id_Students", allocationSize = 1,initialValue = 1)
	@Column(name = "StudentId" , nullable = false)
	Integer id;
	@Column(name ="StudentFirstName")
	String firstName;
	@Column(name ="StudentLastName")
	String lastName;
	@Column(name ="StudentEmail")
	String email;
	
	public StudentEntity() {
		
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

}

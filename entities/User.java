package tn.esprit.spring.entities;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PUBLIC)
@Table(name = "User")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long IdUser;
	private String FirstName;
	private String LastName;
	private String Pwd;
	private String Adress;
	private Date Birthday;
	private int PhoneNumber;
	private String Email;
	private String Urlpicture;
	@Enumerated(EnumType.STRING)
	private TypeUser typeuser;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="users")
	@JsonIgnore
	private Set<Comment> comments;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="users")
	@JsonIgnore
	private Set<Complaint> complaints;
	
	@OneToOne 
	@JsonIgnore
	Invitation invitation;
	
	@OneToOne 
	@JsonIgnore
	Profil profil;
	
	@ManyToOne()
	@JsonIgnore
	Trip trips;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="users")
	@JsonIgnore
	private Set<Chat> chats;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="users")
	@JsonIgnore
	private Set<ResponseComplaint> responseComplaints;
	
	public User(Long IdEmployee) {
		super();
		this.IdUser = IdEmployee ;}
	public User(long idUser, String FirstName, String LastName, Date Birthday, String Email, String Adress,
			TypeUser typeuser) {
		super();
		this.IdUser = idUser;
		this.FirstName = FirstName;
		this.LastName = LastName;
		this.Birthday = Birthday;
		this.Email = Email;
		this.Adress = Adress;
		this.typeuser = typeuser;
	}
	@Override
	public String toString() {
		return "User [IdUser=" + IdUser + ", FirstName=" + FirstName + ", LastName=" + LastName + ", Birthday="
				+ Birthday + ", Email=" + Email + ", Adress=" + Adress + ", typeuser =" + typeuser
				+ "]";
	}
	
}

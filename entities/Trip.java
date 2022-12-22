package tn.esprit.spring.entities;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
@Table(name = "Trip")
public class Trip  implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long IdTrip;
	private String Domain;
private String Destination;
private String Duration;
@Temporal(TemporalType.DATE)
@Column(name = "DateBegin", nullable = false)
private Date DateBegin;
@Temporal(TemporalType.DATE)
@Column(name = "DateEnd", nullable = false)
private Date DateEnd;
private float Price;
private String Perimetre;

@OneToMany(cascade = CascadeType.ALL, mappedBy="trips")
@JsonIgnore
private Set<Reservation> reservations;

@OneToMany(cascade = CascadeType.ALL, mappedBy="trips")
@JsonIgnore
private Set<User> users;

@OneToMany(mappedBy="trip",cascade = CascadeType.REMOVE)
@JsonIgnore
List<NoteTrip> notesTrip = new ArrayList<>();

}
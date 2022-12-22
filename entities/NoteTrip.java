package tn.esprit.spring.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NoteTrip {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long IdNote;
	private float NoteTrip;
	@ManyToOne
	@JsonIgnore
	User user;
	@ManyToOne
	@JsonIgnore
    Trip trip;
	@Override
	public String toString() {
		return "NoteTrip [IdNote=" + IdNote + ", NoteTrip=" + NoteTrip + "]";
	}
	public NoteTrip(float NoteTrip, User user, Trip trip) {
		super();
		this.NoteTrip = NoteTrip;
		this.user = user;
		this.trip = trip;
	}
	
	
}

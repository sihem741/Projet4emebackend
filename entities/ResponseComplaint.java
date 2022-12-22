package tn.esprit.spring.entities;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseComplaint implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long IdReponseComplaint;
	private String Response;
	private String ImageReponseComplaint;
	@Temporal(TemporalType.DATE)
	private Date DateReponseComplaint;
	@Column(nullable=true)
	private long NumComplaint;
	@ManyToOne()
	@JsonIgnore
	User users;
	@ManyToOne()
	@JsonIgnore
	Complaint complaints;
}

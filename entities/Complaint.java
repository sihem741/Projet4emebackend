package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
import lombok.ToString;
import lombok.experimental.FieldDefaults;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PUBLIC)
@Table(name = "Complaint")
public class Complaint implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long IdComplaint;
	private String firstName;
    private String lastName;
	private String Topic;
	private String MessageComplaint;
	private String ImageComplaint;
	@Temporal(TemporalType.DATE)
	private Date DateComplaint;
	private boolean Cloture = false;
	
	@Enumerated(EnumType.STRING)
	private CategorieComplaint categoriecomplaint;
	@ManyToOne()
	@JsonIgnore
	User users;
	@OneToMany(cascade = CascadeType.ALL, mappedBy="complaints")
	@JsonIgnore
	private Set<ResponseComplaint> responsesComplaints;
	
}

package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Date;
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
import lombok.*;
import lombok.experimental.FieldDefaults;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PUBLIC)
@Table(name = "Post")
public class Post implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long IdPost;
	private String Contents;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "Date", nullable = false)
	private Date Date;
	@OneToMany(cascade = CascadeType.ALL, mappedBy="post")
	@JsonIgnore
	private Set<Comment> comments;
	@JsonIgnore
	@ManyToOne
	User user;
}

package tn.esprit.spring.repositories;

import java.util.Date;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import tn.esprit.spring.entities.NoteTrip;


public interface NoteTripRepository extends CrudRepository<NoteTrip, Long>{

	@Query("select AVG(NoteTrip) from NoteTrip np where (np.trip.IdTrip=:IdTrip) ")
	float getNotesTripByIdTrip(@Param("IdTrip")long IdTrip);
}

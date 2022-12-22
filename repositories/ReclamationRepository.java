package tn.esprit.spring.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Complaint;
@Repository
public interface ReclamationRepository extends CrudRepository<Complaint,Long>{

}

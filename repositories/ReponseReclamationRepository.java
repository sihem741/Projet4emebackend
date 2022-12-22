package tn.esprit.spring.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import tn.esprit.spring.entities.ResponseComplaint;


public interface ReponseReclamationRepository extends CrudRepository<ResponseComplaint, Long> {
	
	

}

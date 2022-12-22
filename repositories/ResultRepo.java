package tn.esprit.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Result;

@Repository
public interface ResultRepo extends JpaRepository<Result, Integer> {
	
}

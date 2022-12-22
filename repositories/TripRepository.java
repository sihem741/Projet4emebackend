package tn.esprit.spring.repositories;

import org.springframework.data.repository.CrudRepository;


import tn.esprit.spring.entities.Trip;

public interface TripRepository extends CrudRepository<Trip, Long> {


}

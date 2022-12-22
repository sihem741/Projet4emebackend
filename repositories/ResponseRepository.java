package tn.esprit.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.spring.entities.ResponseComplaint;

public interface ResponseRepository extends JpaRepository<ResponseComplaint,Long> {
}

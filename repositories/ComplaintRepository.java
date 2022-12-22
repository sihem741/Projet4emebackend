package tn.esprit.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.spring.entities.Complaint;

public interface ComplaintRepository extends JpaRepository<Complaint,Long> {


}

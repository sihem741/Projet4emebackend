package tn.esprit.spring.services;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.web.multipart.MultipartFile;

import tn.esprit.spring.entities.Planning;

public interface IPlanningService  {
	public List<Planning> retrieveAllPlannings();
	public Planning addPlanning(Planning p);
	public Planning retrievePlanning(Long id);
	public void deletePlanning(Long id);
	public Planning updatePlanning(Planning u);
	
}

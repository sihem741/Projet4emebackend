package tn.esprit.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import tn.esprit.spring.entities.Planning;
import tn.esprit.spring.entities.Reservation;
import tn.esprit.spring.entities.Trip;
import tn.esprit.spring.repositories.PlanningRepository;
import tn.esprit.spring.repositories.ReservationRepository;
import tn.esprit.spring.repositories.TripRepository;

@Service

public class PlanningServiceImpl implements IPlanningService {
	@Autowired
	PlanningRepository planningRepository;
	@Override
	public List<Planning> retrieveAllPlannings() {
		return (List<Planning>)planningRepository.findAll();

	}

	@Override
	public Planning addPlanning(Planning p) {
		planningRepository.save(p);
		return p;
	}

	@Override
	public void deletePlanning(Long Id) {
		planningRepository.deleteById(Id);
		   
	}

	@Override
	public Planning updatePlanning(Planning p) {
		planningRepository.save(p);
		return p;
	}

	@Override
	public Planning retrievePlanning(Long Id) {
		return planningRepository.findById(Id).get();
	}

	
}

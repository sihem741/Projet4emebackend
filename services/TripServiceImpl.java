package tn.esprit.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import tn.esprit.spring.entities.Reservation;
import tn.esprit.spring.entities.Trip;
import tn.esprit.spring.repositories.TripRepository;

@Service

public class TripServiceImpl implements ITripService {
	@Autowired
	TripRepository tripRepository;
	@Override
	public List<Trip> retrieveAllTrips() {
		return (List<Trip>)tripRepository.findAll();
		
	}

	@Override
	public Trip addTrip(Trip t) {
		tripRepository.save(t);
		return t;
	}

	@Override
	public void deleteTrip(Long Id) {
		tripRepository.deleteById(Id);
		   
	}

	@Override
	public Trip updateTrip(Trip t) {
		tripRepository.save(t);
			return t;
	}

	@Override
	public Trip retrieveTrip(Long Id) {
		return tripRepository.findById(Id).get();
		
	}
	

	}



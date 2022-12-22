package tn.esprit.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import tn.esprit.spring.entities.Reservation;
import tn.esprit.spring.entities.Trip;
import tn.esprit.spring.repositories.ReservationRepository;
import tn.esprit.spring.repositories.TripRepository;

@Service

public class ReservationServiceImpl implements IReservationService {
	@Autowired
	ReservationRepository reservationRepository;
	@Override
	public List<Reservation> retrieveAllReservations() {
		return (List<Reservation>)reservationRepository.findAll();
	}

	@Override
	public Reservation addReservation(Reservation r) {
		reservationRepository.save(r);
		return r;
	}

	@Override
	public void deleteReservation(Long Id) {
		reservationRepository.deleteById(Id);
		   
	}

	@Override
	public Reservation updateReservation(Reservation r) {
		reservationRepository.save(r);
		return r;
	}

	@Override
	public Reservation retrieveReservation(Long Id) {
		return reservationRepository.findById(Id).get();
	}

	
}

package tn.esprit.spring.services;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.web.multipart.MultipartFile;

import tn.esprit.spring.entities.Reservation;

public interface IReservationService  {
	public List<Reservation> retrieveAllReservations();
	public Reservation addReservation(Reservation r);
	public Reservation retrieveReservation(Long id);
	public void deleteReservation(Long id);
	public Reservation updateReservation(Reservation u);
	
}

package tn.esprit.spring.services;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import tn.esprit.spring.entities.Reservation;
import tn.esprit.spring.entities.Trip;


public interface ITripService {
	List<Trip> retrieveAllTrips();
    public Trip addTrip(Trip t);
    public Trip retrieveTrip(Long id);
	public void deleteTrip(Long id);
	public Trip updateTrip(Trip u);
	//public String doHashing(String psw);
	//public void saveImage(MultipartFile  file);
}

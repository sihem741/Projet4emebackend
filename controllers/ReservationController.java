package tn.esprit.spring.controllers;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import tn.esprit.spring.entities.Reservation;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.services.IReservationService;
import tn.esprit.spring.services.IUserService;



@RestController
@RequestMapping("/reservation")
@CrossOrigin(origins = "*")
public class ReservationController {
	
	@Autowired
	IReservationService reservationService;
	
	@PostMapping("/add-reservation")
	@ResponseBody
	public Reservation addReservation(@RequestBody Reservation r) {
		
		
		
		long PassportId = r.getPassportId();
		r.setPassportId(PassportId);
		
		long TripRevenu = r.getTripRevenu();
		r.setTripRevenu(TripRevenu);
	
		
		return reservationService.addReservation(r);
	} 
	
	@DeleteMapping("/remove-reservation/{reservation-id}")
	@ResponseBody
	public void deleteReservation(@PathVariable("reservation-id") Long IdUser) {
		reservationService.deleteReservation(IdUser);
	}

	@PutMapping("/update-reservation")
	@ResponseBody
	public Reservation updateReservation(@RequestBody Reservation reservation) {
		return reservationService.updateReservation(reservation);
	}
	
}

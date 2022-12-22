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
import tn.esprit.spring.entities.Trip;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.services.ITripService;
import tn.esprit.spring.services.IUserService;



@RestController
@RequestMapping("/trip")
@CrossOrigin(origins = "*")
public class TripRestController {
	
	@Autowired
	ITripService tripService;
	
	@PostMapping("/add-trip")
	@ResponseBody
	public Trip addTrip(@RequestBody Trip t) {
		
		String domain = t.getDomain();
		t.setDomain(domain);
		
		String destination = t.getDestination();
		t.setDestination(destination);
		
		String duration = t.getDuration();
		t.setDuration(duration); 
		
		Date datebegin = t.getDateBegin();
		t.setDateBegin(datebegin);
		
		Date dateend = t.getDateEnd();
		t.setDateEnd(dateend);
		
		float price = t.getPrice();
		t.setPrice(price);
		
		String perimetre = t.getPerimetre();
		t.setPerimetre(perimetre);
		
		return tripService.addTrip(t);
	}
	
	@DeleteMapping("/remove-trip/{trip-id}")
	@ResponseBody
	public void deleteTrip(@PathVariable("trip-id") Long IdTrip) {
		tripService.deleteTrip(IdTrip);
	}

	@PutMapping("/update-trip")
	@ResponseBody
	public Trip updateTrip(@RequestBody Trip trip) {
		return tripService.updateTrip(trip);
	}
}

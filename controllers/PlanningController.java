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

import tn.esprit.spring.entities.Planning;
import tn.esprit.spring.entities.Reservation;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.services.IPlanningService;
import tn.esprit.spring.services.IReservationService;
import tn.esprit.spring.services.IUserService;



@RestController
@RequestMapping("/planning")
@CrossOrigin(origins = "*")
public class PlanningController {
	
	@Autowired
	IPlanningService planningService;
	
	@PostMapping("/add-planning")
	@ResponseBody
	public Planning addPlanning(@RequestBody Planning p) {
		
		
		
		String Schedule = p.getSchedule();
		p.setSchedule(Schedule);
		
		String Description = p.getDescription();
		p.setDescription(Description);
	
		
		return planningService.addPlanning(p);
	} 
	
	@DeleteMapping("/remove-planning/{planning-id}")
	@ResponseBody
	public void deletePlanning(@PathVariable("planning-id") Long IdTrip) {
		planningService.deletePlanning(IdTrip);
	}

	@PutMapping("/update-planning")
	@ResponseBody
	public Planning updatePlanning(@RequestBody Planning planning) {
		return planningService.updatePlanning(planning);
	}
	
}

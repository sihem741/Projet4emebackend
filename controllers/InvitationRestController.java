package tn.esprit.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Invitation;
import tn.esprit.spring.services.IInvitationService;


@CrossOrigin("*")
@RestController
@RequestMapping("/Invitation")
public class InvitationRestController {
	@Autowired
	IInvitationService InvitationService ;
	@GetMapping("/retrieve-all-Invitation")
	@ResponseBody
	public List<Invitation> getInvitation() {
	List<Invitation> listInvitation = InvitationService.retrieveAllInvitation();
	return listInvitation;
	}
		@GetMapping("/retrieve/{Invitation-id}")
		@ResponseBody
		public Invitation getInvitation(@PathVariable("Invitation-id")Long IdInvi) {
			Invitation inv = InvitationService.retrieveInvitation(IdInvi);
		return inv;
		}

		@PostMapping("/add-Invitation")
		@ResponseBody
		public Invitation addInvitation(@RequestBody Invitation inv) {
			return InvitationService.addInvitation(inv);
		}
	
		@DeleteMapping("/remove-Invitation/{Invitation-id}")
		@ResponseBody
		public void removeInvitation(@PathVariable("Invitation-id") Long IdInvi) {
			InvitationService.deleteInvitation(IdInvi);
		}
    	@PutMapping("/modify-Invitation")
		@ResponseBody
		public Invitation modifyInvitation(@RequestBody Invitation inv) {
		return InvitationService.updateInvitation(inv);
		}
}

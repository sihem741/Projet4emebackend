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

import tn.esprit.spring.entities.Profil;

import tn.esprit.spring.services.IProfilService;
@RestController
@RequestMapping("/Profil")
@CrossOrigin(origins = "*")
public class ProfilController {
	@Autowired
	IProfilService profilservice;
	
	@PostMapping("/add-profil")
	@ResponseBody
	public Profil addProfil(@RequestBody Profil p) {
		String pass = p.getPwd();
		p.setPwd(pass);
		String  Metric = p.getMetric();
		p.setMetric(Metric);
		String Profession=p.getProfession();
		p.setProfession(Profession);
	    String Domain=p.getDomain();
	    p.setDomain(Domain);
	    Long FollowersNbr=p.getFollowersNbr();
	    p.setFollowersNbr(FollowersNbr);

		return profilservice.addProfil(p);
	}
	@DeleteMapping("/delete-Profil/{Profil-id}")
	@ResponseBody
	public void deleteProfil(@PathVariable("Profil-id") Long IdProfil)
	{
		profilservice.deleteProfil(IdProfil);

	}
	@PutMapping("/update-profil")
	@ResponseBody
	public Profil updateProfil(@RequestBody Profil p) {
		return profilservice.updateProfil(p);
	}
	@GetMapping("/retrieve-profil/{profil-id}")
	@ResponseBody
	public Profil retrieveProfil(@PathVariable("profil-id") Long IdProfil) {
		return profilservice.retrieveProfil(IdProfil);
	}
	@GetMapping("/retrieve-all-profil")
	@ResponseBody
	public List<Profil> getProfils() {
		return profilservice.retrieveAllProfils();
				
}
}

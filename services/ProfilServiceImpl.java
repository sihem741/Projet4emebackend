package tn.esprit.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import tn.esprit.spring.entities.Profil;

import tn.esprit.spring.entities.User;
import tn.esprit.spring.repositories.ProfilRepository;
import tn.esprit.spring.repositories.UserRepository;

@Service
public class ProfilServiceImpl implements IProfilService{

	
	@Autowired
	ProfilRepository profilRepository ;
	@Override
	public List<Profil> retrieveAllProfils() {
		// TODO Auto-generated method stub
		return  (List<Profil>) profilRepository.findAll();

	}

	@Override
	public  Profil addProfil(Profil p) {
		profilRepository.save(p);
		return p;
	}

	@Override
	public void deleteProfil(Long IdProfil) {
		
		profilRepository.deleteById(IdProfil);
	}

	@Override
	public Profil updateProfil(Profil p) {
		profilRepository.save(p);
		return p;
	}

	@Override
	public Profil retrieveProfil(Long IdProfil) {
		
		return profilRepository.findById(IdProfil).get();
	}

	

}

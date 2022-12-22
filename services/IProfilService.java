package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Profil;


public interface IProfilService {
	List<Profil> retrieveAllProfils();
    Profil addProfil(Profil p);
	void deleteProfil(Long IdProfil);
	Profil updateProfil(Profil p);
	Profil retrieveProfil(Long IdProfil);
}

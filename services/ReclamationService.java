package tn.esprit.spring.services;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import tn.esprit.spring.entities.Complaint;


public interface ReclamationService {
	public List<Complaint> retrieveAllReclamations();
	public Complaint addReclamation(Complaint r);
	public Complaint retrieveReclamation(Long id);
	public Complaint updateReclamation(Complaint r);
	public void deleteReclamation(Long id);
	public void saveImage(MultipartFile file);


}

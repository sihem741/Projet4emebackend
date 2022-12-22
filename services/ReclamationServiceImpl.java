package tn.esprit.spring.services;

import java.util.Date;
import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import tn.esprit.spring.entities.ComplaintSearchCriteria;
import tn.esprit.spring.entities.Complaint;
import tn.esprit.spring.entities.ComplaintPage;
import tn.esprit.spring.repositories.ComplaintCriteriaRepository;
import tn.esprit.spring.repositories.ReclamationRepository;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ReclamationServiceImpl implements ReclamationService{
	

	private final Path root = Paths.get("C:/Users/gmiza/Downloads");

	private final ReclamationRepository reclamationRepository;
    private final ComplaintCriteriaRepository complaintCriteriaRepository;

  
	public ReclamationServiceImpl(ReclamationRepository reclamationRepository,
			ComplaintCriteriaRepository complaintCriteriaRepository) {
		super();
		this.reclamationRepository = reclamationRepository;
		this.complaintCriteriaRepository = complaintCriteriaRepository;
	}

	@Override
	public List<Complaint> retrieveAllReclamations() {
		return  (List<Complaint>) reclamationRepository.findAll();
	}

	@Override
	public Complaint addReclamation(Complaint r) {
		reclamationRepository.save(r);
		return r;
	}

	@Override
	public Complaint retrieveReclamation(Long id) {
		return reclamationRepository.findById(id).get();
	}

	@Override
	public Complaint updateReclamation(Complaint r) {
		reclamationRepository.save(r);		
		return r;
	}

	@Override
	public void deleteReclamation(Long id) {
		reclamationRepository.deleteById(id);
	}


	//  private final Path root = Paths.get("C:/Users/gmiza/Downloads");
	  @Override
	  public void saveImage(MultipartFile  file) {
	    try {
	       Files.copy(file.getInputStream(), this.root.resolve(file.getOriginalFilename()));
	    } catch (Exception e) {
	      throw new RuntimeException("Could not store the file. Error: " + e.getMessage());
	    }
	  }
	  
	 
	public Page<Complaint> getcomplaint(ComplaintPage complaintePage,
				   ComplaintSearchCriteria complainteSearchCriteria){
	return complaintCriteriaRepository.findAllWithFilters(complaintePage,complainteSearchCriteria);
	}
	
	public Complaint addcomplaint(Complaint complaint){
	return reclamationRepository.save(complaint);
}
	Logger log = LoggerFactory.getLogger(ReclamationServiceImpl.class);

	// schedule a job to add object in DB (Every 5 sec)
	@Scheduled(fixedRate = 5000)
	public void add2DBJob() {
		Complaint complaint = new Complaint();
		complaint.setFirstName("firstName" + new Random().nextInt(374483));
		reclamationRepository.save(complaint);
		System.out.println("add service call in " + new Date().toString());
	}

	@Scheduled(cron = "0/15 * * * * *")
	public void fetchDBJob() {
	
		List <Complaint>  complaints = (List<Complaint>) reclamationRepository.findAll();
		System.out.println("fetch service call in " + new Date().toString());
		System.out.println("no of record fetched : " + complaints.size());
		log.info("complaints : {}", complaints);
	}

}

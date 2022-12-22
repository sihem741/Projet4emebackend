package tn.esprit.spring.controllers;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


import lombok.extern.slf4j.Slf4j;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import tn.esprit.spring.entities.ComplaintSearchCriteria;
import tn.esprit.spring.entities.Complaint;
import tn.esprit.spring.entities.ComplaintPage;
import tn.esprit.spring.services.ReclamationService;
import tn.esprit.spring.services.ReclamationServiceImpl;

    @Slf4j
	@RestController
	@RequestMapping("/reclamation")
	@CrossOrigin(origins = "*")
	//@ComponentScan(basePackages= {"tn.esprit.spring.services"})

	public class ReclamationRestController {

		@Autowired
		private final ReclamationServiceImpl reclamationService;

	   
	   
	    

		
		public ReclamationRestController(ReclamationServiceImpl reclamationService) {
			
			this.reclamationService = reclamationService;
		}
		// http://localhost:8081/SpringMVC/reclamation/retrieve-all-reclamations
		@GetMapping("/retrieve-all-reclamations")
		@ResponseBody
		public List<Complaint> getReclamations() {
			return reclamationService.retrieveAllReclamations();
		}
		// http://localhost:8081/SpringMVC/reclamation/retrieve-reclamation/1
		@GetMapping("/retrieve-reclamation/{reclamation-id}")
		@ResponseBody
		public Complaint retrieveReclamation(@PathVariable("reclamation-id") Long id) {
			return reclamationService.retrieveReclamation(id);
		}

		// http://localhost:8081/SpringMVC/reclamation/add-reclamation
		@PostMapping("/add-reclamation")
		@ResponseBody
		public Complaint addReclamationCategory(@RequestBody Complaint c) {
			return reclamationService.addReclamation(c);
		}
		// http://localhost:8081/SpringMVC/reclamation/remove-reclamation/{reclamation-id}
		@DeleteMapping("/remove-reclamation/{reclamation-id}")
		@ResponseBody
		public void removeReclamation(@PathVariable("reclamation-id") Long id) {
			reclamationService.deleteReclamation(id);
		}

		// http://localhost:8081/SpringMVC/reclamation/modify-reclamation
		@PutMapping("/modify-reclamation")
		@ResponseBody
		public Complaint modifyReclamation(@RequestBody Complaint r) {
			return reclamationService.updateReclamation(r);
		}
		// http://localhost:8081/SpringMVC/reclamation/retrieve-all-reclamationsByUser/{user-id}
		@GetMapping("/retrieve-all-reclamationsByUser/{user-id}")
		@ResponseBody
	    public List<Complaint> getReclamationsByUser(@PathVariable("user-id") Long id) {
			List<Complaint> r =  reclamationService.retrieveAllReclamations();
			List<Complaint> ru =new ArrayList<>();
			
			for (Complaint re : r) {
				if (re.getUsers().getIdUser()==id) {
					ru.add(re);
				}
			}
	
			return ru ;
		}
		
		//http://localhost:8081/SpringMVC/reclamation/uploadImage
		@PostMapping("/uploadImage")
		  public void uploadFile(@RequestParam("file") MultipartFile file) {
		    String message = "";
		    try {
		      reclamationService.saveImage(file);   
		    System.out.print( message = "Uploaded the file successfully: " + file.getOriginalFilename());
		    } catch (Exception e) {
		    	
		    	System.out.print(  message = "Could not upload the file: " + file.getOriginalFilename() + "!");
		    }
		}
		@GetMapping
	    public ResponseEntity<Page<Complaint>> getComplaint(ComplaintPage complaintPage,
	    		ComplaintSearchCriteria complaintSearchCriteria){
	        return new ResponseEntity<>(reclamationService.getcomplaint(complaintPage, complaintSearchCriteria),
	                HttpStatus.OK);
	    }
		

	
	    @PostMapping
	    public ResponseEntity<Complaint> addComplaint(@RequestBody Complaint complaint){
	        return new ResponseEntity<>(reclamationService.addcomplaint(complaint), HttpStatus.OK);
	    }
}


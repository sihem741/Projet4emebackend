package tn.esprit.spring.services;

import java.io.Console;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Cacheable;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.qos.logback.classic.Logger;
import springfox.documentation.swagger2.mappers.ModelMapper;
import tn.esprit.spring.entities.Complaint;
import tn.esprit.spring.entities.ResponseComplaint;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.repositories.ReclamationRepository;
import tn.esprit.spring.repositories.ReponseReclamationRepository;
import tn.esprit.spring.repositories.UserRepository;

@Service
public class ReponseReclamationServiceImpl implements ReponseReclamationService{
	@Autowired
	ReponseReclamationRepository reponseReclamationRepository;
	@Autowired
	ReclamationService recservice;
	@Autowired
	private UserRepository userRepository;
//	private static final Logger logger = LoggerFactory.getLogger(ReponseReclamationServiceImpl.class);

	

	@Override
	public List<ResponseComplaint> retrieveAllReponsesReclamation() {
		return  (List<ResponseComplaint>) reponseReclamationRepository.findAll();
	}


	@Override
	public ResponseComplaint retrieveReponseReclamation(Long id) {
		return reponseReclamationRepository.findById(id).get();
	}

	@Override
	public ResponseComplaint updateReponseReclamation(ResponseComplaint r) {
		return reponseReclamationRepository.save(r);
	}

	@Override
	public void deleteReponseReclamation(Long id) {
		reponseReclamationRepository.deleteById(id);
	}


	@Override
	public ResponseComplaint addReponseReclamation(ResponseComplaint r) {
	r.setComplaints(recservice.retrieveReclamation(r.getNumComplaint()));
	System.out.print("id reclamation ====" +r.getComplaints().getIdComplaint());
		return reponseReclamationRepository.save(r);
	}


/*	@Override
	//@Cacheable(value="ResponseComplaint", key="#storyId")
	public List<ResponseComplaint> TopCommentsByComplaintId(Long IdComplaint, Long IdReponseComplaint) {
		logger.trace("Getting top ResponseComplaint for complaint: {}", new Object[] {IdComplaint});
		Complaint complaint = recservice.retrieveReclamation(IdComplaint);
		if (complaint.isCloture()) {
			return Collections.emptyList();
		}
	List<Long> IdComplaints = (List<Long>) complaint;
		if (IdComplaints.size()> IdReponseComplaint) {
			IdComplaints = IdComplaints.subList(0, IdReponseComplaint);
		}
		return IdComplaints.parallelStream().map(IdReponseComplaint -> retrieveReponseReclamation(IdReponseComplaint)).collect(Collectors.toList());
	}
*/


	}


	


package tn.esprit.spring.services;

import java.util.List;



import tn.esprit.spring.entities.ResponseComplaint;

public interface ReponseReclamationService {
	public List<ResponseComplaint> retrieveAllReponsesReclamation();
	public ResponseComplaint addReponseReclamation(ResponseComplaint r);
	public ResponseComplaint retrieveReponseReclamation(Long id);
	public ResponseComplaint updateReponseReclamation(ResponseComplaint r);
	public void deleteReponseReclamation(Long id);
//	List<ResponseComplaint> TopCommentsByComplaintId(Long IdComplaint,Long IdReponseComplaint);

	
}

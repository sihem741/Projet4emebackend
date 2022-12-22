package tn.esprit.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entities.Complaint;
import tn.esprit.spring.entities.ResponseComplaint;
import tn.esprit.spring.entities.Topic;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.repositories.ComplaintRepository;
import tn.esprit.spring.repositories.ReservationRepository;
import tn.esprit.spring.repositories.ResponseRepository;
import tn.esprit.spring.repositories.UserRepository;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ResponseService {

    @Autowired
    ResponseRepository rr;


    @Autowired
    UserRepository ur;

    @Autowired
    ComplaintRepository cr;
   public ResponseComplaint add_response (Long id_complaint ,Long id_user, ResponseComplaint r){
       User u =ur.findById(id_user).get();
       Complaint c = cr.findById(id_complaint).get();
        r.setComplaint(c);
        r.setUser(u);
        r.setDateReponseComplaint(new Date());
        return rr.save(r);
    }

    public void delete_response(Long id_response){
       rr.deleteById(id_response);
    }

    public List<ResponseComplaint> FilterByUser(Long id_user){
       User u = ur.findById(id_user).get();
       List<ResponseComplaint> responsesByuser = rr.findAll()
                .stream().filter(c->c.getUser().equals(u))
                .collect(Collectors.toList());
        return responsesByuser;
    }
}

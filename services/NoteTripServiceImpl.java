package tn.esprit.spring.services;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.NoteTrip;
import tn.esprit.spring.repositories.NoteTripRepository;
import tn.esprit.spring.repositories.TripRepository;
import tn.esprit.spring.repositories.UserRepository;


@Service
public class NoteTripServiceImpl implements INoteTripService {

	@Autowired
	NoteTripRepository noteTripRep;
	@Autowired
	UserRepository ur;
	@Autowired
	TripRepository pr;
	@Override
	public NoteTrip getNotesTripByUser(long userId,long idTrip) {
	    NoteTrip n=new NoteTrip(0,ur.findById(userId).get(),null);
		List<NoteTrip> l = new ArrayList<>();
		
		for (NoteTrip a :(List<NoteTrip>)noteTripRep.findAll()  ) {
			if(a.getTrip().getIdTrip()==idTrip) {
				if(a.getUser().getIdUser()==userId) {
					n=a;
				}
			}
	   }
		 return n;
	}

	@Override
	public NoteTrip addNoteTrip(NoteTrip np) {
		return noteTripRep.save(np);
	}


   @Override
	public void deleteNoteTrip(long id) {
		noteTripRep.deleteById(id);
	}

	@Override
	public float getNotesTripByIdTrip(long idTrip) {
		
	try {
	return noteTripRep.getNotesTripByIdTrip(idTrip);
	}catch (Exception e) {
		return 0;
	}

	}

	@Override
	public NoteTrip retrieveNoteTrip(long id) {
		return noteTripRep.findById(id).get();
	}
}

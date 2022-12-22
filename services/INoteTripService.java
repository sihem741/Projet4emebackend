package tn.esprit.spring.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import tn.esprit.spring.entities.NoteTrip;

public interface INoteTripService {
	public NoteTrip getNotesTripByUser(long id,long IdTrip );
	public float getNotesTripByIdTrip(long id);
	public NoteTrip addNoteTrip(NoteTrip np);
	public NoteTrip retrieveNoteTrip(long id);
	public void deleteNoteTrip(long id);

}

package tn.esprit.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Complaint;
import tn.esprit.spring.entities.NoteTrip;
import tn.esprit.spring.services.INoteTripService;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/noteTrip")
public class NoteTripRestController {

	@Autowired
	INoteTripService noteTripService;
	
	@GetMapping("/retrieve-note-trip-byuser/{user-id}{trip-id}")
	@ResponseBody
public NoteTrip getNotesTripByUser(@PathVariable("user-id")long userId,@PathVariable("trip-id")long idTrip) {
		return noteTripService.getNotesTripByUser(userId,idTrip);
	}
	@GetMapping("/retrieve-note-trip-byidTrip/{trip-id}")
	@ResponseBody
public float getNotesTripByIdTrip(@PathVariable("trip-id")long idTrip) {
		return noteTripService.getNotesTripByIdTrip(idTrip);
	}
	
		@GetMapping("/retrieve-note-Trip/{note-Trip-id}")
		@ResponseBody
		public NoteTrip retrieveNoteTrip(@PathVariable("note-Trip-id") Long id) {
			return noteTripService.retrieveNoteTrip(id);
		}

		@PostMapping("/add-note-Trip")
		@ResponseBody
		public NoteTrip addNoteTrip(@RequestBody NoteTrip np) {
			//System.out.print(np);
			return noteTripService.addNoteTrip(np);
		}

		@DeleteMapping("/remove-note-Trip/{note-Trip-id}")
		@ResponseBody
		public void removeNotTrip(@PathVariable("note-Trip-id") Long id) {
			noteTripService.deleteNoteTrip(id);
		}

}

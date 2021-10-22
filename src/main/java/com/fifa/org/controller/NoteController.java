package com.fifa.org.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fifa.org.exception.ResourceNotFoundException;
import com.fifa.org.model.Note;
import com.fifa.org.repository.NoteRepository;

@SuppressWarnings("unused")
@RestController
@RequestMapping("/api")
public class NoteController {

	@Autowired
	NoteRepository noteRepository;
	
	
	@GetMapping("/notes")
	public List<Note> getAllNotes(){
		return noteRepository.findAll();		
	}
	
	@PostMapping("/notes")
	public Note createNote(@RequestBody Note note ) {
		return noteRepository.save(note);
	}
	
	@GetMapping("/notes/{id}")
	public Note getNotebyId(@PathVariable(value = "id") Long noteId ) {
		return noteRepository.findById(noteId).orElseThrow(() -> new ResourceNotFoundException("Note", "id", noteId));
	}
	
	@PutMapping("/notes/{id}")
	public Note updateNote(@PathVariable(value = "id") Long noteId, @RequestBody Note noteDetails) {
		
		Note note  = noteRepository.findById(noteId).orElseThrow(() -> new ResourceNotFoundException("Note", "id", noteId) );
		note.setTitle(noteDetails.getTitle());
		note.setContent(noteDetails.getContent());
		
		Note updatedNote = noteRepository.save(note);
		
		return updatedNote;
		
	}
	
	
	@DeleteMapping("/notes/{id}")
	public ResponseEntity<?> deletNote(@PathVariable(value = "id") Long noteId, @RequestBody Note noteDetails) {
		
		Note note  = noteRepository.findById(noteId).orElseThrow(() -> new ResourceNotFoundException("Note", "id", noteId) );

		
		 noteRepository.delete(note);
		
		return ResponseEntity.ok().build();
		
	}
	
	
	
}

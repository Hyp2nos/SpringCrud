package com.fifa.org.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fifa.org.model.Note;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {

}

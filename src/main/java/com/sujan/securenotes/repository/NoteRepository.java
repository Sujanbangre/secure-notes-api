package com.sujan.securenotes.repository;

import com.sujan.securenotes.entity.Note;
import com.sujan.securenotes.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NoteRepository extends JpaRepository<Note, Long> {

    List<Note> findByUser(User user);
}
package com.sujan.securenotes.service;

import com.sujan.securenotes.entity.Note;
import com.sujan.securenotes.entity.User;
import com.sujan.securenotes.repository.NoteRepository;
import com.sujan.securenotes.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    private final UserRepository userRepository;
    private final NoteRepository noteRepository;

    public AdminService(UserRepository userRepository,
                        NoteRepository noteRepository) {

        this.userRepository = userRepository;
        this.noteRepository = noteRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public List<Note> getUserNotes(Long userId) {

        User user = userRepository.findById(userId)
                .orElseThrow();

        return noteRepository.findByUser(user);
    }
}

package com.sujan.securenotes.service;

import com.sujan.securenotes.dto.NoteRequest;
import com.sujan.securenotes.entity.Note;
import com.sujan.securenotes.entity.User;
import com.sujan.securenotes.repository.NoteRepository;
import com.sujan.securenotes.repository.UserRepository;
import com.sujan.securenotes.security.JwtUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import com.sujan.securenotes.redis.RedisPublisher;

@Service
public class NoteService {

    private final NoteRepository noteRepository;
    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;
    private final RedisPublisher redisPublisher;

    public NoteService(
            NoteRepository noteRepository,
            UserRepository userRepository,
            JwtUtil jwtUtil,
            RedisPublisher redisPublisher) {

        this.noteRepository = noteRepository;
        this.userRepository = userRepository;
        this.jwtUtil = jwtUtil;
        this.redisPublisher = redisPublisher;
    }

    public String createNote(String token,
                             NoteRequest request) {

        String email =
                jwtUtil.extractEmail(token);

        User user =
                userRepository.findByEmail(email);

        Note note = new Note();

        note.setContent(
                request.getContent()
        );

        note.setUser(user);

        noteRepository.save(note);
        String event = "User: " + user.getEmail()
                + " | Note: " + note.getContent();

        redisPublisher.publishNoteEvent(event);

        return "Note Created Successfully";
    }

    public List<Note> getMyNotes(String token) {

        String email =
                jwtUtil.extractEmail(token);

        User user =
                userRepository.findByEmail(email);

        return noteRepository.findByUser(user);
    }
}

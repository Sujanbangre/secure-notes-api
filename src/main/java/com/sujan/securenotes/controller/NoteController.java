package com.sujan.securenotes.controller;

import com.sujan.securenotes.dto.NoteRequest;
import com.sujan.securenotes.service.NoteService;
import org.springframework.web.bind.annotation.*;
import com.sujan.securenotes.entity.Note;
import java.util.List;

@RestController
@RequestMapping("/user")
public class NoteController {

    private final NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @PostMapping("/notes")
    public String createNote(
            @RequestHeader("Authorization")
            String authHeader,

            @RequestBody
            NoteRequest request) {

        String token =
                authHeader.substring(7);

        return noteService.createNote(
                token,
                request
        );
    }
    @GetMapping("/notes")
    public List<Note> getMyNotes(
            @RequestHeader("Authorization")
            String authHeader) {

        String token =
                authHeader.substring(7);

        return noteService.getMyNotes(token);
    }
}

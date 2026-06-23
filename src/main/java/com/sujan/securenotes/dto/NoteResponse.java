package com.sujan.securenotes.dto;

public class NoteResponse {

    private Long id;
    private String content;

    public NoteResponse(Long id, String content) {
        this.id = id;
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}

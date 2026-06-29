package com.sujan.securenotes.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class NoteRequest {

    @NotBlank(message = "Note content cannot be empty")
    @Size(max = 500, message = "Note cannot exceed 500 characters")
    private String content;

    public NoteRequest() {
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

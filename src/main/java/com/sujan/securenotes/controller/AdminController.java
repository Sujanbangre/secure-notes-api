package com.sujan.securenotes.controller;

import com.sujan.securenotes.entity.Note;
import com.sujan.securenotes.entity.User;
import com.sujan.securenotes.service.AdminService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return adminService.getAllUsers();
    }

    @GetMapping("/users/{userId}/notes")
    public List<Note> getUserNotes(
            @PathVariable Long userId) {

        return adminService.getUserNotes(userId);
    }
}
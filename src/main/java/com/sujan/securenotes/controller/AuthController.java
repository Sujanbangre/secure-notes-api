package com.sujan.securenotes.controller;

import com.sujan.securenotes.dto.SignupRequest;
import com.sujan.securenotes.service.UserService;
import org.springframework.web.bind.annotation.*;
import com.sujan.securenotes.dto.LoginRequest;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signup")
    public String signup(@Valid @RequestBody SignupRequest request) {
        return userService.signup(request);
    }
    @PostMapping("/login")
    public String login(@Valid @RequestBody LoginRequest request) {
        return userService.login(request);
    }



}

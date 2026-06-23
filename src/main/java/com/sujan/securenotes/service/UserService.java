package com.sujan.securenotes.service;

import com.sujan.securenotes.dto.SignupRequest;
import com.sujan.securenotes.entity.User;
import com.sujan.securenotes.repository.UserRepository;
import org.springframework.stereotype.Service;
import com.sujan.securenotes.dto.LoginRequest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.sujan.securenotes.enums.Role;
import com.sujan.securenotes.security.JwtUtil;

@Service
public class UserService {

    private final BCryptPasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository,
                       BCryptPasswordEncoder passwordEncoder,
                       JwtUtil jwtUtil) {

        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }

    public String signup(SignupRequest request) {

        if (userRepository.existsByEmail(request.getEmail())) {
            return "Email already exists";
        }
        User user = new User();
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(
                Role.valueOf(
                        request.getRole().toUpperCase()
                )
        );
        userRepository.save(user);
        return "User registered successfully";
    }

    public String login(LoginRequest request) {

        User user = userRepository.findByEmail(request.getEmail());

        if (user == null) {
            return "User not found";
        }

        if (!passwordEncoder.matches(request.getPassword(),user.getPassword())) {
            return "Invalid password";
        }

        return jwtUtil.generateToken(
                user.getEmail(),
                user.getRole()
        );
    }
}

package com.example.portfolio.service.core.user.controller;

import com.example.portfolio.service.core.user.dto.request.LoginRequestDTO;
import com.example.portfolio.service.core.user.dto.request.RegisterRequestDTO;
import com.example.portfolio.service.core.user.dto.response.LoginResponseDTO;
import com.example.portfolio.service.core.user.dto.response.ProfileDTO;
import com.example.portfolio.service.core.user.dto.response.RegisterResponseDTO;
import com.example.portfolio.service.core.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class AuthController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<RegisterResponseDTO> register(@RequestBody RegisterRequestDTO requestDTO) {
        RegisterResponseDTO response = userService.register(requestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginRequestDTO requestDTO) {
        LoginResponseDTO response = userService.login(requestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/profile")
    public ResponseEntity<ProfileDTO> getProfile() {
        var response = userService.getProfile();
        return ResponseEntity.ok().body(response);
    }
}

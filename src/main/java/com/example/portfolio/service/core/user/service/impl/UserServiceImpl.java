package com.example.portfolio.service.core.user.service.impl;

import com.example.portfolio.service.common.enums.Role;
import com.example.portfolio.service.common.utils.JwtUtil;
import com.example.portfolio.service.core.user.dto.request.LoginRequestDTO;
import com.example.portfolio.service.core.user.dto.request.RegisterRequestDTO;
import com.example.portfolio.service.core.user.dto.response.LoginResponseDTO;
import com.example.portfolio.service.core.user.dto.response.RegisterResponseDTO;
import com.example.portfolio.service.core.user.mapper.UserMapper;
import com.example.portfolio.service.core.user.repository.UserRepository;
import com.example.portfolio.service.core.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    @Override
    public RegisterResponseDTO register(RegisterRequestDTO requestDTO) {
    log.info("Register user: {}", requestDTO);

    if(userRepository.existsByEmail(requestDTO.getEmail())){
        throw new RuntimeException("Email already exists");
    }

    var user = userMapper.toEntity(requestDTO);
    user.setPassword(passwordEncoder.encode(requestDTO.getPassword()));
    user.setCreatedAt(LocalDateTime.now());
    user.setUpdatedAt(LocalDateTime.now());
    user.setRole(Role.ROLE_USER.name());
    user.setIsAccountVerified(false);

    user = userRepository.save(user);
    log.info("User saved: {}", user);
    var response = userMapper.toResponse(user);
    log.info("User response: {}", response);
    return response;
    }

    @Override
    public LoginResponseDTO login(LoginRequestDTO requestDTO) {
        log.info("Login user: {}", requestDTO);

        // 1. Kullanıcı var mı kontrol et
        var user =  userRepository.findByEmail(requestDTO.getEmail())
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        // 2. Authentication
        Authentication authenticate = authenticationManager.authenticate
                (new UsernamePasswordAuthenticationToken(requestDTO.getEmail(), requestDTO.getPassword()));

        log.info("Authentication successful for user: {}", authenticate.getName());

        if (!authenticate.isAuthenticated()) {
            throw new RuntimeException("Invalid credentials");
        }

        // 3. JWT token oluştur
        String token =  jwtUtil.generateToken(user);

        user.setIsAccountVerified(true);
        userRepository.save(user);

        return LoginResponseDTO.builder()
                .email(requestDTO.getEmail())
                .token(token)
                .build();
    }
}

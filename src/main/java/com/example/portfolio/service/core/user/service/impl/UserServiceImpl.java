package com.example.portfolio.service.core.user.service.impl;

import com.example.portfolio.service.core.user.dto.request.LoginRequestDTO;
import com.example.portfolio.service.core.user.dto.request.RegisterRequestDTO;
import com.example.portfolio.service.core.user.dto.response.LoginResponseDTO;
import com.example.portfolio.service.core.user.dto.response.RegisterResponseDTO;
import com.example.portfolio.service.core.user.mapper.UserMapper;
import com.example.portfolio.service.core.user.model.User;
import com.example.portfolio.service.core.user.repository.UserRepository;
import com.example.portfolio.service.core.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public RegisterResponseDTO register(RegisterRequestDTO requestDTO) {
    log.info("Register user: {}", requestDTO);

    if(userRepository.existsByEmail(requestDTO.getEmail())){
        throw new RuntimeException("Email already exists");
    }

    var user = userMapper.toEntity(requestDTO);
    user.setCreatedAt(LocalDateTime.now());
    user.setUpdatedAt(LocalDateTime.now());
    user.setRole("USER");
    user.setStatus("ACTIVE");
    user.setImage("XXXXXXXXXXXXXXXXXXXXXXXXX");

    user = userRepository.save(user);
    log.info("User saved: {}", user);
    var response = userMapper.toResponse(user);
    log.info("User response: {}", response);
    return response;
    }

    @Override
    public LoginResponseDTO login(LoginRequestDTO requestDTO) {
        return null;
    }
}

package com.example.portfolio.service.core.user.service;

import com.example.portfolio.service.core.user.dto.request.LoginRequestDTO;
import com.example.portfolio.service.core.user.dto.request.RegisterRequestDTO;
import com.example.portfolio.service.core.user.dto.response.LoginResponseDTO;
import com.example.portfolio.service.core.user.dto.response.ProfileDTO;
import com.example.portfolio.service.core.user.dto.response.RegisterResponseDTO;

public interface UserService {

    RegisterResponseDTO register(RegisterRequestDTO requestDTO);

    LoginResponseDTO login(LoginRequestDTO requestDTO);

    ProfileDTO getProfile();

}

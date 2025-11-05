package com.example.portfolio.service.core.about.service;

import com.example.portfolio.service.core.about.dto.request.AboutRequestDTO;
import com.example.portfolio.service.core.about.dto.response.AboutResponseDTO;

import java.util.List;

public interface AboutService {

    AboutResponseDTO createAbout(AboutRequestDTO aboutRequestDTO);

    List<AboutResponseDTO> getAbouts();
}

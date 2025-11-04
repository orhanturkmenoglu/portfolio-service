package com.example.portfolio.service.core.about.service.impl;

import com.example.portfolio.service.core.about.dto.request.AboutRequestDTO;
import com.example.portfolio.service.core.about.dto.response.AboutResponseDTO;
import com.example.portfolio.service.core.about.model.About;
import com.example.portfolio.service.core.about.repository.AboutRepository;
import com.example.portfolio.service.core.about.service.AboutService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
@Slf4j
public class AboutServiceImpl implements AboutService {
    private final AboutRepository aboutRepository;

    @Override
    public AboutResponseDTO createAbout(AboutRequestDTO aboutRequestDTO) {
       log.info("AboutServiceImpl.createAbout() method called");

        if (Objects.isNull(aboutRequestDTO)) {
            log.error("AboutServiceImpl.createAbout() received null AboutRequestDTO");
            throw new IllegalArgumentException("AboutRequestDTO cannot be null");
        }
       About about = About.builder()
               .title(aboutRequestDTO.getTitle())
               .description(aboutRequestDTO.getDescription())
               .icon(aboutRequestDTO.getIcon())
               .color(aboutRequestDTO.getColor())
               .createdAt(LocalDateTime.now())
               .updatedAt(LocalDateTime.now())
               .build();
        About savedAbout = aboutRepository.save(about);
        log.info("AboutServiceImpl.createAbout() method success, id={}", savedAbout.getId());

        return convertToAboutResponseDTO(savedAbout);
    }

    @Override
    public List<AboutResponseDTO> getAbouts() {
       return aboutRepository.findAll()
               .stream()
               .map(this::convertToAboutResponseDTO)
               .toList();
    }

    private AboutResponseDTO convertToAboutResponseDTO(About about) {
        return AboutResponseDTO.builder()
                .id(about.getId())
                .title(about.getTitle())
                .description(about.getDescription())
                .icon(about.getIcon())
                .color(about.getColor())
                .createdAt(about.getCreatedAt())
                .updatedAt(about.getUpdatedAt())
                .build();
    }
}

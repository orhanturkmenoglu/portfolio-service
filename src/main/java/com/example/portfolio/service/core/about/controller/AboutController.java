package com.example.portfolio.service.core.about.controller;

import com.example.portfolio.service.core.about.dto.request.AboutRequestDTO;
import com.example.portfolio.service.core.about.dto.response.AboutResponseDTO;
import com.example.portfolio.service.core.about.service.AboutService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/about")
@RequiredArgsConstructor
public class AboutController {

    private final AboutService aboutService;

    @PostMapping
    public ResponseEntity<AboutResponseDTO> createAbout(@Valid @RequestBody AboutRequestDTO aboutRequestDTO) {
        AboutResponseDTO aboutResponseDTO = aboutService.createAbout(aboutRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(aboutResponseDTO);
    }
}

package com.example.portfolio.service.core.about.controller;

import com.example.portfolio.service.core.about.dto.request.AboutRequestDTO;
import com.example.portfolio.service.core.about.dto.response.AboutResponseDTO;
import com.example.portfolio.service.core.about.service.AboutService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/abouts")
@RequiredArgsConstructor
@CrossOrigin("*")
public class AboutController {

    private final AboutService aboutService;

    @PostMapping
    public ResponseEntity<AboutResponseDTO> createAbout(@Valid @RequestBody AboutRequestDTO aboutRequestDTO) {
        AboutResponseDTO aboutResponseDTO = aboutService.createAbout(aboutRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(aboutResponseDTO);
    }

    @GetMapping
    public ResponseEntity<List<AboutResponseDTO>> getAbouts (){
        return ResponseEntity.ok(aboutService.getAbouts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AboutResponseDTO> getAboutById(@PathVariable String id) {
        AboutResponseDTO about = aboutService.getAboutById(id);
        return ResponseEntity.ok(about);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AboutResponseDTO> updateAboutById(
            @PathVariable String id,
            @Valid @RequestBody AboutRequestDTO aboutRequestDTO
    ) {
        AboutResponseDTO updated = aboutService.updateAboutById(id, aboutRequestDTO);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAboutById(@PathVariable String id) {
        aboutService.deleteAboutById(id);
        return ResponseEntity.noContent().build();
    }
}

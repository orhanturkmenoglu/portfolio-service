package com.example.portfolio.service.core.work.controller;

import com.example.portfolio.service.core.work.dto.request.WorkRequestDTO;
import com.example.portfolio.service.core.work.dto.response.WorkResponseDTO;
import com.example.portfolio.service.core.work.service.WorkService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/works")
@RequiredArgsConstructor
public class WorkController {
    private final WorkService workService;

    @PostMapping
    public ResponseEntity<WorkResponseDTO> createWork(@Valid @RequestBody WorkRequestDTO dto) {
        return ResponseEntity.ok(workService.createWork(dto));
    }

    @GetMapping
    public ResponseEntity<List<WorkResponseDTO>> getAllWorks() {
        return ResponseEntity.ok(workService.getAllWorks());
    }

    @GetMapping("/{id}")
    public ResponseEntity<WorkResponseDTO> getWorkById(@PathVariable String id) {
        return ResponseEntity.ok(workService.getWorkById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<WorkResponseDTO> updateWork(@PathVariable String id, @Valid @RequestBody WorkRequestDTO dto) {
        return ResponseEntity.ok(workService.updateWorkById(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWork(@PathVariable String id) {
        workService.deleteWorkById(id);
        return ResponseEntity.noContent().build();
    }
}

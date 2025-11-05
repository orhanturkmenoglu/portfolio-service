package com.example.portfolio.service.core.work.controller;

import com.example.portfolio.service.core.work.dto.request.WorkRequestDTO;
import com.example.portfolio.service.core.work.dto.response.WorkResponseDTO;
import com.example.portfolio.service.core.work.service.WorkService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/works")
@RequiredArgsConstructor
@Tag(name = "Work", description = "Work API - Manage portfolio work experiences")
public class WorkController {

    private final WorkService workService;

    @Operation(
            summary = "Create a new work experience",
            description = "Adds a new work experience entry to the portfolio.",
            responses = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "Work experience created successfully",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = WorkResponseDTO.class)
                            )
                    ),
                    @ApiResponse(responseCode = "400", description = "Invalid request data")
            }
    )
    @PostMapping
    public ResponseEntity<WorkResponseDTO> createWork(@Valid @RequestBody WorkRequestDTO dto) {
        WorkResponseDTO created = workService.createWork(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @Operation(
            summary = "Get all work experiences",
            description = "Retrieves all work experience entries.",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Successful",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = WorkResponseDTO.class)
                            )
                    )
            }
    )
    @GetMapping
    public ResponseEntity<List<WorkResponseDTO>> getAllWorks() {
        List<WorkResponseDTO> list = workService.getAllWorks();
        return ResponseEntity.ok(list);
    }

    @Operation(
            summary = "Get work experience by ID",
            description = "Retrieves a work experience entry by its ID.",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Successful",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = WorkResponseDTO.class)
                            )
                    ),
                    @ApiResponse(responseCode = "404", description = "Work experience not found")
            }
    )
    @GetMapping("/{id}")
    public ResponseEntity<WorkResponseDTO> getWorkById(@PathVariable String id) {
        WorkResponseDTO dto = workService.getWorkById(id);
        return ResponseEntity.ok(dto);
    }

    @Operation(
            summary = "Update work experience by ID",
            description = "Updates an existing work experience entry by its ID.",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Update successful",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = WorkResponseDTO.class)
                            )
                    ),
                    @ApiResponse(responseCode = "404", description = "Work experience not found"),
                    @ApiResponse(responseCode = "400", description = "Invalid request data")
            }
    )
    @PutMapping("/{id}")
    public ResponseEntity<WorkResponseDTO> updateWork(@PathVariable String id, @Valid @RequestBody WorkRequestDTO dto) {
        WorkResponseDTO updated = workService.updateWorkById(id, dto);
        return ResponseEntity.ok(updated);
    }

    @Operation(
            summary = "Delete work experience by ID",
            description = "Deletes a work experience entry by its ID.",
            responses = {
                    @ApiResponse(responseCode = "204", description = "Delete successful"),
                    @ApiResponse(responseCode = "404", description = "Work experience not found")
            }
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWork(@PathVariable String id) {
        workService.deleteWorkById(id);
        return ResponseEntity.noContent().build();
    }
}

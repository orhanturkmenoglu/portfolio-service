package com.example.portfolio.service.core.about.controller;

import com.example.portfolio.service.core.about.dto.request.AboutRequestDTO;
import com.example.portfolio.service.core.about.dto.response.AboutResponseDTO;
import com.example.portfolio.service.core.about.service.AboutService;
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
@RequestMapping("/abouts")
@RequiredArgsConstructor
@CrossOrigin("*")
@Tag(name = "About", description = "About API - Manage portfolio information")
public class AboutController {

    private final AboutService aboutService;

    @Operation(
            summary = "Create a new About record",
            description = "Creates a new About entry in the system.",
            responses = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "About created successfully",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = AboutResponseDTO.class)
                            )
                    ),
                    @ApiResponse(responseCode = "400", description = "Invalid request data")
            })
    @PostMapping
    public ResponseEntity<AboutResponseDTO> createAbout(@Valid @RequestBody AboutRequestDTO aboutRequestDTO) {
        AboutResponseDTO aboutResponseDTO = aboutService.createAbout(aboutRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(aboutResponseDTO);
    }

    @Operation(
            summary = "Get all About records",
            description = "Retrieves a list of all About records in the system.",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Successful",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = AboutResponseDTO.class)
                            )
                    )
            }
    )
    @GetMapping
    public ResponseEntity<List<AboutResponseDTO>> getAbouts (){
        return ResponseEntity.ok(aboutService.getAbouts());
    }

    @Operation(
            summary = "Get About by ID",
            description = "Retrieves an About record by its ID.",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Successful",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = AboutResponseDTO.class)
                            )
                    ),
                    @ApiResponse(responseCode = "404", description = "Record not found")
            }
    )
    @GetMapping("/{id}")
    public ResponseEntity<AboutResponseDTO> getAboutById(@PathVariable String id) {
        AboutResponseDTO about = aboutService.getAboutById(id);
        return ResponseEntity.ok(about);
    }


    @Operation(
            summary = "Update About by ID",
            description = "Updates an existing About record by its ID.",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Update successful",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = AboutResponseDTO.class)
                            )
                    ),
                    @ApiResponse(responseCode = "404", description = "Record not found"),
                    @ApiResponse(responseCode = "400", description = "Invalid request data")
            }
    )
    @PutMapping("/{id}")
    public ResponseEntity<AboutResponseDTO> updateAboutById(
            @PathVariable String id,
            @Valid @RequestBody AboutRequestDTO aboutRequestDTO
    ) {
        AboutResponseDTO updated = aboutService.updateAboutById(id, aboutRequestDTO);
        return ResponseEntity.ok(updated);
    }

    @Operation(
            summary = "Delete About by ID",
            description = "Deletes an About record by its ID.",
            responses = {
                    @ApiResponse(responseCode = "204", description = "Delete successful"),
                    @ApiResponse(responseCode = "404", description = "Record not found")
            }
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAboutById(@PathVariable String id) {
        aboutService.deleteAboutById(id);
        return ResponseEntity.noContent().build();
    }
}

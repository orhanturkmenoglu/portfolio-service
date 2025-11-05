package com.example.portfolio.service.core.project.controller;

import com.example.portfolio.service.common.base.BaseResponse;
import com.example.portfolio.service.core.project.dto.request.ProjectRequestDTO;
import com.example.portfolio.service.core.project.dto.response.ProjectResponseDTO;
import com.example.portfolio.service.core.project.service.ProjectService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
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
@RequestMapping("/projects")
@RequiredArgsConstructor
@Tag(name = "Project", description = "Project API - Manage portfolio projects")
public class ProjectController {

    private final ProjectService projectService;

    @Operation(
            summary = "Create a new project",
            description = "Creates a new project entry in the portfolio.",
            responses = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "Project created successfully",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = BaseResponse.class)
                            )
                    ),
                    @ApiResponse(responseCode = "400", description = "Invalid request data")
            }
    )
    @PostMapping
    public ResponseEntity<BaseResponse<ProjectResponseDTO>> createProject(@Valid @RequestBody ProjectRequestDTO dto) {
        ProjectResponseDTO created = projectService.createProject(dto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(BaseResponse.success(
                        created,
                        "Project created successfully",
                        HttpStatus.CREATED.value()
                ));
    }

    @Operation(
            summary = "Get all projects",
            description = "Retrieves a list of all projects.",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Successful",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = BaseResponse.class)
                            )
                    )
            }
    )
    @GetMapping
    public ResponseEntity<BaseResponse<List<ProjectResponseDTO>>> getProjects() {
        List<ProjectResponseDTO> list = projectService.getProjects();
        return ResponseEntity.ok(BaseResponse.success(
                list,
                "Fetched all projects",
                HttpStatus.OK.value()
        ));
    }

    @Operation(
            summary = "Get project by ID",
            description = "Retrieves a project by its ID.",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Successful",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = BaseResponse.class)
                            )
                    ),
                    @ApiResponse(responseCode = "404", description = "Project not found")
            }
    )
    @GetMapping("/{id}")
    public ResponseEntity<BaseResponse<ProjectResponseDTO>> getProjectById(@PathVariable String id) {
        ProjectResponseDTO dto = projectService.getProjectById(id);
        return ResponseEntity.ok(BaseResponse.success(
                dto,
                "Fetched project",
                HttpStatus.OK.value()
        ));
    }

    @Operation(
            summary = "Update project by ID",
            description = "Updates an existing project entry by its ID.",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Update successful",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = BaseResponse.class)
                            )
                    ),
                    @ApiResponse(responseCode = "404", description = "Project not found"),
                    @ApiResponse(responseCode = "400", description = "Invalid request data")
            }
    )
    @PutMapping("/{id}")
    public ResponseEntity<BaseResponse<ProjectResponseDTO>> updateProjectById(
            @PathVariable String id,
            @Valid @RequestBody ProjectRequestDTO dto
    ) {
        ProjectResponseDTO updated = projectService.updateProjectById(id, dto);
        return ResponseEntity.ok(BaseResponse.success(
                updated,
                "Project updated successfully",
                HttpStatus.OK.value()
        ));
    }

    @Operation(
            summary = "Delete project by ID",
            description = "Deletes a project by its ID.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Delete successful",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = BaseResponse.class)
                            )),
                    @ApiResponse(responseCode = "404", description = "Project not found")
            }
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<BaseResponse<Void>> deleteProjectById(@PathVariable String id) {
        projectService.deleteProjectById(id);
        return ResponseEntity.ok(BaseResponse.success(
                null,
                "Project deleted successfully",
                HttpStatus.OK.value()
        ));
    }
}

package com.example.portfolio.service.core.skill.controller;

import com.example.portfolio.service.common.base.BaseResponse;
import com.example.portfolio.service.core.skill.dto.request.SkillRequestDTO;
import com.example.portfolio.service.core.skill.dto.response.SkillResponseDTO;
import com.example.portfolio.service.core.skill.service.SkillService;
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
@RequestMapping("/skills")
@RequiredArgsConstructor
@Tag(name = "Skill", description = "Skill API - Manage portfolio skills")
public class SkillController {

    private final SkillService skillService;

    @Operation(
            summary = "Create a new skill",
            description = "Creates a new skill entry in the portfolio.",
            responses = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "Skill created successfully",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = BaseResponse.class)
                            )
                    ),
                    @ApiResponse(responseCode = "400", description = "Invalid request data")
            }
    )
    @PostMapping
    public ResponseEntity<BaseResponse<SkillResponseDTO>> createSkill(@Valid @RequestBody SkillRequestDTO requestDTO) {
        SkillResponseDTO created = skillService.createSkill(requestDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(BaseResponse.success(
                        created,
                        "Skill created successfully",
                        HttpStatus.CREATED.value()
                ));
    }

    @Operation(
            summary = "Get all skills",
            description = "Retrieves a list of all skills.",
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
    public ResponseEntity<BaseResponse<List<SkillResponseDTO>>> getAllSkills() {
        List<SkillResponseDTO> list = skillService.getAllSkills();
        return ResponseEntity.ok(BaseResponse.success(
                list,
                "Fetched all skills",
                HttpStatus.OK.value()
        ));
    }

    @Operation(
            summary = "Get skill by ID",
            description = "Retrieves a skill by its ID.",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Successful",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = BaseResponse.class)
                            )
                    ),
                    @ApiResponse(responseCode = "404", description = "Skill not found")
            }
    )
    @GetMapping("/{id}")
    public ResponseEntity<BaseResponse<SkillResponseDTO>> getSkillById(@PathVariable String id) {
        SkillResponseDTO dto = skillService.getSkillById(id);
        return ResponseEntity.ok(BaseResponse.success(
                dto,
                "Fetched skill",
                HttpStatus.OK.value()
        ));
    }

    @Operation(
            summary = "Update skill by ID",
            description = "Updates an existing skill by its ID.",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Update successful",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = BaseResponse.class)
                            )
                    ),
                    @ApiResponse(responseCode = "404", description = "Skill not found"),
                    @ApiResponse(responseCode = "400", description = "Invalid request data")
            }
    )
    @PutMapping("/{id}")
    public ResponseEntity<BaseResponse<SkillResponseDTO>> updateSkill(
            @PathVariable String id, @Valid @RequestBody SkillRequestDTO requestDTO) {
        SkillResponseDTO updated = skillService.updateSkill(id, requestDTO);
        return ResponseEntity.ok(BaseResponse.success(
                updated,
                "Skill updated successfully",
                HttpStatus.OK.value()
        ));
    }

    @Operation(
            summary = "Delete skill by ID",
            description = "Deletes a skill by its ID.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Delete successful",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = BaseResponse.class)
                            )),
                    @ApiResponse(responseCode = "404", description = "Skill not found")
            }
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<BaseResponse<Void>> deleteSkill(@PathVariable String id) {
        skillService.deleteSkill(id);
        return ResponseEntity.ok(BaseResponse.success(
                null,
                "Skill deleted successfully",
                HttpStatus.OK.value()
        ));
    }
}

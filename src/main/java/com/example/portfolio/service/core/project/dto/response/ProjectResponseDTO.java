package com.example.portfolio.service.core.project.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Schema(description = "Project Response DTO")
public record ProjectResponseDTO(

        @Schema(description = "Project ID", example = "1", required = true)
        String id,

        @Schema(description = "Project title", example = "Project 1", required = true)
        String title,

        @Schema(description = "Project description", example = "Project 1 description", required = true)
        String description,

        @Schema(description = "Project image", example = "Project 1 image", required = true)
        String image,

        @Schema(description = "Project tech", example = "Project 1 link", required = true)
        List<String> tech,

        @Schema(description = "Project demo", example = "Project 1 demo", required = true)
        String demo,

        @Schema(description = "Project code", example = "Project 1 code", required = true)
        String code,

        @Schema(description = "Project createdAt", example = "05-11-2025", required = true)
        @JsonFormat(pattern = "dd-MM-YYYY")
        LocalDateTime createdAt,

        @Schema(description = "Project updatedAt", example = "05-11-2025", required = true)
        @JsonFormat(pattern = "dd-MM-YYYY")
        LocalDateTime updatedAt
) {}

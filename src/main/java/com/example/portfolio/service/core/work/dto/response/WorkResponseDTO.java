package com.example.portfolio.service.core.work.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Schema(description = "Work experience response data")
public record WorkResponseDTO(
        @Schema(description = "Unique ID of the work experience", example = "1")
        String id,

        @Schema(description = "Job role or position", example = "Backend Developer")
        String role,

        @Schema(description = "Company name", example = "ABC Corp")
        String company,

        @Schema(description = "Employment duration", example = "Jan 2023 - Nov 2025")
        String duration,

        @Schema(description = "Detailed job description", example = "Developed REST APIs and backend services")
        String description,

        @Schema(description = "UI color representation for this work entry", example = "#FF5733")
        String color,

        @Schema(description = "Creation timestamp", example = "01-11-2025")
        @JsonFormat(pattern = "dd-MM-yyyy")
        LocalDateTime createdAt,

        @Schema(description = "Last update timestamp", example = "05-11-2025")
        @JsonFormat(pattern = "dd-MM-yyyy")
        LocalDateTime updatedAt
) {}
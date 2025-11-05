package com.example.portfolio.service.core.skill.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Schema(description = "Skill response data")
public record SkillResponseDTO(
        @Schema(description = "Unique skill ID", example = "1")
        String id,

        @Schema(description = "Skill title", example = "Java")
        String title,

        @Schema(description = "Icon URL or class", example = "https://example.com/icons/java.png")
        String icon,

        @Schema(description = "Detailed description", example = "Experienced in Java backend development")
        String description,

        @Schema(description = "Skill tags", example = "[\"Backend\", \"Spring\"]")
        List<String> tags,

        @Schema(description = "Creation timestamp", example = "01-11-2025")
        @JsonFormat(pattern = "dd-MM-yyyy")
        LocalDateTime createdAt,

        @Schema(description = "Last update timestamp", example = "05-11-2025")
        @JsonFormat(pattern = "dd-MM-yyyy")
        LocalDateTime updatedAt
) {}

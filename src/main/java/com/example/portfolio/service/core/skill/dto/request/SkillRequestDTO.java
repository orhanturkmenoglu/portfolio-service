package com.example.portfolio.service.core.skill.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Skill Request DTO")
public class SkillRequestDTO {

    @NotBlank(message = "Title is required")
    @Schema(description = "Skill title", example = "Skill 1", required = true)
    private String title;

    @NotBlank(message = "Icon is required")
    @Schema(description = "Skill icon", example = "Skill 1 icon", required = true)
    private String icon;

    @NotBlank(message = "Description is required")
    @Schema(description = "Skill description", example = "Skill 1 description", required = true)
    private String description;

    @Size(min = 1, max = 50, message = "Each tag must be between 1 and 50 characters")
    @Schema(description = "Skill tags", example = "Skill 1 tags", required = true)
    private List<String> tags;
}

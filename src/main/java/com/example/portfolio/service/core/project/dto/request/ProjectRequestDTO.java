package com.example.portfolio.service.core.project.dto.request;

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
@Schema(description = "Project Request DTO")
public class ProjectRequestDTO {

    @NotBlank(message = "Title is required")
    @Schema(description = "Title of the project", example = "Project 1")
    private String title;

    @NotBlank(message = "Description is required")
    @Schema(description = "Description of the project", example = "This is a project")
    private String description;

    @NotBlank(message = "Image is required")
    @Schema(description = "Image of the project", example = "https://example.com/image.jpg")
    private String image;

    @Size(min = 1, message = "At least one technology is required")
    @Schema(description = "Technologies used in the project", example = "[\"Java\", \"Spring Boot\"]")
    private List<@Size(min = 1) String> tech;

    @Size(min = 1, message = "At least one icon is required")
    @Schema(description = "Icons of the project", example = "[\"icon1\", \"icon2\"]")
    private List<@Size(min = 1) String> icons;

    @NotBlank(message = "Demo link is required")
    @Schema(description = "Demo link of the project", example = "https://example.com/demo")
    private String demo;

    @NotBlank(message = "Code link is required")
    @Schema(description = "Code link of the project", example = "https://example.com/code")
    private String code;
}

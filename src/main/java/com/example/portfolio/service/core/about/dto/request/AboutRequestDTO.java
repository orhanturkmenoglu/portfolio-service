package com.example.portfolio.service.core.about.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(description = "Request DTO for creating a new About record")
public class AboutRequestDTO {
    @NotBlank(message = "Title cannot be blank")
    @Size(max = 100, message = "Title cannot exceed 100 characters")
    @Schema(description = "Title of the About section", example = "About Me")
    private String title;

    @NotBlank(message = "Description cannot be blank")
    @Size(max = 1000, message = "Description cannot exceed 1000 characters")
    @Schema(description = "Description text", example = "I am a frontend and backend developer.")
    private String description;

    @NotBlank(message = "Icon cannot be blank")
    @Schema(description = "Icon for the About section", example = "fa-user")
    private String icon;

    @NotBlank(message = "Color cannot be blank")
    @Schema(description = "Color for the About section", example = "blue")
    private String color;
}

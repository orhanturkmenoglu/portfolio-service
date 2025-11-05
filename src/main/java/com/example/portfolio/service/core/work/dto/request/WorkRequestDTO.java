package com.example.portfolio.service.core.work.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Work Request DTO")
public class WorkRequestDTO {
    @NotBlank(message = "Role cannot be blank")
    @Schema(description = "Job role or position", example = "Backend Developer")
    private String role;

    @NotBlank(message = "Company cannot be blank")
    @Schema(description = "Company name", example = "ABC Corp")
    private String company;

    @NotBlank(message = "Duration cannot be blank")
    @Schema(description = "Employment duration", example = "Jan 2023 - Nov 2025")
    private String duration;

    @NotBlank(message = "Description cannot be blank")
    @Schema(description = "Detailed job description", example = "Developed REST APIs and backend services")
    private String description;

    @NotBlank(message = "Color cannot be blank")
    @Schema(description = "UI color representation for this work entry", example = "#FF5733")
    private String color;
}

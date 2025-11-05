package com.example.portfolio.service.core.project.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProjectRequestDTO {

    @NotBlank(message = "Title is required")
    private String title;
    @NotBlank(message = "Description is required")
    private String description;

    @NotBlank(message = "Image is required")
    private String image;

    @Size(min = 1, message = "At least one technology is required")
    private List<@Size(min = 1) String> tech;

    @Size(min = 1, message = "At least one icon is required")
    private List<@Size(min = 1) String> icons;

    @NotBlank(message = "Demo link is required")
    private String demo;

    @NotBlank(message = "Code link is required")
    private String code;
}

package com.example.portfolio.service.core.skill.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SkillRequestDTO {

    @NotBlank(message = "Title is required")
    private String title;

    @NotBlank(message = "Icon is required")
    private String icon;

    @NotBlank(message = "Description is required")
    private String description;

    @Size(min = 1, max = 50, message = "Each tag must be between 1 and 50 characters")
    private List<String> tags;
}

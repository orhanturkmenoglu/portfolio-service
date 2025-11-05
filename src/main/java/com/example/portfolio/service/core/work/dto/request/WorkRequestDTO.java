package com.example.portfolio.service.core.work.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WorkRequestDTO {
    @NotBlank(message = "Role cannot be blank")
    private String role;

    @NotBlank(message = "Company cannot be blank")
    private String company;

    @NotBlank(message = "Duration cannot be blank")
    private String duration;

    @NotBlank(message = "Description cannot be blank")
    private String description;

    @NotBlank(message = "Color cannot be blank")
    private String color;
}

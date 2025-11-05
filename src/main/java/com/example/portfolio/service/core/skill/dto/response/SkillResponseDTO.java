package com.example.portfolio.service.core.skill.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;
import java.util.List;

public record SkillResponseDTO(String id, String title,
                               String icon, String description,
                               List<String> tags,
                               @JsonFormat(pattern = "dd-MM-YYYY")
                               LocalDateTime createdAt,
                               @JsonFormat(pattern = "dd-MM-YYYY")
                               LocalDateTime updatedAt) {
}

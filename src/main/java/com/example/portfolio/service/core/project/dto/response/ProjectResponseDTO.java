package com.example.portfolio.service.core.project.dto.response;

import java.time.LocalDateTime;
import java.util.List;

public record ProjectResponseDTO(
        String id,
        String title,
        String description,
        String image,
        List<String> tech,
        List<String> icons,
        String demo,
        String code,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {}

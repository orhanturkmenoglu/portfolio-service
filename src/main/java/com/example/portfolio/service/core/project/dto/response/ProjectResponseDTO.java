package com.example.portfolio.service.core.project.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDateTime;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record ProjectResponseDTO(
        String id,
        String title,
        String description,
        String image,
        List<String> tech,
        List<String> icons,
        String demo,
        String code,
        @JsonFormat(pattern = "dd-MM-YYYY")
        LocalDateTime createdAt,
        @JsonFormat(pattern = "dd-MM-YYYY")
        LocalDateTime updatedAt
) {}

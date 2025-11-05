package com.example.portfolio.service.core.work.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public record WorkResponseDTO(String id, String role, String company,
                              String duration, String description,
                              String color,
                              @JsonFormat(pattern = "dd-MM-YYYY")
                              LocalDateTime createdAt,
                              @JsonFormat(pattern = "dd-MM-YYYY")
                              LocalDateTime updatedAt) {
}

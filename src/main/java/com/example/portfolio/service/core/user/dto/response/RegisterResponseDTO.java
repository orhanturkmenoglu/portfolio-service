package com.example.portfolio.service.core.user.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDateTime;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record RegisterResponseDTO(
        String id,
        String fullName,
        String email,
        String role,
        String status,
        String image,
        @JsonFormat(pattern = "dd-MM-yyyy")
        LocalDateTime createdAt,
        @JsonFormat(pattern = "dd-MM-yyyy")
        LocalDateTime updatedAt
) {}


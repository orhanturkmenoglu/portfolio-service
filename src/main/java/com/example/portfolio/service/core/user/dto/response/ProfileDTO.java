package com.example.portfolio.service.core.user.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;

import java.time.LocalDateTime;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
public record ProfileDTO(String id,
                         String email,
                         String fullName,
                         String role,
                         @JsonFormat(pattern = "dd-MM-YYYY")
                         LocalDateTime createdAt,
                         @JsonFormat(pattern = "dd-MM-YYYY")
                         LocalDateTime updatedAt) {
}

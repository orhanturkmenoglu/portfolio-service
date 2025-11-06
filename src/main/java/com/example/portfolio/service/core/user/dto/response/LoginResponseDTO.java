package com.example.portfolio.service.core.user.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
public record LoginResponseDTO(String email,
                               String token) {
}

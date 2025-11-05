package com.example.portfolio.service.core.user.dto.request;

import com.example.portfolio.service.common.validation.RegexEmail;
import com.example.portfolio.service.common.validation.RegexPassword;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterRequestDTO {

    @NotBlank(message = "Full name is required")
    private String fullName;
    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    @RegexEmail
    private String email;
    @NotBlank(message = "Password is required")
    @RegexPassword
    private String password;
}

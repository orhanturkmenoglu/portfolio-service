package com.example.portfolio.service.core.user.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection ="users")
public class User {
    @Id
    private String id;
    private String fullName;
    private String email;
    private String password;
    private String role;
    private Boolean isAccountVerified;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}

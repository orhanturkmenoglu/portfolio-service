package com.example.portfolio.service.core.work.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "works")
public class Work {

    @Id
    private String id;
    private String role;
    private String company;
    private String duration;
    private String description;
    private String color;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
package com.example.portfolio.service.core.skill.model;


import com.example.portfolio.service.core.user.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "skills")
public class Skill {
    @Id
    private String id;
    private String userId;
    private String title;
    private String icon;
    private String description;
    private List<String> tags;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}

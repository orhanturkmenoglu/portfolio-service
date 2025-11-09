package com.example.portfolio.service.core.skill.repository;

import com.example.portfolio.service.core.skill.model.Skill;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillRepository extends MongoRepository<Skill, String> {

    long countByUserId(String userId);
}
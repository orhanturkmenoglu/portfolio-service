package com.example.portfolio.service.core.skill.service;

import com.example.portfolio.service.core.skill.dto.request.SkillRequestDTO;
import com.example.portfolio.service.core.skill.dto.response.SkillResponseDTO;

import java.util.List;

public interface SkillService {
    SkillResponseDTO createSkill(SkillRequestDTO requestDTO);
    List<SkillResponseDTO> getAllSkills();
    SkillResponseDTO getSkillById(String id);
    SkillResponseDTO updateSkill(String id, SkillRequestDTO requestDTO);
    void deleteSkill(String id);
}

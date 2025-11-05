package com.example.portfolio.service.core.skill.service.impl;

import com.example.portfolio.service.core.skill.dto.request.SkillRequestDTO;
import com.example.portfolio.service.core.skill.dto.response.SkillResponseDTO;
import com.example.portfolio.service.core.skill.mapper.SkillMapper;
import com.example.portfolio.service.core.skill.repository.SkillRepository;
import com.example.portfolio.service.core.skill.service.SkillService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
@Slf4j
public class SkillServiceImpl implements SkillService {
    private final SkillRepository skillRepository;
    private final SkillMapper skillMapper;

    @Transactional
    @Override
    public SkillResponseDTO createSkill(SkillRequestDTO requestDTO) {
       log.info("Creating skill: {}", requestDTO);
       if (Objects.isNull(requestDTO)) {
           throw new IllegalArgumentException("RequestDTO cannot be null");
       }

       var skill = skillMapper.toEntity(requestDTO);
       skill.setCreatedAt(LocalDateTime.now());
       skill.setUpdatedAt(LocalDateTime.now());

       var savedSkill = skillRepository.save(skill);
       return skillMapper.toResponseDTO(savedSkill);
    }

    @Override
    public List<SkillResponseDTO> getAllSkills() {
        return skillRepository.findAll()
                .stream()
                .map(skillMapper::toResponseDTO)
                .toList();
    }

    @Override
    public SkillResponseDTO getSkillById(String id) {
        log.info("Fetching skill by id: {}", id);
        return skillRepository.findById(id)
                .map(skillMapper::toResponseDTO)
                .orElseThrow(() -> new IllegalArgumentException("Skill not found"));
    }

    @Override
    public SkillResponseDTO updateSkill(String id, SkillRequestDTO requestDTO) {
       log.info("Updating skill with id: {}", id);

       var existingSkill = skillRepository.findById(id)
               .orElseThrow(() -> new IllegalArgumentException("Skill not found"));

       skillMapper.updateEntityFromDto(requestDTO, existingSkill);
       existingSkill.setUpdatedAt(LocalDateTime.now());
       var updatedSkill = skillRepository.save(existingSkill);
       log.info("Updated skill: {}", updatedSkill);
       return skillMapper.toResponseDTO(updatedSkill);
    }

    @Override
    public void deleteSkill(String id) {
        skillRepository.findById(id)
                .ifPresentOrElse(
                        skill -> {
                            skillRepository.delete(skill);
                            log.info("Skill deleted with id: {}", id);
                        },
                        () -> {
                            throw new IllegalArgumentException("Skill not found");
                        }
                );
    }
}

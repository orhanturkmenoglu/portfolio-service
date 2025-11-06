package com.example.portfolio.service.core.skill.mapper;

import com.example.portfolio.service.core.skill.dto.request.SkillRequestDTO;
import com.example.portfolio.service.core.skill.dto.response.SkillResponseDTO;
import com.example.portfolio.service.core.skill.model.Skill;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-11-06T14:53:07+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 24.0.1 (Oracle Corporation)"
)
@Component
public class SkillMapperImpl implements SkillMapper {

    @Override
    public SkillResponseDTO toResponseDTO(Skill skill) {
        if ( skill == null ) {
            return null;
        }

        String id = null;
        String title = null;
        String icon = null;
        String description = null;
        List<String> tags = null;
        LocalDateTime createdAt = null;
        LocalDateTime updatedAt = null;

        id = skill.getId();
        title = skill.getTitle();
        icon = skill.getIcon();
        description = skill.getDescription();
        List<String> list = skill.getTags();
        if ( list != null ) {
            tags = new ArrayList<String>( list );
        }
        createdAt = skill.getCreatedAt();
        updatedAt = skill.getUpdatedAt();

        SkillResponseDTO skillResponseDTO = new SkillResponseDTO( id, title, icon, description, tags, createdAt, updatedAt );

        return skillResponseDTO;
    }

    @Override
    public Skill toEntity(SkillRequestDTO skillRequestDTO) {
        if ( skillRequestDTO == null ) {
            return null;
        }

        Skill skill = new Skill();

        skill.setTitle( skillRequestDTO.getTitle() );
        skill.setIcon( skillRequestDTO.getIcon() );
        skill.setDescription( skillRequestDTO.getDescription() );
        List<String> list = skillRequestDTO.getTags();
        if ( list != null ) {
            skill.setTags( new ArrayList<String>( list ) );
        }

        return skill;
    }

    @Override
    public void updateEntityFromDto(SkillRequestDTO dto, Skill skill) {
        if ( dto == null ) {
            return;
        }

        skill.setTitle( dto.getTitle() );
        skill.setIcon( dto.getIcon() );
        skill.setDescription( dto.getDescription() );
        if ( skill.getTags() != null ) {
            List<String> list = dto.getTags();
            if ( list != null ) {
                skill.getTags().clear();
                skill.getTags().addAll( list );
            }
            else {
                skill.setTags( null );
            }
        }
        else {
            List<String> list = dto.getTags();
            if ( list != null ) {
                skill.setTags( new ArrayList<String>( list ) );
            }
        }
    }
}

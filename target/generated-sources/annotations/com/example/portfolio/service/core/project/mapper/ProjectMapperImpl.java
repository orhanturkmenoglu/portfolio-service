package com.example.portfolio.service.core.project.mapper;

import com.example.portfolio.service.core.project.dto.request.ProjectRequestDTO;
import com.example.portfolio.service.core.project.dto.response.ProjectResponseDTO;
import com.example.portfolio.service.core.project.model.Project;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-11-09T18:12:33+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 24.0.1 (Oracle Corporation)"
)
@Component
public class ProjectMapperImpl implements ProjectMapper {

    @Override
    public ProjectResponseDTO toProjectResponse(Project project) {
        if ( project == null ) {
            return null;
        }

        String id = null;
        String title = null;
        String description = null;
        String image = null;
        List<String> tech = null;
        String demo = null;
        String code = null;
        LocalDateTime createdAt = null;
        LocalDateTime updatedAt = null;

        id = project.getId();
        title = project.getTitle();
        description = project.getDescription();
        image = project.getImage();
        List<String> list = project.getTech();
        if ( list != null ) {
            tech = new ArrayList<String>( list );
        }
        demo = project.getDemo();
        code = project.getCode();
        createdAt = project.getCreatedAt();
        updatedAt = project.getUpdatedAt();

        ProjectResponseDTO projectResponseDTO = new ProjectResponseDTO( id, title, description, image, tech, demo, code, createdAt, updatedAt );

        return projectResponseDTO;
    }

    @Override
    public Project toEntity(ProjectRequestDTO projectRequestDTO) {
        if ( projectRequestDTO == null ) {
            return null;
        }

        Project.ProjectBuilder project = Project.builder();

        project.title( projectRequestDTO.getTitle() );
        project.description( projectRequestDTO.getDescription() );
        project.image( projectRequestDTO.getImage() );
        List<String> list = projectRequestDTO.getTech();
        if ( list != null ) {
            project.tech( new ArrayList<String>( list ) );
        }
        project.demo( projectRequestDTO.getDemo() );
        project.code( projectRequestDTO.getCode() );

        return project.build();
    }

    @Override
    public void updateEntityFromDto(ProjectRequestDTO dto, Project project) {
        if ( dto == null ) {
            return;
        }

        project.setTitle( dto.getTitle() );
        project.setDescription( dto.getDescription() );
        project.setImage( dto.getImage() );
        if ( project.getTech() != null ) {
            List<String> list = dto.getTech();
            if ( list != null ) {
                project.getTech().clear();
                project.getTech().addAll( list );
            }
            else {
                project.setTech( null );
            }
        }
        else {
            List<String> list = dto.getTech();
            if ( list != null ) {
                project.setTech( new ArrayList<String>( list ) );
            }
        }
        project.setDemo( dto.getDemo() );
        project.setCode( dto.getCode() );
    }
}

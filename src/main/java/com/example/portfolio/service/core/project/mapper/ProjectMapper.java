package com.example.portfolio.service.core.project.mapper;

import com.example.portfolio.service.core.project.dto.request.ProjectRequestDTO;
import com.example.portfolio.service.core.project.dto.response.ProjectResponseDTO;
import com.example.portfolio.service.core.project.model.Project;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ProjectMapper {

    ProjectResponseDTO toProjectResponse(Project project);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Project toEntity(ProjectRequestDTO projectRequestDTO);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    void updateEntityFromDto(ProjectRequestDTO dto, @MappingTarget Project project);

}

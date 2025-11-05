package com.example.portfolio.service.core.project.service.impl;

import com.example.portfolio.service.core.project.dto.request.ProjectRequestDTO;
import com.example.portfolio.service.core.project.dto.response.ProjectResponseDTO;
import com.example.portfolio.service.core.project.mapper.ProjectMapper;
import com.example.portfolio.service.core.project.model.Project;
import com.example.portfolio.service.core.project.repository.ProjectRepository;
import com.example.portfolio.service.core.project.service.ProjectService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProjectServiceImpl implements ProjectService {
    private final ProjectRepository projectRepository;
    private final ProjectMapper projectMapper;

    @Override
    public ProjectResponseDTO createProject(ProjectRequestDTO dto) {
        log.info("ProjectService.createProject() called");
        if (Objects.isNull(dto)) {
            log.error("createProject received null dto");
            throw new IllegalArgumentException("ProjectRequestDTO cannot be null");
        }
        var entity = projectMapper.toEntity(dto);
        entity.setCreatedAt(LocalDateTime.now());
        entity.setUpdatedAt(LocalDateTime.now());
        var saved = projectRepository.save(entity);
        log.info("Project created, id={}", saved.getId());
        return projectMapper.toProjectResponse(saved);
    }

    @Override
    public List<ProjectResponseDTO> getProjects() {
        return projectRepository.findAll()
                .stream()
                .map(projectMapper::toProjectResponse)
                .toList();
    }

    @Override
    public ProjectResponseDTO getProjectById(String id) {
        log.info("ProjectService.getProjectById() called, id={}", id);
        return projectRepository.findById(id)
                .map(projectMapper::toProjectResponse)
                .orElseThrow(() -> {
                    log.error("Project not found, id={}", id);
                    return new IllegalArgumentException("Project not found");
                });
    }

    @Override
    public ProjectResponseDTO updateProjectById(String id, ProjectRequestDTO dto) {
        log.info("ProjectService.updateProjectById() called, id={}", id);
        var existing = projectRepository.findById(id)
                .orElseThrow(() -> {
                    log.error("Project not found, id={}", id);
                    return new IllegalArgumentException("Project not found");
                });

        projectMapper.updateEntityFromDto(dto, existing);
        existing.setUpdatedAt(LocalDateTime.now());

        var updated = projectRepository.save(existing);
        log.info("Project updated, id={}", updated.getId());
        return projectMapper.toProjectResponse(updated);
    }

    @Override
    public void deleteProjectById(String id) {
        projectRepository.findById(id)
                .ifPresentOrElse(
                        project -> {
                            projectRepository.delete(project);
                            log.info("Project deleted, id={}", id);
                        },
                        () -> {
                            log.error("Delete failed, project not found, id={}", id);
                            throw new IllegalArgumentException("Project not found");
                        }
                );
    }
}

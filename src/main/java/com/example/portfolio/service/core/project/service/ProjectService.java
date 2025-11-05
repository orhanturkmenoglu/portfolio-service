package com.example.portfolio.service.core.project.service;

import com.example.portfolio.service.core.project.dto.request.ProjectRequestDTO;
import com.example.portfolio.service.core.project.dto.response.ProjectResponseDTO;

import java.util.List;

public interface ProjectService {
    ProjectResponseDTO createProject(ProjectRequestDTO dto);
    List<ProjectResponseDTO> getProjects();
    ProjectResponseDTO getProjectById(String id);
    ProjectResponseDTO updateProjectById(String id, ProjectRequestDTO dto);
    void deleteProjectById(String id);
}

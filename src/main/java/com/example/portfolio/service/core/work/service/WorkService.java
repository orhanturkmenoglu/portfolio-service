package com.example.portfolio.service.core.work.service;

import com.example.portfolio.service.core.work.dto.request.WorkRequestDTO;
import com.example.portfolio.service.core.work.dto.response.WorkResponseDTO;

import java.util.List;

public interface WorkService {
    WorkResponseDTO createWork(WorkRequestDTO request);
    List<WorkResponseDTO> getAllWorks();
    WorkResponseDTO getWorkById(String id);
    WorkResponseDTO updateWorkById(String id, WorkRequestDTO request);
    void deleteWorkById(String id);
}

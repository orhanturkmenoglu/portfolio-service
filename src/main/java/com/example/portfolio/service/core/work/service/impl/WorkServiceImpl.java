package com.example.portfolio.service.core.work.service.impl;

import com.example.portfolio.service.core.work.dto.request.WorkRequestDTO;
import com.example.portfolio.service.core.work.dto.response.WorkResponseDTO;
import com.example.portfolio.service.core.work.mapper.WorkMapper;
import com.example.portfolio.service.core.work.repository.WorkRepository;
import com.example.portfolio.service.core.work.service.WorkService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class WorkServiceImpl implements WorkService {
    private final WorkRepository workRepository;
    private final WorkMapper workMapper;


    @Override
    public WorkResponseDTO createWork(WorkRequestDTO request) {
        log.info("Creating new work: {}", request);
        if (ObjectUtils.isEmpty(request)) {
            throw new IllegalArgumentException("Request cannot be empty");
        }

        var work = workMapper.toEntity(request);
        work.setCreatedAt(LocalDateTime.now());
        work.setUpdatedAt(LocalDateTime.now());

        var savedWork = workRepository.save(work);
        log.info("Work created successfully: {}", savedWork);
        return workMapper.toResponseDTO(savedWork);
    }


    @Cacheable("works")
    @Override
    public List<WorkResponseDTO> getAllWorks() {
        log.info("Fetching all works");
        return workRepository.findAll()
                .stream()
                .map(workMapper::toResponseDTO)
                .toList();
    }

    @Override
    public WorkResponseDTO getWorkById(String id) {
        log.info("Fetching work by id: {}", id);
        return workRepository.findById(id)
                .map(workMapper::toResponseDTO)
                .orElseThrow(() -> new IllegalArgumentException("Work not found with id: " + id));
    }

    @Override
    public WorkResponseDTO updateWorkById(String id, WorkRequestDTO request) {
       log.info("Updating work by id: {}", id);
        var work = workRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Work not found with id: " + id));

        workMapper.updateEntityFromDto(request, work);
        work.setUpdatedAt(LocalDateTime.now());

        var updatedWork = workRepository.save(work);
        log.info("Work updated successfully: {}", updatedWork);
        return workMapper.toResponseDTO(updatedWork);
    }

    @Override
    public void deleteWorkById(String id) {
        workRepository.findById(id)
                .ifPresentOrElse(
                        work -> {
                            workRepository.delete(work);
                            log.info("Work deleted successfully: {}", work);
                        },
                        () -> {
                            throw new IllegalArgumentException("Work not found with id: " + id);
                        }
                );
    }
}

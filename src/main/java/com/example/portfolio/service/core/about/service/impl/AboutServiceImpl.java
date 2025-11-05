package com.example.portfolio.service.core.about.service.impl;

import com.example.portfolio.service.core.about.dto.request.AboutRequestDTO;
import com.example.portfolio.service.core.about.dto.response.AboutResponseDTO;
import com.example.portfolio.service.core.about.mapper.AboutMapper;
import com.example.portfolio.service.core.about.repository.AboutRepository;
import com.example.portfolio.service.core.about.service.AboutService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
@Slf4j
public class AboutServiceImpl implements AboutService {
    private final AboutRepository aboutRepository;
    private final AboutMapper aboutMapper;

    @Transactional
    @Override
    public AboutResponseDTO createAbout(AboutRequestDTO aboutRequestDTO) {
       log.info("AboutServiceImpl.createAbout() method called");

        if (Objects.isNull(aboutRequestDTO)) {
            log.error("AboutServiceImpl.createAbout() received null AboutRequestDTO");
            throw new IllegalArgumentException("AboutRequestDTO cannot be null");
        }

        var about = aboutMapper.toEntity(aboutRequestDTO);
        about.setCreatedAt(LocalDateTime.now());
        about.setUpdatedAt(LocalDateTime.now());

        var savedAbout = aboutRepository.save(about);
        log.info("AboutServiceImpl.createAbout() method success, id={}", savedAbout.getId());

        return aboutMapper.toResponseDTO(savedAbout);
    }

    @Cacheable("abouts")
    @Override
    public List<AboutResponseDTO> getAbouts() {
       return aboutRepository.findAll()
               .stream()
               .map(aboutMapper::toResponseDTO)
               .toList();
    }

    @Override
    public AboutResponseDTO getAboutById(String id) {
        log.info("AboutServiceImpl.getAboutById() method called, id={}", id);

        return aboutRepository.findById(id)
                .map(aboutMapper::toResponseDTO)
                .orElseThrow(() -> {
            log.error("AboutServiceImpl.getAboutById() method failed, id={}", id);
            return new IllegalArgumentException("About not found");
        });
    }

    @Override
    public void deleteAboutById(String id) {
        aboutRepository.findById(id)
                .ifPresentOrElse(
                        about -> {
                            aboutRepository.delete(about);
                            log.info("AboutServiceImpl.deleteAboutById() method success, id={}", id);
                        },
                        () -> {
                            log.error("AboutServiceImpl.deleteAboutById() method failed, id={}", id);
                            throw new IllegalArgumentException("About not found");
                        });
    }

    @Override
    public AboutResponseDTO updateAboutById(String id, AboutRequestDTO aboutRequestDTO) {
        log.info("AboutServiceImpl.updateAboutById() method called, id={}", id);

        var existingAbout = aboutRepository.findById(id)
                .orElseThrow(() -> {
                    log.error("AboutServiceImpl.updateAboutById() method failed, id={}", id);
                    return new IllegalArgumentException("About not found");
                });

        aboutMapper.updateEntityFromDto(aboutRequestDTO, existingAbout);
        existingAbout.setUpdatedAt(LocalDateTime.now());

        var updatedAbout = aboutRepository.save(existingAbout);
        log.info("AboutServiceImpl.updateAboutById() method success, id={}", updatedAbout.getId());
        return aboutMapper.toResponseDTO(updatedAbout);
    }

}

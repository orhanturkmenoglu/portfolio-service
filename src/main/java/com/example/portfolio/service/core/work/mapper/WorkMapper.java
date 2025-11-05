package com.example.portfolio.service.core.work.mapper;

import com.example.portfolio.service.core.work.dto.request.WorkRequestDTO;
import com.example.portfolio.service.core.work.dto.response.WorkResponseDTO;
import com.example.portfolio.service.core.work.model.Work;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface WorkMapper {
    WorkResponseDTO toResponseDTO(Work work);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Work toEntity(WorkRequestDTO dto);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    void updateEntityFromDto(WorkRequestDTO dto,@MappingTarget Work work);

}

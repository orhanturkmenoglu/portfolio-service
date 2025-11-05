package com.example.portfolio.service.core.about.mapper;

import com.example.portfolio.service.core.about.dto.request.AboutRequestDTO;
import com.example.portfolio.service.core.about.dto.response.AboutResponseDTO;
import com.example.portfolio.service.core.about.model.About;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface AboutMapper {

    // Entity -> ResponseDTO
    AboutResponseDTO toResponseDTO(About about);

    // RequestDTO -> Entity (create işlemleri için)
    @Mapping(target = "id",ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    About toEntity(AboutRequestDTO aboutRequestDTO);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    void updateEntityFromDto(AboutRequestDTO dto, @MappingTarget About about);

}

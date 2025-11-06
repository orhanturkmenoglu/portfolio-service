package com.example.portfolio.service.core.about.mapper;

import com.example.portfolio.service.core.about.dto.request.AboutRequestDTO;
import com.example.portfolio.service.core.about.dto.response.AboutResponseDTO;
import com.example.portfolio.service.core.about.model.About;
import java.time.LocalDateTime;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-11-06T14:22:42+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 24.0.1 (Oracle Corporation)"
)
@Component
public class AboutMapperImpl implements AboutMapper {

    @Override
    public AboutResponseDTO toResponseDTO(About about) {
        if ( about == null ) {
            return null;
        }

        String id = null;
        String title = null;
        String description = null;
        String icon = null;
        String color = null;
        LocalDateTime createdAt = null;
        LocalDateTime updatedAt = null;

        id = about.getId();
        title = about.getTitle();
        description = about.getDescription();
        icon = about.getIcon();
        color = about.getColor();
        createdAt = about.getCreatedAt();
        updatedAt = about.getUpdatedAt();

        AboutResponseDTO aboutResponseDTO = new AboutResponseDTO( id, title, description, icon, color, createdAt, updatedAt );

        return aboutResponseDTO;
    }

    @Override
    public About toEntity(AboutRequestDTO aboutRequestDTO) {
        if ( aboutRequestDTO == null ) {
            return null;
        }

        About.AboutBuilder about = About.builder();

        about.title( aboutRequestDTO.getTitle() );
        about.description( aboutRequestDTO.getDescription() );
        about.icon( aboutRequestDTO.getIcon() );
        about.color( aboutRequestDTO.getColor() );

        return about.build();
    }

    @Override
    public void updateEntityFromDto(AboutRequestDTO dto, About about) {
        if ( dto == null ) {
            return;
        }

        about.setTitle( dto.getTitle() );
        about.setDescription( dto.getDescription() );
        about.setIcon( dto.getIcon() );
        about.setColor( dto.getColor() );
    }
}

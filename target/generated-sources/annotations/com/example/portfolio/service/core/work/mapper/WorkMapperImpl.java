package com.example.portfolio.service.core.work.mapper;

import com.example.portfolio.service.core.work.dto.request.WorkRequestDTO;
import com.example.portfolio.service.core.work.dto.response.WorkResponseDTO;
import com.example.portfolio.service.core.work.model.Work;
import java.time.LocalDateTime;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-11-09T18:12:33+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 24.0.1 (Oracle Corporation)"
)
@Component
public class WorkMapperImpl implements WorkMapper {

    @Override
    public WorkResponseDTO toResponseDTO(Work work) {
        if ( work == null ) {
            return null;
        }

        String id = null;
        String role = null;
        String company = null;
        String duration = null;
        String description = null;
        String color = null;
        LocalDateTime createdAt = null;
        LocalDateTime updatedAt = null;

        id = work.getId();
        role = work.getRole();
        company = work.getCompany();
        duration = work.getDuration();
        description = work.getDescription();
        color = work.getColor();
        createdAt = work.getCreatedAt();
        updatedAt = work.getUpdatedAt();

        WorkResponseDTO workResponseDTO = new WorkResponseDTO( id, role, company, duration, description, color, createdAt, updatedAt );

        return workResponseDTO;
    }

    @Override
    public Work toEntity(WorkRequestDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Work.WorkBuilder work = Work.builder();

        work.role( dto.getRole() );
        work.company( dto.getCompany() );
        work.duration( dto.getDuration() );
        work.description( dto.getDescription() );
        work.color( dto.getColor() );

        return work.build();
    }

    @Override
    public void updateEntityFromDto(WorkRequestDTO dto, Work work) {
        if ( dto == null ) {
            return;
        }

        work.setRole( dto.getRole() );
        work.setCompany( dto.getCompany() );
        work.setDuration( dto.getDuration() );
        work.setDescription( dto.getDescription() );
        work.setColor( dto.getColor() );
    }
}

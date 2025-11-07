package com.example.portfolio.service.core.user.mapper;

import com.example.portfolio.service.core.user.dto.request.RegisterRequestDTO;
import com.example.portfolio.service.core.user.dto.response.RegisterResponseDTO;
import com.example.portfolio.service.core.user.model.User;
import java.time.LocalDateTime;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-11-07T11:02:27+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 24.0.1 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public User toEntity(RegisterRequestDTO dto) {
        if ( dto == null ) {
            return null;
        }

        User user = new User();

        user.setFullName( dto.getFullName() );
        user.setEmail( dto.getEmail() );
        user.setPassword( dto.getPassword() );

        return user;
    }

    @Override
    public RegisterResponseDTO toResponse(User user) {
        if ( user == null ) {
            return null;
        }

        String id = null;
        String fullName = null;
        String email = null;
        String role = null;
        LocalDateTime createdAt = null;
        LocalDateTime updatedAt = null;

        id = user.getId();
        fullName = user.getFullName();
        email = user.getEmail();
        role = user.getRole();
        createdAt = user.getCreatedAt();
        updatedAt = user.getUpdatedAt();

        Boolean status = null;

        RegisterResponseDTO registerResponseDTO = new RegisterResponseDTO( id, fullName, email, role, status, createdAt, updatedAt );

        return registerResponseDTO;
    }
}

package com.example.portfolio.service.core.about.dto.response;

/*
    record :: JAVA 16+ ile gelen immutable değiştirilemez
    veri objeleri dto oluşturmak için kullanılır
    immutable bir class oluşturmak için kullanılır
    immutable : tüm alanları final olarak tanımlanır: değiştirilemez
    immutable : constructor ile tanımlanır
    kısa ve temiz : getter,equals,hashcode,toString,compare,clone gibi methodlar otomatik olarak tanımlanır
 Kod daha okunabilir ve kısa olur.

Immutable yapısı sayesinde hata olasılığı düşer.

Clean Architecture prensipleriyle uyumludur: veri taşıma objeleri domain’i kirletmez.

Pattern matching ve switch expressions ile daha rahat çalışır.
 */

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;

// Null alanlar frontende iletilmez.
@JsonInclude(JsonInclude.Include.NON_NULL)
@Schema(description = "About Response DTO")
public record AboutResponseDTO(

        @Schema(description = "About ID", example = "1")
        String id,
        @Schema(description = "About Title", example = "About Title")
        String title,
        @Schema(description = "About Description", example = "About Description")
        String description,

        @Schema(description = "About Icon", example = "About Icon")
        String icon,
        @Schema(description = "About Color", example = "About Color")
        String color,

        @JsonFormat(pattern = "dd-MM-YYYY")
        @Schema(description = "About Created At", example = "05-11-2025")
        LocalDateTime createdAt,

        @JsonFormat(pattern = "dd-MM-YYYY")
        @Schema(description = "About Updated At", example = "05-11-2025")
        LocalDateTime updatedAt) {
}

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

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;

import java.time.LocalDateTime;

// Null alanlar frontende iletilmez.
@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
public record AboutResponseDTO(String id, String title, String description,
                               String icon, String color,
                               LocalDateTime createdAt,LocalDateTime updatedAt) {
}

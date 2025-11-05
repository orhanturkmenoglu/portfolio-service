package com.example.portfolio.service;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@RequiredArgsConstructor
public class PortfolioServiceApplication {

	private final   CacheManager cacheManager;
	public static void main(String[] args) {
		SpringApplication.run(PortfolioServiceApplication.class, args);


		/**
		 *  COMMON :Config ve yardımcı sınıflar buraya gelecek.  # DTO, Utils, Enums, Config (JWT, Swagger, CORS, DB vs.)
		 *  CORE : MODÜL # Domain + Application (Use Cases) → tamamen iş mantığı burada
		 * infrastructure  # DB, API client, repository implementasyonları
		 *presentation    # REST Controller / GraphQL
		 *
		 */

		/**
		 * Bu yapıyla:
		 *
		 * common → tüm modüllerin eriştiği genel konfigürasyonlar.
		 *
		 * core → domain ve business logic (DDD + Clean Arch prensibi).
		 *
		 * infrastructure → veri ve dış servis bağlantıları.
		 *
		 * presentation → REST API (frontend ile konuşur).
		 */
	}

}

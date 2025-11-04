package com.example.portfolio.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PortfolioServiceApplication {

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
